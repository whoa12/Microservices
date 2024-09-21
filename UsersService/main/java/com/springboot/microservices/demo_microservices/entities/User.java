package com.springboot.microservices.demo_microservices.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "micro-users")
@NoArgsConstructor
@AllArgsConstructor
public class User { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "ID")
	private String id;
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	
	@Transient  //tells that this doesnt have to included in the existing database
	private List<Rating> ratingsByUsers = new ArrayList<>();
	

}
