package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Main application class.
 *
 * ┌──────────────────────────────────────────────────────────────────┐
 * │  FILE 1 – Hands-on 1  : Setup & getAllCountries                  │
 * │  FILE 1 – Hands-on 6  : findCountryByCode                       │
 * │  FILE 1 – Hands-on 7  : addCountry                              │
 * │  FILE 1 – Hands-on 8  : updateCountry                           │
 * │  FILE 1 – Hands-on 9  : deleteCountry                           │
 * │  FILE 2 – Hands-on 4  : ManyToOne – getEmployee / addEmployee / updateEmployee │
 * │  FILE 2 – Hands-on 5  : OneToMany – getDepartment               │
 * │  FILE 2 – Hands-on 6  : ManyToMany – getEmployee skills / addSkillToEmployee  │
 * │  FILE 3 – Hands-on 2  : HQL – getAllPermanentEmployees           │
 * │  FILE 3 – Hands-on 4  : HQL – getAverageSalary                  │
 * │  FILE 3 – Hands-on 5  : Native Query – getAllEmployeesNative     │
 * └──────────────────────────────────────────────────────────────────┘
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    // Static service references (set from application context after startup)
    private static CountryService    countryService;
    private static EmployeeService   employeeService;
    private static DepartmentService departmentService;
    private static SkillService      skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService    = context.getBean(CountryService.class);
        employeeService   = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService      = context.getBean(SkillService.class);

        LOGGER.info("Inside main – application started");

        // ── FILE 1: Country CRUD ──────────────────────────────────────
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();

        // ── FILE 1 (H1-2) / FILE 2 (H1-3): Query Methods ─────────────
        testFindCountriesContaining();
        testFindCountriesStartingWith();

        // ── FILE 2: Relationships ─────────────────────────────────────
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();

        // ── FILE 3: HQL / Native Query ────────────────────────────────
        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAllEmployeesNative();
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 1 – Hands-on 1: Get All Countries
    // ════════════════════════════════════════════════════════════════
    private static void testGetAllCountries() {
        LOGGER.info("Start - testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End   - testGetAllCountries");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 1 – Hands-on 6: Find Country by Code
    // ════════════════════════════════════════════════════════════════
    private static void testFindCountryByCode() {
        LOGGER.info("Start - testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        LOGGER.info("End   - testFindCountryByCode");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 1 – Hands-on 7: Add Country
    // ════════════════════════════════════════════════════════════════
    private static void testAddCountry() {
        LOGGER.info("Start - testAddCountry");
        Country newCountry = new Country("XX", "TestLand");
        countryService.addCountry(newCountry);
        try {
            Country fetched = countryService.findCountryByCode("XX");
            LOGGER.debug("Added country: {}", fetched);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after add: {}", e.getMessage());
        }
        LOGGER.info("End   - testAddCountry");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 1 – Hands-on 8: Update Country
    // ════════════════════════════════════════════════════════════════
    private static void testUpdateCountry() {
        LOGGER.info("Start - testUpdateCountry");
        countryService.updateCountry("XX", "TestLand Updated");
        try {
            Country updated = countryService.findCountryByCode("XX");
            LOGGER.debug("Updated country: {}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        LOGGER.info("End   - testUpdateCountry");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 1 – Hands-on 9: Delete Country
    // ════════════════════════════════════════════════════════════════
    private static void testDeleteCountry() {
        LOGGER.info("Start - testDeleteCountry");
        countryService.deleteCountry("XX");
        LOGGER.debug("Country XX deleted.");
        LOGGER.info("End   - testDeleteCountry");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 2 – Hands-on 1: Query Methods – countries containing text
    // ════════════════════════════════════════════════════════════════
    private static void testFindCountriesContaining() {
        LOGGER.info("Start - testFindCountriesContaining");
        List<Country> result = countryService.findCountriesContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", result);
        LOGGER.info("End   - testFindCountriesContaining");
    }

    // FILE 2 – Hands-on 1: Query Methods – countries starting with letter
    private static void testFindCountriesStartingWith() {
        LOGGER.info("Start - testFindCountriesStartingWith");
        List<Country> result = countryService.findCountriesStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", result);
        LOGGER.info("End   - testFindCountriesStartingWith");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 2 – Hands-on 4: ManyToOne – Get Employee with Department
    // ════════════════════════════════════════════════════════════════
    private static void testGetEmployee() {
        LOGGER.info("Start - testGetEmployee");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());
        LOGGER.info("End   - testGetEmployee");
    }

    // FILE 2 – Hands-on 4: ManyToOne – Add Employee
    private static void testAddEmployee() {
        LOGGER.info("Start - testAddEmployee");
        Employee employee = new Employee();
        employee.setName("Frank Ocean");
        employee.setSalary(95000.00);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());
        employee.setDepartment(departmentService.get(1));
        employeeService.save(employee);
        LOGGER.debug("Added Employee: {}", employee);
        LOGGER.info("End   - testAddEmployee");
    }

    // FILE 2 – Hands-on 4: ManyToOne – Update Employee Department
    private static void testUpdateEmployee() {
        LOGGER.info("Start - testUpdateEmployee");
        Employee employee = employeeService.get(1);
        employee.setDepartment(departmentService.get(2));
        employeeService.save(employee);
        LOGGER.debug("Updated Employee: {}", employee);
        LOGGER.info("End   - testUpdateEmployee");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 2 – Hands-on 5: OneToMany – Get Department with Employees
    // ════════════════════════════════════════════════════════════════
    private static void testGetDepartment() {
        LOGGER.info("Start - testGetDepartment");
        var department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees: {}", department.getEmployeeList());
        LOGGER.info("End   - testGetDepartment");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 2 – Hands-on 6: ManyToMany – Add Skill to Employee
    // ════════════════════════════════════════════════════════════════
    private static void testAddSkillToEmployee() {
        LOGGER.info("Start - testAddSkillToEmployee");
        Employee employee = employeeService.get(2);
        Skill skill = skillService.get(5);
        employee.getSkillList().add(skill);
        employeeService.save(employee);
        LOGGER.debug("Skills after add: {}", employee.getSkillList());
        LOGGER.info("End   - testAddSkillToEmployee");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 3 – Hands-on 2: HQL – Get All Permanent Employees
    // ════════════════════════════════════════════════════════════════
    public static void testGetAllPermanentEmployees() {
        LOGGER.info("Start - testGetAllPermanentEmployees");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);
        employees.forEach(e -> LOGGER.debug("Skills: {}", e.getSkillList()));
        LOGGER.info("End   - testGetAllPermanentEmployees");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 3 – Hands-on 4: HQL – Average Salary by Department
    // ════════════════════════════════════════════════════════════════
    private static void testGetAverageSalary() {
        LOGGER.info("Start - testGetAverageSalary");
        double avg = employeeService.getAverageSalary(1);
        LOGGER.debug("Average salary for department 1: {}", avg);
        LOGGER.info("End   - testGetAverageSalary");
    }

    // ════════════════════════════════════════════════════════════════
    // FILE 3 – Hands-on 5: Native Query – Get All Employees
    // ════════════════════════════════════════════════════════════════
    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start - testGetAllEmployeesNative");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("Employees (native): {}", employees);
        LOGGER.info("End   - testGetAllEmployeesNative");
    }
}
