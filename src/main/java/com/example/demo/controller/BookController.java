package com.example.demo.controller;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@RestController
@RequestMapping(value = "/b")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping(value = "/new")
	public String saveData() {
		return null;

		/*
		 * INSERT INTO book VALUES(1,'Bio',350.0,1); INSERT INTO book
		 * VALUES(2,'Maths',500.0,2);
		 */
	}

	@GetMapping(value = "/books")
	public List<Book> getAllBooks() {

		return bookRepository.findAll();

	}

}
