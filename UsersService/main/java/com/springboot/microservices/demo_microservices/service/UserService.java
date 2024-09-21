package com.springboot.microservices.demo_microservices.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.springdemo.sbr_demo.exceptions.ResourceNotFoundException;
import com.springboot.microservices.demo_microservices.entities.Hotel;
import com.springboot.microservices.demo_microservices.entities.Rating;
import com.springboot.microservices.demo_microservices.entities.User;
import com.springboot.microservices.demo_microservices.external.HotelService;
import com.springboot.microservices.demo_microservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // Use Lombok's logging
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;
    
    private final HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(String id) {
        User user = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        // Fetching ratings using RestTemplate with parameterized type
        Rating[] ratingsArray = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getId(), Rating[].class);
        List<Rating> ratings = Arrays.asList(ratingsArray);

        log.info("Response from ratings service: {}", ratings);

        // Enriching each rating with hotel information
        List<Rating> enrichedRatings = ratings.stream().map(rating -> {
            // Fetch the hotel details for each rating
//            ResponseEntity<Hotel> responseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = responseEntity.getBody(); eureka method
        	Hotel hotel = hotelService.getHotel(rating.getHotelId());

            // Set the hotel in the rating object
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        // Set the enriched ratings in the user object
        user.setRatingsByUsers(enrichedRatings);

        return user;
    }
}
