package com.springboot.gateway.ApiGateway.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.gateway.ApiGateway.entities.Userprincipal;
import com.springboot.gateway.ApiGateway.entities.Users;
import com.springboot.gateway.ApiGateway.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService{
//	private final UserRepo repo;
//	
//	public MyUserDetailsService(UserRepo repo) {
//		this.repo = repo;
//	} better use lombok
	private final UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		
		}
		return new Userprincipal(user);
	}
	
	
	

}
