package com.security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
	
	@GetMapping
	public String validateCredentials(String user, String password) {
		return "JWT Token";
	}
	
	
	
	
}
