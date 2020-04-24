package com.security.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.config.Authenticator;
import com.security.config.JWTMockUtil;
import com.security.config.JWTUtil;
import com.security.config.Token;
import com.security.config.TokenRequestData;

@RestController
@RequestMapping("/token")
public class TokenController {
	JWTUtil jwtUtil = new JWTMockUtil();
	// JWTUtil jwtUtil = new JWTHelper();
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> getToken(@RequestBody TokenRequestData tokenRequestData) {
		
		String username = tokenRequestData.getUsername();
		String password = tokenRequestData.getPassword();
		String scopes = tokenRequestData.getScopes();
		
		System.out.println("Token user=" + username + " password="+password+" scopes="+scopes);
		if (username != null && username.length() > 0 
				&& password != null && password.length() > 0 
				&& Authenticator.checkPassword(username, password)) {
			Token token = jwtUtil.createToken(scopes);
			ResponseEntity<?> response = ResponseEntity.ok(token);
			
			System.out.println("Token created = " + token);
			return response;			
		}
		// bad request
		System.out.println("Failed authentication");
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	
	
}