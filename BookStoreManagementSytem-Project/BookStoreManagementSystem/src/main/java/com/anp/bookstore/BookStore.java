package com.anp.bookstore;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name="BookStore")
public class BookStore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	private String title;
	
	
	@Column(name= "book_author")
	private String author;
	
	
	private String stock;
	
	private double price;
	
	public int getId() {
		return id;
	}
	
	public BookStore(int id, String title, String author, String stock, double price) {
		
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.stock = stock;
		this.price = price;
		
	}
	public int getid() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getStock() {
		return stock;
	}
	
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public double getPrice() {
		return price;
	}
	
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "BookStore [id=" + id + ", title=" + title + ", author=" + author + ", stock=" + stock + ", price=" + price
				+ "]";
	}
	
	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
	}

	}
