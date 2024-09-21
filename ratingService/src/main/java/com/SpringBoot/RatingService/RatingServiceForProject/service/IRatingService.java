package com.SpringBoot.RatingService.RatingServiceForProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.RatingService.RatingServiceForProject.entities.Rating;

@Service
public interface IRatingService {
	//create
	Rating addRating(Rating rating);
	
	//get all ratings
	List<Rating> getAllRatings(Rating rating);
	
	
	//get rating by id
	List<Rating> getRatingsByUserid(String id);
	
	//Rating by hotel id
	List<Rating> getRatingsByHotelId(String id);
	
	
      
     
      

}
