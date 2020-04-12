package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping(value = "/books")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
		Book book = bookRepository.save(newBook);

		ResponseEntity<Book> response = new ResponseEntity<Book>(book, HttpStatus.CREATED);
		return response;
	}
	

	@RequestMapping(value = "/books/name/{title}", method = RequestMethod.GET)
	public List<Book> getBookByName(@PathVariable("title") String bookName) {		
		return bookRepository.findByBookNameIgnoreCase(bookName);
	}
	
	@RequestMapping(value = "/books/author/{title}", method = RequestMethod.GET)
	public List<Book> getBookByAuthorName(@PathVariable("title") String authorName) {		
		return bookRepository.findByAuthorFirstNameIgnoreCase(authorName);
	}

	@RequestMapping(value = "/books/price/{amount}", method = RequestMethod.GET)
	public List<Book> getBookByPrice(@PathVariable("amount") double price) {		
		return bookRepository.findTop2ByPriceGreaterThan(price);
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> updateUser(@PathVariable("id") Long id,@RequestBody Book oldBookDetails) {
		
		if(bookRepository.existsById(id)==false) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		Book book = bookRepository.save(oldBookDetails);
		ResponseEntity<Book> response = new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
		return response;
	}
	
	


}
