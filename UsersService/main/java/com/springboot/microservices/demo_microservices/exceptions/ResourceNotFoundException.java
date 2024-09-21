package com.springboot.microservices.demo_microservices.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String msg) {
		super(msg);
		
	}

}
