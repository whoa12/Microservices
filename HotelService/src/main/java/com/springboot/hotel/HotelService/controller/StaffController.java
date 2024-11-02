package com.springboot.hotel.HotelService.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class StaffController {
	
	@GetMapping("/staffs")
	public ResponseEntity<List<String>> getStaffs(){
		List<String> list = Arrays.asList("Aman", "Sagar", "Baman", "Chaman");
		 return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
