package com.springsecurity.springsecurity.controllers;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	
	@GetMapping(path = "/hello")
	public String hello()
	{
		return "Hello";
	}
	
	@GetMapping(path = "/hello1")
	public String hello1()
	{
		return "Hello1";
	}
	
	@PostMapping(path = "/hello/{name}")
	public String hello3(@PathVariable String name)
	{
		return "hello" + name;
	}
	
	//if csrf token is enabled then for update request csrf token required
	// in case of read request csrf token is not required
	@GetMapping(path="/retrievecsrftoken")
	public CsrfToken retrieveCSRF(HttpServletRequest request)
	{
		return (CsrfToken)request.getAttribute("_csrf");
	}
}
