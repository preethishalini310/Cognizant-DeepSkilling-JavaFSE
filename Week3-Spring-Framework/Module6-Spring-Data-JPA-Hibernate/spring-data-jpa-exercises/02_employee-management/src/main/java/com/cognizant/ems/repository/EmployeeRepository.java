package com.cognizant.ems.repository;

import com.cognizant.ems.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Exercise 3: EmployeeRepository
 * Exercise 5: Custom query methods
 * Exercise 6: Pagination support
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // ── Exercise 5: Derived Query Methods ────────────────────────────────────

    /** Find employees by name (exact match) */
    List<Employee> findByName(String name);

    /** Find employees by department id */
    List<Employee> findByDepartmentId(Long departmentId);

    /** Find employees whose name contains a keyword (case-insensitive) */
    List<Employee> findByNameContainingIgnoreCase(String keyword);

    /** Find employees by email */
    Employee findByEmail(String email);

    // ── Exercise 5: @Query annotation ────────────────────────────────────────

    /** JPQL query to find all employees in a department by department name */
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    // ── Exercise 6: Pagination ────────────────────────────────────────────────

    /** Paginated result of all employees sorted by name */
    Page<Employee> findAll(Pageable pageable);
}
