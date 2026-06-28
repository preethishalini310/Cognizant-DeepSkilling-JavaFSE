package com.library.service;

import com.library.repository.BookRepository;

// Exercise 2: BookService with setter method for BookRepository (DI)
public class BookService {

    private BookRepository bookRepository;

    // Exercise 2: Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter.");
    }

    public void addBook(String bookTitle) {
        System.out.println("BookService: Adding book -> " + bookTitle);
        bookRepository.save(bookTitle);
    }

    public String getBook(int id) {
        return bookRepository.findById(id);
    }
}
