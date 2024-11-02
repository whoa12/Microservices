package com.springboot.hotel.HotelService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hotel.HotelService.entities.Hotel;
import com.springboot.hotel.HotelService.service.IHotelServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
	
	private final IHotelServiceImpl service;
	
	@PostMapping
	private ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel createdHotel = service.addHotel(hotel);
		return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	private ResponseEntity<List<Hotel>> getAllHotels(){
		return new ResponseEntity<>(service.getHotels(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Hotel> findHotelById(@PathVariable String id){
		return new ResponseEntity<>(service.getHotelById(id), HttpStatus.OK);
	}
	

}
