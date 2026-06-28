package com.library.service;

import com.library.repository.BookRepository;

// Exercise 1: BookService class defined as a Spring bean
public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookTitle) {
        System.out.println("BookService: Adding book -> " + bookTitle);
        bookRepository.save(bookTitle);
    }
}
