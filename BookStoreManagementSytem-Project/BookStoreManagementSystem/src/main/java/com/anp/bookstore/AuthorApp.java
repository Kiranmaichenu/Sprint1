package com.anp.bookstore;

	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.Persistence;
	import java.util.List;

	public class AuthorApp {

	    public static void main(String[] args) {
	        // Create EntityManagerFactory using the persistence unit name "km"
	        EntityManagerFactory factory = null;

	        try {
	            // Create EntityManagerFactory using the persistence unit name "km"
	            factory = Persistence.createEntityManagerFactory("km");
	            // Create EntityManager, which is used for database operations
	            EntityManager em = factory.createEntityManager();

	            System.out.println("____WELCOME TO AUTHOR APPLICATION___");

	            // Creating instances of AuthorDAO
	            AuthorDAO authorDAO = new AuthorDAO(em);

	            // Save some authors
	            Author author1 = new Author();
	            author1.setName("John Doe");

	            Author author2 = new Author();
	            author2.setName("Jane Doe");

	            authorDAO.saveAuthor(author1);
	            authorDAO.saveAuthor(author2);

	            // Retrieve and print all authors
	            List<Author> allAuthors = authorDAO.findAllAuthors();
	            System.out.println("All Authors: " + allAuthors);

	            // Update an author's name
	            Author updatedAuthor = authorDAO.findAuthorById(1).orElse(null);
	            if (updatedAuthor != null) {
	                updatedAuthor.setName("Updated Author");
	                authorDAO.updateAuthor(updatedAuthor);
	            }

	            // Remove an author
	            authorDAO.removeAuthor(2);

	            // Retrieve and print all authors after updates
	            List<Author> updatedAuthors = authorDAO.findAllAuthors();
	            System.out.println("Updated Authors: " + updatedAuthors);

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Exception");
	        } finally {
	            // Close the EntityManagerFactory in the finally block to release resources
	            if (factory != null) {
	                factory.close();
	            }
	        }
	    }
	}



