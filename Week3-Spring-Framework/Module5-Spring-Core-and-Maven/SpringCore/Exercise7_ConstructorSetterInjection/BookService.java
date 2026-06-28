package com.library.service;

import com.library.repository.BookRepository;

// Exercise 7: Constructor and Setter Injection
public class BookService {

    private BookRepository bookRepository;

    // Exercise 7: Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection done.");
    }

    // Exercise 7: Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Setter injection done.");
    }

    public void addBook(String bookTitle) {
        System.out.println("BookService: Adding book -> " + bookTitle);
        bookRepository.save(bookTitle);
    }
}
