package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Exercise 6: @Service annotation for component scanning
@Service
public class BookService {

    private BookRepository bookRepository;

    // Exercise 6: @Autowired for automatic dependency injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookTitle) {
        System.out.println("BookService: Adding book -> " + bookTitle);
        bookRepository.save(bookTitle);
    }
}
