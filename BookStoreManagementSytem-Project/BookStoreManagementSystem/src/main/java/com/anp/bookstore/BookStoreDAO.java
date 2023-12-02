package com.anp.bookstore;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BookStoreDAO {

    private final EntityManager entityManager;

    public BookStoreDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(BookStore bookStore) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bookStore);
            entityManager.getTransaction().commit();
        }   
        catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateBookStore(int id, String title, String author, String stock, double price) {
        try {
            entityManager.getTransaction().begin();
            BookStore bookStore = entityManager.find(BookStore.class, id);
            if (bookStore != null) {
                bookStore.setTitle(title);
                bookStore.setAuthor(author);
                bookStore.setStock(stock);
                bookStore.setPrice(price);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        try {
            entityManager.getTransaction().begin();
            BookStore bookStore = entityManager.find(BookStore.class, id);
            if (bookStore != null) {
                entityManager.remove(bookStore);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Optional<BookStore> findById(int id) {
        BookStore bookStore = entityManager.find(BookStore.class, id);
        return Optional.ofNullable(bookStore);
    }

    public List<BookStore> findAll() {
        return entityManager.createQuery("from BookStore", BookStore.class).getResultList();
    }
}
