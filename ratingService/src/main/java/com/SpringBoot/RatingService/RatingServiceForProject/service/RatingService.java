package com.SpringBoot.RatingService.RatingServiceForProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.RatingService.RatingServiceForProject.entities.Rating;
import com.SpringBoot.RatingService.RatingServiceForProject.repository.RatingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingService implements IRatingService {
	private final RatingRepository repository;

	@Override
	public Rating addRating(Rating rating) {
		// TODO Auto-generated method stub
		return repository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings(Rating rating) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserid(String id) {
		// TODO Auto-generated method stub
		return repository.findByUserId(id);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String id) {
		// TODO Auto-generated method stub
		return repository.findByHotelId(id);
	}

}
