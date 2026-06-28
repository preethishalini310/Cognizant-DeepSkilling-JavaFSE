package com.library.repository;

// Exercise 1: BookRepository class defined as a Spring bean
public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("BookRepository: Saving book -> " + bookTitle);
    }

    public String findById(int id) {
        System.out.println("BookRepository: Finding book with id -> " + id);
        return "Book-" + id;
    }

    public void delete(int id) {
        System.out.println("BookRepository: Deleting book with id -> " + id);
    }
}
