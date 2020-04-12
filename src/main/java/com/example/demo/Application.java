package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.AuthorRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	AuthorRepository userRepository;
	
	/*
	 * @PostConstruct public void postConstructMethod() { User user1 = new
	 * User("ndhiwar63@gmail.com","Nikhil"); userRepository.save(user1);
	 * 
	 * User user2 = new User("ramkole@gmail.com","Ram"); userRepository.save(user2);
	 * }
	 */
}
