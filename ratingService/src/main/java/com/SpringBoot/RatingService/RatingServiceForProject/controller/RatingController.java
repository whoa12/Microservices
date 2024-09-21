package com.SpringBoot.RatingService.RatingServiceForProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.RatingService.RatingServiceForProject.entities.Rating;
import com.SpringBoot.RatingService.RatingServiceForProject.service.RatingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {
	private final RatingService ratingService;
	@PostMapping
	private ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating createdRating = ratingService.addRating(rating);
		return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/users/{id}")
	private ResponseEntity<List<Rating>> findRatingsByUserId(@PathVariable String id){
		return new ResponseEntity<>(ratingService.getRatingsByUserid(id), HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{id}")
	private ResponseEntity<List<Rating>> findRatingsByHotelId(@PathVariable String id){
	return ResponseEntity.ok(ratingService.getRatingsByHotelId(id));
	}	
	
	

	

}
