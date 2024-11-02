package com.springboot.hotel.HotelService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springboot.hotel.HotelService.entities.Hotel;
import com.springboot.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.springboot.hotel.HotelService.repository.HotelRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements IHotelServiceImpl{
	
	private final HotelRepository repository;

	@Override
	public Hotel addHotel(Hotel hotel) {
	   String hotelId = UUID.randomUUID().toString();
	   hotel.setId(hotelId);
		
		return repository.save(hotel);
	}

	@Override
	public List<Hotel> getHotels() {
		return repository.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
	    return repository.findById(id)
	    		.orElseThrow(()->new ResourceNotFoundException("Not available" +id));
	    		
	
	
	}
}
