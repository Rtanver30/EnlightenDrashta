package com.spring.implementation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.implementation.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurity {


		    @Autowired
		    private UserDetailsServiceImpl userDetailsService;

		    @Bean
		    public BCryptPasswordEncoder passwordEncoder() {
		        return new BCryptPasswordEncoder();
		    }

			@Bean
		    public DaoAuthenticationProvider authenticationProvider() {
		        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		        auth.setUserDetailsService(userDetailsService);
		        auth.setPasswordEncoder(passwordEncoder());
		        return auth;
		    }

			public AuthenticationManager authenticationManager(AuthenticationConfiguration
					authenticationConfiguration) throws Exception {
		        return authenticationConfiguration.getAuthenticationManager();
		    }

		    @Bean
		    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		        // http.authorizeRequests()
		        //     .antMatchers("/register","/forgotPassword","/resetPassword/**").permitAll()
		        //     .anyRequest().authenticated()
		        //     .and()
		        //     .formLogin()
		        //     .loginPage("/login").defaultSuccessUrl("/userDashboard")
		        //     .permitAll()
		        //     .and()
		        //     .logout()
		        //     .permitAll();

		        // http.csrf().disable();
		        // http.headers().defaultsDisabled().cacheControl();
				http
					.csrf().disable()
					.csrf().disable()
					.exceptionHandling()
					.and()
					.authorizeRequests()
					.requestMatchers("register","forgotPassword","resetPassword/**", "resetPassword").permitAll()
					 .requestMatchers("/image/**").permitAll()
                     .requestMatchers("/js/**").permitAll()
                     .requestMatchers("/css/**").permitAll()
                     .requestMatchers("/IT/**").permitAll()
                     .requestMatchers("/ITI/**").permitAll()
                     .requestMatchers("/team").permitAll()
                     .requestMatchers("/lib/**").permitAll()
                     .requestMatchers("/_files/**").permitAll()
                     .requestMatchers("/img/**").permitAll()
                     .requestMatchers("/public/**").permitAll()

                     .requestMatchers("/js").permitAll()
                     .requestMatchers("/","/Home","/index", "/contact", "/register", "/logins", "/logout" ).permitAll()
                     .requestMatchers("/history", "/polity", "/hindi", "/economics", "/public administration","/chemistry","/physics","/agriculture","/maths","/biology" ).permitAll()
                     .requestMatchers("/itimain", "/special", "/fitter", "/take_quiz", "/electronics","/test2","/machinist","/agriculture","/electrician","/test","/copa","/copaquiz","/networking","/welder","/test4","/tarner","/test3","/beautician","/carpenter" ).permitAll()
                     .requestMatchers("/web_design", "/GovtMain", "/UPSC_Civil_Services", "/Banking_Exams_Preparation", "/SSC_Exam_Preparation","/Railways_Exam_Preparation","/State_PCS_Exam_Preparation","/Defence_Exam_Preparation").permitAll()
                     .requestMatchers("/aws","/python","/java","/php","/mysql","/excel").permitAll()

                     .requestMatchers("/Student").permitAll()
					.anyRequest().permitAll()
					.and()
					.formLogin()
					.loginPage("/login").defaultSuccessUrl("/dashboard")
					.permitAll()
					.and()
					.logout()
					.permitAll();

				return http.build();

		    }

}
