package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Country entity.
 *
 * FILE 1 – Hands-on 1  : extends JpaRepository (provides findAll, findById, save, deleteById)
 * FILE 2 – Hands-on 1  : Query Methods – findByNameContaining, findByNameStartingWith
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    /**
     * FILE 2 – H1: Find countries whose name contains the given text (case-insensitive).
     * Method name → WHERE UPPER(co_name) LIKE UPPER('%text%')
     */
    List<Country> findByNameContainingIgnoreCase(String text);

    /**
     * FILE 2 – H1: Find countries whose name contains the given text, ordered by name A-Z.
     */
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    /**
     * FILE 2 – H1: Find countries whose name starts with the given letter.
     */
    List<Country> findByNameStartingWith(String letter);
}
