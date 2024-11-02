package com.springboot.hotel.HotelService.service;

import java.util.List;

import com.springboot.hotel.HotelService.entities.Hotel;

public interface IHotelServiceImpl {
	public Hotel addHotel(Hotel hotel);
	public List<Hotel> getHotels();
	public Hotel getHotelById(String id);
	
	

}
