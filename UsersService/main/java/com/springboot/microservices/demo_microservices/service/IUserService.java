package com.springboot.microservices.demo_microservices.service;

import java.util.List;

import com.springboot.microservices.demo_microservices.entities.User;

public interface IUserService {
	User addUser(User user);
	List<User> getAllUsers();
	User getUserById(String id);



}
