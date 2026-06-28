package com.cognizant.ems.service;

import com.cognizant.ems.model.Department;
import com.cognizant.ems.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Exercise 4: CRUD operations for Department
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional(readOnly = true)
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department update(Long id, Department updated) {
        return departmentRepository.findById(id).map(dept -> {
            dept.setName(updated.getName());
            return departmentRepository.save(dept);
        }).orElseThrow(() -> new RuntimeException("Department not found: " + id));
    }

    @Transactional
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
