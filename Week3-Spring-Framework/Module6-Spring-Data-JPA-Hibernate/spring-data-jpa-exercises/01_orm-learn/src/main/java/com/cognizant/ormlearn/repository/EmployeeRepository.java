package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Employee entity.
 *
 * FILE 2 – Hands-on 3 : base repository
 * FILE 3 – Hands-on 2 : HQL getAllPermanentEmployees (with fetch)
 * FILE 3 – Hands-on 4 : HQL getAverageSalary
 * FILE 3 – Hands-on 5 : Native Query getAllEmployeesNative
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * FILE 3 – Hands-on 2: HQL optimised with LEFT JOIN FETCH.
     * Single query joins employee → department → skillList in one SQL round-trip.
     */
    @Query("SELECT e FROM Employee e " +
           "LEFT JOIN FETCH e.department d " +
           "LEFT JOIN FETCH e.skillList " +
           "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    /**
     * FILE 3 – Hands-on 4: HQL aggregate – average salary for a given department.
     */
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    /**
     * FILE 3 – Hands-on 5: Native SQL query (avoid unless necessary).
     */
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
