package com.spring.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.implementation.DTO.UserDTO;
import com.spring.implementation.DTO.UserLoginDTO;
import com.spring.implementation.helper.Utility;
import com.spring.implementation.model.User;
import com.spring.implementation.service.UserDetailsServiceImpl;
import com.spring.implementation.service.UserService;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Controller
public class UserController {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JavaMailSender mailSender;

	// @Autowired
	// EmailService emailService;

	@Autowired
	UserService userService;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping("/register")
	public String saveUser(@ModelAttribute UserDTO userDTO) {
		User user = userDetailsService.save(userDTO);
		if (user != null) {
			return "redirect:/login";
		} else {
			return "redirect:/register";
		}
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public void login(@ModelAttribute UserLoginDTO userLoginDTO, Model model) {
		userDetailsService.loadUserByUsername(userLoginDTO.getUsername());
	}

	@GetMapping("/dashboard")
	public String showUserDashboardForm(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // Get the logged in user

		if (principal instanceof UserDetails) { // If the user is logged in
			String username = ((UserDetails)principal).getUsername(); // Get the username of the logged in user
			User user = userService.findByEmail(username); // Get the user details from the database
			model.addAttribute("user", user); // Add the user details to the model
		}

		return "dashboard";
	}

	@GetMapping("/forgot-password")
	public String showForgotPasswordForm() {
		return "forgotPassword";
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
		// emailService.sendEmail(recipientEmail, "Reset your password", "To reset your password, click the link below:\n" + link); {
		// }
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom("rtanver30@gmail.com", "Enlighten Drashta");
		helper.setTo(recipientEmail);

		String subject = "Here's the link to reset your password";

		String content = "<p>Hello,</p>"
				+ "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>"
				+ "<p><a href=\"" + link + "\">Change my password</a></p>"
				+ "<br>"
				+ "<p>Ignore this email if you do remember your password, or you have not made the request.</p>";

		helper.setSubject(subject);
		helper.setText(content, true);
		mailSender.send(message);
	}

	@GetMapping("/reset-password")
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
    User user = userService.getByResetPasswordToken(token);
    model.addAttribute("token", token);

    if (user == null) {
        model.addAttribute("message", "Invalid Token");
        return "message";
    }

    return "resetPassword";
	}

	@PostMapping("/reset-password")
	public String processResetPassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");

		User user = userService.getByResetPasswordToken(token);
		model.addAttribute("title", "Reset your password");

		if (user == null) {
			model.addAttribute("message", "Invalid Token");
			return "resetPassword";
		} else {
			userService.updatePassword(user, password);

			model.addAttribute("message", "You have successfully changed your password.");
		}

		return "redirect:/login";
	}

}
