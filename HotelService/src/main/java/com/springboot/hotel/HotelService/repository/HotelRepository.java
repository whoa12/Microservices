package com.springboot.hotel.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hotel.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
