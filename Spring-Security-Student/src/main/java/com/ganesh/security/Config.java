package com.ganesh.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ganesh.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class Config {
	
	
	private final CustomUserDetailsService customUserDetailsService;
	
	
	public Config(CustomUserDetailsService customUserDetailsService) {
		
		this.customUserDetailsService=customUserDetailsService;
	}
	
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticateUser() {
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(customUserDetailsService);
		
		provider.setPasswordEncoder(encoder());
		
		return provider;
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		
		http.csrf(csrf->csrf.disable());
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests(auth->{
			
			auth.requestMatchers("/api/v1/student/save").hasRole("ADMIN")
			
			    .requestMatchers("/api/v1/student/all").hasAnyRole("ADMIN", "USER")
			    
			    .requestMatchers("/api/v1/student/byid/**").hasAnyRole("ADMIN", "USER")
			    
			    .requestMatchers("/api/v1/student/updatebyid/**").hasRole("ADMIN")
			    
			    .requestMatchers("/api/v1/student/deletebyid/**").hasAnyRole("ADMIN")
			    
			    .requestMatchers("/auth/create-user").permitAll();    
		});
		
		return http.build();
	}
	

}
