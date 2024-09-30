package com.spring.implementation.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.implementation.DTO.UserDTO;
import com.spring.implementation.helper.Utility;
import com.spring.implementation.model.User;
import com.spring.implementation.service.UserService;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/v1/api/")
public class DashboardController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        // Check if email already exists
        if (userService.existsByEmail(userDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
        // Validate email and password
        if (userDTO.getEmail().isEmpty() || userDTO.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email and password are required");
        }
        // Validate email format
        String emailAddress = userDTO.getEmail();
        String regexPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(emailAddress);
        if (!matcher.matches()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email address");
        }

        // Hash password and save user
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(hashedPassword);
        userService.save(user);

        return ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        User user = userService.findByEmail(userDTO.getEmail());
        if (user == null || !passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        return ResponseEntity.ok("Login successful");
    }
    
    @PostMapping("/forgot-password")
	public String processForgotPassword(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    String email = request.getParameter("email");

	    try {
	        // Check if the email is registered
	        User user = userService.findByEmail(email);
	        if (user == null) {
	            redirectAttributes.addFlashAttribute("error", "No account found with that email address.");
	            return "redirect:/forgot-password";
	        }

	        // Generate a token and send the reset password link
	        String token = RandomString.make(30);
	        userService.updateResetPasswordToken(token, email);
	        String resetPasswordLink = Utility.getSiteURL(request) + "/reset-password?token=" + token;
	        sendEmail(email, resetPasswordLink);

	        redirectAttributes.addFlashAttribute("message", "We have sent a reset password link to your email. Please check your email.");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("error", "Error occurred while sending email.");
	    }

	    return "redirect:/forgot-password";
	}


    public void sendEmail(String recipientEmail, String link) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("rtanver30@gmail.com", "Enlighten Drashta");
        helper.setTo(recipientEmail);

        String subject = "Reset Password Link";
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you remember your password or did not request a password change.</p>";

        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }


    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestBody UserDTO userDTO) {
        String password = userDTO.getPassword();
        User user = userService.getByResetPasswordToken(token);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        // Hash and update password
        String hashedPassword = passwordEncoder.encode(password);
        userService.updatePassword(user, hashedPassword);

        return ResponseEntity.ok("Password updated successfully");
    }
  
    
}
