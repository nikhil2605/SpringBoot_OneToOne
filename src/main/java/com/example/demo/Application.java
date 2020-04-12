package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookRepository bookRepository;

	@PostConstruct
	public void postConstructMethod() {
		Author author1 = new Author("ndhiwar63@gmail.com", "Nikhil");
		authorRepository.save(author1);

		Author author2 = new Author("ndhiwar8@gmail.com", "Raj");
		authorRepository.save(author2);
		
		Book book1 = new Book("Math", 350.0, author1);
		Book book2 = new Book("Bio", 700.0, author1);
		bookRepository.save(book1);
		bookRepository.save(book2);
		
		Book book3 = new Book("Physics", 100.0, author2);
		Book book4 = new Book("Chemistry", 200.0, author2);
		bookRepository.save(book3);
		bookRepository.save(book4);
		
	}

}
