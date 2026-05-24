package com.project.dev.webapp.concepts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
		     // 403 Forbidden - unless we send a CSRF token.
			.csrf(csrf -> csrf.disable())
			
			 // To authenticate every request
			.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
			
			 // Spring will not use 'UsernamePasswordAuthenticationFilter' and will make use of 'BasicAuthenticationFilter'
			 // spring.security.user.name and spring.security.user.password - Add these two
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}

	@Bean
	AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
		return new ProviderManager(daoAuthenticationProvider);
	}

}
