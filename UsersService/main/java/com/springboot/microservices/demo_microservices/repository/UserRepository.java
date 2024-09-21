package com.springboot.microservices.demo_microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.sbr_demo.model.Student;
import com.springboot.microservices.demo_microservices.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByEmail(String email);
	


}
