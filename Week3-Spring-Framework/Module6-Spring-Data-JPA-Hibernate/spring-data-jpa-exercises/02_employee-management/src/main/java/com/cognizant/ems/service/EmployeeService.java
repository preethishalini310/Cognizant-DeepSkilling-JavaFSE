package com.cognizant.ems.service;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Exercise 4: CRUD operations for Employee
 * Exercise 5: Custom query methods
 * Exercise 6: Pagination and Sorting
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ── Exercise 4: CRUD ──────────────────────────────────────────────────────

    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee update(Long id, Employee updated) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(updated.getName());
            emp.setEmail(updated.getEmail());
            emp.setDepartment(updated.getDepartment());
            return employeeRepository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found: " + id));
    }

    @Transactional
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    // ── Exercise 5: Custom Queries ────────────────────────────────────────────

    public List<Employee> findByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> searchByName(String keyword) {
        return employeeRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Employee> findByDepartmentName(String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    // ── Exercise 6: Pagination and Sorting ───────────────────────────────────

    /** Returns a paginated and sorted list of employees */
    public Page<Employee> findAllPaginated(int page, int size, String sortBy) {
        return employeeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }
}
