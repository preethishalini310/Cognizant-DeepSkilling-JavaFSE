package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

/**
 * Hands on 3 - Create static employee list data using spring xml configuration
 * Hands on 4 - Implement REST service for updating / deleting an employee
 */
@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
        LOGGER.info("END");
    }

    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("START");
        LOGGER.info("END");
        return EMPLOYEE_LIST;
    }

    /**
     * Hands on 4 - Update employee. Throws EmployeeNotFoundException if id not found.
     */
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START");

        Iterator<Employee> iterator = EMPLOYEE_LIST.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Employee current = iterator.next();
            if (current.getId().equals(employee.getId())) {
                current.setName(employee.getName());
                current.setSalary(employee.getSalary());
                current.setPermanent(employee.getPermanent());
                current.setDateOfBirth(employee.getDateOfBirth());
                current.setDepartment(employee.getDepartment());
                current.setSkills(employee.getSkills());
                found = true;
                break;
            }
        }

        if (!found) {
            throw new EmployeeNotFoundException("Employee not found for id " + employee.getId());
        }

        LOGGER.info("END");
    }

    /**
     * Hands on 4 - Implement REST DELETE Service
     */
    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        LOGGER.info("START");

        boolean removed = EMPLOYEE_LIST.removeIf(employee -> employee.getId().equals(id));

        if (!removed) {
            throw new EmployeeNotFoundException("Employee not found for id " + id);
        }

        LOGGER.info("END");
    }
}
