package com.anp.bookstore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class BookMain {

    public static void main(String[] args) {
        EntityManagerFactory factory = null;

        try {
            factory = Persistence.createEntityManagerFactory("km");
            EntityManager em = factory.createEntityManager();

            System.out.println("____WELCOME TO BOOK STORE___");

            BookStore book1 = new BookStore(1, "Corejava", "James Gosling", "100", 700.0);
            BookStore book2 = new BookStore(2, "Polity", "Lakhmikanth", "200", 800.0);
            BookStore book3 = new BookStore(3, "Environment", "shankar", "300", 900.0);

            BookStoreDAO bookdao = new BookStoreDAO(em);
            bookdao.save(book1);
            bookdao.save(book2);
            bookdao.save(book3);
            System.out.println("BookStore is created successfully ");

            // Make sure to define these variables appropriately
            int newid = 1;
            String newtitle = "UpdatedTitle";
            String newauthor = "UpdatedAuthor";
            String newstock = "UpdatedStock";
            double newprice = 1000.0;

            bookdao.updateBookStore(newid, newtitle, newauthor, newstock, newprice);
            System.out.println("BookStore is updated successfully ");

            System.out.println("--------------");

            System.out.println("BookStore details based on id:");
            Optional<BookStore> bookById = bookdao.findById(1);
            System.out.println(bookById);

            System.out.println("------------");

            System.out.println("Details of all the bookstore");
            List<BookStore> allBooks = bookdao.findAll();
            System.out.println(allBooks);

            System.out.println("Removing based on id:");
            bookdao.remove(2);
            System.out.println("2nd record is removed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}

           