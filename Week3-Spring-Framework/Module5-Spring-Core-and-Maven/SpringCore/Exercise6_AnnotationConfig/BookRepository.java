package com.library.repository;

import org.springframework.stereotype.Repository;

// Exercise 6: @Repository annotation for component scanning
@Repository
public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("BookRepository: Saving book -> " + bookTitle);
    }

    public String findById(int id) {
        return "Book-" + id;
    }

    public void delete(int id) {
        System.out.println("BookRepository: Deleting book with id -> " + id);
    }
}
