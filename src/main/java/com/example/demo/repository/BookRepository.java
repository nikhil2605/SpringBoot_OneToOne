package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByBookNameIgnoreCase(String bookName);
	public List<Book> findByBookNameStartsWith(String bookName);
	public List<Book> findByBookNameEndingWith(String bookName);
	public List<Book> findByBookNameContaining(String bookName);
	public List<Book> findByBookNameLike(String bookNamePattern);
	
	public List<Book> findByAuthorFirstName(String authorName);
	public List<Book> findByAuthorFirstNameIgnoreCase(String authorName);

	public List<Book> findTop2ByPriceGreaterThan(double price);
	public List<Book> findByPriceGreaterThan(double price);
	public List<Book> findByPriceGreaterThanEqual(double price);	
	public List<Book> findByPriceLessThan(double price);
	public List<Book> findByPriceLessThanEqual(double price);
	public List<Book> findByPriceBetween(double price1, double price2);

}
