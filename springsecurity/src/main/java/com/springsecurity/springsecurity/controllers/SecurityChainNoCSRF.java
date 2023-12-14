package com.springsecurity.springsecurity.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Controller
public class SecurityChainNoCSRF {

	/*
	 * if i want to disable csrf token then 
	 * i have to configure entire security chain.
	 * 
	 */
	@Bean
	SecurityFilterChain basicsecurityfilterchain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		http.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.httpBasic();
		http.csrf().disable();
		return http.build();
	}
}
