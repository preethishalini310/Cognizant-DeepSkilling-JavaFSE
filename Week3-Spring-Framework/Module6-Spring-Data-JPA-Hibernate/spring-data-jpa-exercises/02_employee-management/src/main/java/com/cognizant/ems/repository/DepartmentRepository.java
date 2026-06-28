package com.cognizant.ems.repository;

import com.cognizant.ems.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Exercise 3: DepartmentRepository
 * Extends JpaRepository for built-in CRUD operations.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /** Exercise 5: Derived query – find departments by name */
    List<Department> findByName(String name);
}
