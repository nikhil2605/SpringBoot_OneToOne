package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "mail", nullable = false)
	private String email;

	@Column(name = "first_name", nullable = true, length = 10)
	private String firstName;

	@OneToMany(mappedBy = "author")
	private List<Book> bookList;

	public Author() {
		super();
	}

	public Author(String email, String firstName) {
		this.email = email;
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Author(List<Book> bookList) {
		super();
		this.bookList = bookList;
	}

}
