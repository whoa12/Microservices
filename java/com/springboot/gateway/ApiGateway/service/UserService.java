package com.springboot.gateway.ApiGateway.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.springboot.gateway.ApiGateway.entities.Users;
import com.springboot.gateway.ApiGateway.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepo repo;
	private final AuthenticationManager authManager;
	private final JwtService jwtService;
	
	public Users register(Users user) {
		return repo.save(user);
	}

	public String verify(Users user) {
	  Authentication authentication =
			  authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	  if(authentication.isAuthenticated()) {
		  return jwtService.generateToken(user.getUsername());
	  }
	  return "fail";
	}

	

}
