package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Exercise 9: Spring Data JPA Repository
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Spring Data JPA auto-provides CRUD methods
}
