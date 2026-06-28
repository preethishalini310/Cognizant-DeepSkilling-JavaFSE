package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Set;

/**
 * Entity mapping for the 'skill' table.
 * FILE 2 – Hands-on 3,6: Skill with ManyToMany employees
 */
@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private int id;

    @Column(name = "sk_name")
    private String name;

    /**
     * FILE 2 – Hands-on 6: Inverse side of ManyToMany.
     * mappedBy refers to the 'skillList' field in Employee.
     */
    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Employee> getEmployeeList() { return employeeList; }
    public void setEmployeeList(Set<Employee> employeeList) { this.employeeList = employeeList; }

    @Override
    public String toString() {
        return "Skill{id=" + id + ", name='" + name + "'}";
    }
}
