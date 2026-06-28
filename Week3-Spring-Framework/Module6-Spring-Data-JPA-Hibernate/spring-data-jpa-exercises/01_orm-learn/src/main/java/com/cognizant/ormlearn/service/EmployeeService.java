package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for Employee operations.
 *
 * FILE 2 – Hands-on 4 : get, save (ManyToOne)
 * FILE 3 – Hands-on 2 : getAllPermanentEmployees (HQL)
 * FILE 3 – Hands-on 4 : getAverageSalary (HQL aggregate)
 * FILE 3 – Hands-on 5 : getAllEmployeesNative (Native Query)
 */
@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    // ── FILE 2 – Hands-on 4 ──────────────────────────────────────────────────

    @Transactional
    public Employee get(int id) {
        LOGGER.info("Start");
        return employeeRepository.findById(id).get();
    }

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start");
        employeeRepository.save(employee);
        LOGGER.info("End");
    }

    // ── FILE 3 – Hands-on 2 ──────────────────────────────────────────────────

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    // ── FILE 3 – Hands-on 4 ──────────────────────────────────────────────────

    @Transactional
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    // ── FILE 3 – Hands-on 5 ──────────────────────────────────────────────────

    @Transactional
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }
}
