package com.cognizant.springlearn;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Hands on 3 - Employee bean used by Employee REST service
 * Hands on 4 - validations:
 *   id          - should not be null, should be a number
 *   name        - should not be null, should not be blank, min 1 max 30 characters
 *   salary      - should not be null, should be zero or above
 *   permanent   - should not be null
 *   dateOfBirth - should match the date pattern dd/MM/yyyy (kept as String,
 *                 formatted/validated as dd/MM/yyyy on the client-facing JSON)
 */
public class Employee {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30)
    private String name;

    @NotNull
    @Min(0)
    private Double salary;

    @NotNull
    private Boolean permanent;

    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "dateOfBirth must match pattern dd/MM/yyyy")
    private String dateOfBirth;

    @Valid
    private Department department;

    @Valid
    private List<Skill> skills;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
                + ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skills=" + skills + "]";
    }
}
