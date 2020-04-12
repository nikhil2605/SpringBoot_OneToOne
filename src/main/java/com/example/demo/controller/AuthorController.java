package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@RestController
@RequestMapping(value = "/a")
public class AuthorController {

	@Autowired
	private AuthorRepository userRepository;

	@GetMapping(value = "/new")
	public String saveData() {
		Author user1 = new Author("ndhiwar63@gmail.com", "Nikhil");
		userRepository.save(user1);

		Author user2 = new Author("ndhiwar8@gmail.com", "Raj");
		userRepository.save(user2);
		return "Author create sucessfully.";
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public List<Author> getUsers() {
		return (List<Author>) userRepository.findAll();
	}

	@GetMapping(value = "/authors/{id}")
	public Optional<Author> getUserById(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}
	
	@RequestMapping(value = "/authors",method = RequestMethod.POST)
	public ResponseEntity<Author> createUser(@RequestBody Author newUser) {
		Author user = userRepository.save(newUser);
		
		ResponseEntity<Author> response = new ResponseEntity<Author>(user,HttpStatus.CREATED);
		return response;
		
	}
	
	@RequestMapping(value = "/authors",method = RequestMethod.PUT)
	public ResponseEntity<Author> updateUser(@RequestBody Author oldUser) {
		Author user = userRepository.save(oldUser);
		
		ResponseEntity<Author> response = new ResponseEntity<Author>(user,HttpStatus.ACCEPTED);
		return response;
		
	}
	
	@RequestMapping(value = "/authors/{id}",method = RequestMethod.PATCH)
	public ResponseEntity<Author> patchUser(@PathVariable("id") Long id, @RequestBody Author changeUser) {
		boolean result = userRepository.existsById(id);
		Author user=null;
		ResponseEntity<Author> response = null;
		if(result == true) {
			user = userRepository.save(changeUser);
			 response = new ResponseEntity<Author>(user,HttpStatus.ACCEPTED);
		}else {
			response = new ResponseEntity<Author>(user,HttpStatus.NOT_FOUND);
		}
		
		return response;	
	}
	
	@RequestMapping(value = "/authors/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		boolean result = userRepository.existsById(id);
		ResponseEntity<String> response = null;
		if(result == true) {
			userRepository.deleteById(id);			  
			response =  new ResponseEntity<String>("User Deleted",HttpStatus.ACCEPTED);
		}else {
			response = new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
		}		
		return response;	
	}
}
