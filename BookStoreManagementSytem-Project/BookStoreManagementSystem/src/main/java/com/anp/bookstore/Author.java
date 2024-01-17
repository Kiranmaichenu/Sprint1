package com.anp.bookstore;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Author {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    // One Author can have Many Books
	    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	    private List<BookStore> books;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<BookStore> getBooks() {
			return books;
		}
		public void setBooks(List<BookStore> books) {
			this.books = books;
		}
		@Override
		public String toString() {
			return "Author [id=" + id + ", name=" + name + ", books=" + books + "]";
		}
		public Author() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Author(int id, String name, List<BookStore> books) {
			super();
			this.id = id;
			this.name = name;
			this.books = books;
		}
		
	    
	}
