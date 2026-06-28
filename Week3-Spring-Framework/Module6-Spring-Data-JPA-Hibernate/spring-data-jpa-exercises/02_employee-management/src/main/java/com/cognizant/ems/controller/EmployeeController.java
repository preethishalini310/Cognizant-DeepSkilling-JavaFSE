package com.cognizant.ems.controller;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Exercise 4: RESTful endpoints for Employee CRUD
 * Exercise 5: Custom query endpoints
 * Exercise 6: Pagination endpoint
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ── Exercise 4: CRUD Endpoints ────────────────────────────────────────────

    /** POST /api/employees – create a new employee */
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.create(employee));
    }

    /** GET /api/employees/{id} – get employee by id */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** GET /api/employees – get all employees */
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    /** PUT /api/employees/{id} – update employee */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    /** DELETE /api/employees/{id} – delete employee */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ── Exercise 5: Custom Query Endpoints ───────────────────────────────────

    /** GET /api/employees/search?name=Alice – search by name keyword */
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByName(name));
    }

    /** GET /api/employees/department/{id} – employees by department */
    @GetMapping("/department/{id}")
    public ResponseEntity<List<Employee>> getByDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findByDepartment(id));
    }

    // ── Exercise 6: Pagination and Sorting ───────────────────────────────────

    /**
     * GET /api/employees/paged?page=0&size=5&sortBy=name
     * Returns paginated and sorted employees.
     */
    @GetMapping("/paged")
    public ResponseEntity<Page<Employee>> getAllPaginated(
            @RequestParam(defaultValue = "0")    int page,
            @RequestParam(defaultValue = "5")    int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return ResponseEntity.ok(employeeService.findAllPaginated(page, size, sortBy));
    }
}
