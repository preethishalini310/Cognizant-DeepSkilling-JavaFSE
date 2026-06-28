# Spring Data JPA & Hibernate – All Exercises

Complete solution for all 4 hands-on exercise files, organised into two Maven projects.

---

## Folder Structure

```
spring-data-jpa-exercises/
│
├── 01_orm-learn/                    ← Files 1, 2, 3 exercises
│   └── src/
│       ├── main/java/com/cognizant/ormlearn/
│       │   ├── OrmLearnApplication.java    ← Main + all test methods
│       │   ├── model/
│       │   │   ├── Country.java
│       │   │   ├── Department.java
│       │   │   ├── Employee.java
│       │   │   ├── Skill.java
│       │   │   └── Stock.java
│       │   ├── repository/
│       │   │   ├── CountryRepository.java
│       │   │   ├── DepartmentRepository.java
│       │   │   ├── EmployeeRepository.java
│       │   │   ├── SkillRepository.java
│       │   │   └── StockRepository.java
│       │   └── service/
│       │       ├── CountryService.java
│       │       ├── DepartmentService.java
│       │       ├── EmployeeService.java
│       │       ├── SkillService.java
│       │       └── exception/CountryNotFoundException.java
│       └── main/resources/
│           ├── application.properties
│           ├── schema.sql
│           └── data.sql
│
└── 02_employee-management/          ← File 4 exercises (EMS)
    └── src/main/java/com/cognizant/ems/
        ├── EmployeeManagementApplication.java
        ├── model/       Employee.java · Department.java
        ├── repository/  EmployeeRepository.java · DepartmentRepository.java
        ├── service/     EmployeeService.java · DepartmentService.java
        └── controller/  EmployeeController.java · DepartmentController.java
```

---

## Exercise Map

### File 1 – Spring Data JPA Quick Example

| Hands-on | Topic | Class |
|----------|-------|-------|
| 1 | Project setup + getAllCountries | `OrmLearnApplication`, `CountryService`, `CountryRepository` |
| 2 | Hibernate XML Config walkthrough | — (reference only) |
| 3 | Hibernate Annotation Config walkthrough | — (reference only) |
| 4 | JPA vs Hibernate vs Spring Data JPA | — (reference only) |
| 5 | Country table population | `data.sql` |
| 6 | findCountryByCode + CountryNotFoundException | `CountryService`, `CountryNotFoundException` |
| 7 | addCountry | `CountryService` |
| 8 | updateCountry | `CountryService` |
| 9 | deleteCountry | `CountryService` |

### File 2 – Query Methods & Relationships

| Hands-on | Topic | Class |
|----------|-------|-------|
| 1 | Query Methods – contains / startsWith / sorted | `CountryRepository`, `CountryService` |
| 2 | Query Methods – Stock (date range, top N, gt) | `StockRepository` |
| 3 | Payroll schema + bean mapping | `Employee`, `Department`, `Skill` + schema.sql |
| 4 | @ManyToOne – get/add/update Employee | `Employee`, `EmployeeService` |
| 5 | @OneToMany – getDepartment with employees | `Department` (FetchType.EAGER) |
| 6 | @ManyToMany – skills + addSkillToEmployee | `Employee`, `Skill`, `SkillService` |

### File 3 – HQL, JPQL & Native Queries

| Hands-on | Topic | Class |
|----------|-------|-------|
| 1 | HQL vs JPQL intro | — (reference) |
| 2 | HQL getAllPermanentEmployees + fetch optimisation | `EmployeeRepository` |
| 3 | HQL quiz attempt (schema reference) | — (schema-dependent) |
| 4 | HQL aggregate – getAverageSalary | `EmployeeRepository`, `EmployeeService` |
| 5 | Native Query – getAllEmployeesNative | `EmployeeRepository`, `EmployeeService` |
| 6 | Criteria Query (concept/reference) | — (reference) |

### File 4 – Employee Management System

| Exercise | Topic | Classes |
|----------|-------|---------|
| 1 | Project setup + H2 config | `EmployeeManagementApplication`, `application.properties` |
| 2 | JPA Entities + relationships | `Employee`, `Department` |
| 3 | Repositories | `EmployeeRepository`, `DepartmentRepository` |
| 4 | CRUD operations + REST endpoints | `EmployeeService`, `DepartmentService`, `EmployeeController`, `DepartmentController` |
| 5 | Custom query methods + @Query | `EmployeeRepository` |
| 6 | Pagination and Sorting | `EmployeeService.findAllPaginated`, `GET /api/employees/paged` |

---

## Running the Projects

```bash
# Project 1 – orm-learn
cd 01_orm-learn
mvn spring-boot:run

# Project 2 – Employee Management System
cd 02_employee-management
mvn spring-boot:run
# Then test: GET http://localhost:8080/api/employees
```

Both projects use **H2 in-memory database** out of the box.  
H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:ormlearn`)

To switch to **MySQL**, uncomment the MySQL block in `application.properties`.
