package com.springboot.gateway.ApiGateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.gateway.ApiGateway.entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, String> {
	Users findByUsername(String username);// findByUsername tells Spring Data JPA to create a query to find a Users entity where the username field matches the provided parameter.
	

}
