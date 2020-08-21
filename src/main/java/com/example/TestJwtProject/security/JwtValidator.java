package com.example.TestJwtProject.security;

import org.springframework.stereotype.Component;

import com.example.TestJwtProject.constant.Constants;
import com.example.TestJwtProject.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	public JwtUser Validate(String token) {
		JwtUser jwtUser = null;
		
		try {
			Claims body = Jwts.parser()
					.setSigningKey(Constants.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			 jwtUser = new JwtUser();
			 jwtUser.setUserName(body.getSubject());
			 jwtUser.setId(Long.parseLong((String) body.get(Constants.USER_ID)));
			 jwtUser.setRole((String) body.get(Constants.ROLE));
			 
		} catch (Exception e) {
			System.out.println("Jwt invalido: "+e.getMessage());
		}
		
		return jwtUser;
	}
}
