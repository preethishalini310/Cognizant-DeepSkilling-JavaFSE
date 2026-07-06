# spring-learn

A single Spring Boot Maven project that implements **all 5 hands-on exercise
documents in order** (each hands-on builds on top of the previous one, exactly
as the original documents describe):

| # | Document | Topic |
|---|----------|-------|
| 1 | `1__spring-rest-handson.docx` | Spring Boot project setup, Spring XML config beans, singleton/prototype scope, list of beans |
| 2 | `2__spring-rest-handson.docx` | HTTP request/response, `@RestController` GET services, MockMvc testing |
| 3 | `3__spring-rest-handson.docx` | Employee & Department REST services (Controller/Service/Dao layering) |
| 4 | `4__spring-rest-handson.docx` | POST/PUT/DELETE, `@Valid` bean validation, global exception handling |
| 5 | `5__JWT-handson.docx` | Spring Security, in-memory users/roles, JWT authentication & authorization filter |

## Where each hands-on lives in the code

- **Hands on 1** (project setup, XML beans, logging):
  `SpringLearnApplication.java` (`main()`), `application.properties`
- **Hands on 2** (`date-format.xml` bean, logging):
  `SpringLearnApplication.displayDate()`, `date-format.xml`
- **Hands on 3** (logging convention): applied throughout (`LOGGER.info("START"/"END")`)
- **Hands on 4** (Country bean from XML): `Country.java`, `country.xml`,
  `SpringLearnApplication.displayCountry()`
- **Hands on 5** (singleton vs prototype scope): see comment in `country.xml`
  (change `scope="singleton"` to `scope="prototype"` on the `country` bean) and
  `SpringLearnApplication.displayCountry()`
- **Hands on 6** (list of countries): `countryList` bean in `country.xml`,
  `SpringLearnApplication.displayCountries()`

- **REST - Hello World**: `controller/HelloController.java` (`GET /hello`)
- **REST - Country**: `controller/CountryController.java`
  (`GET /country`, `GET /countries`, `GET /countries/{code}`)
- **REST - Country exceptional scenario**: `service/exception/CountryNotFoundException.java`
- **MockMvc tests**: `src/test/java/.../SpringLearnApplicationTests.java`

- **Employee / Department REST services**: `Employee.java`, `Department.java`,
  `Skill.java`, `dao/EmployeeDao.java`, `dao/DepartmentDao.java`,
  `service/EmployeeService.java`, `service/DepartmentService.java`,
  `controller/EmployeeController.java`, `controller/DepartmentController.java`,
  `employee.xml`, `department.xml`

- **POST /countries with validation**: `CountryController.addCountry()`,
  validation annotations on `Country.java`
- **Global exception handler**: `GlobalExceptionHandler.java`
- **PUT/DELETE employee with validation**: `EmployeeController.java`,
  `EmployeeDao.updateEmployee()/deleteEmployee()`, validation annotations on
  `Employee.java`, `Department.java`, `Skill.java`

- **Spring Security + JWT**: `security/SecurityConfig.java`,
  `security/JwtAuthorizationFilter.java`, `controller/AuthenticationController.java`

## Build

```bash
mvn clean package
```

## Run

```bash
mvn spring-boot:run
```

The app starts on **port 8090** (see `application.properties`).

## Try it out

```bash
# Hello world
curl http://localhost:8090/hello

# Get a token (Basic auth: user/pwd or admin/pwd)
curl -s -u user:pwd http://localhost:8090/authenticate

# Use the token to call a secured endpoint
curl -s -H "Authorization: Bearer <TOKEN_FROM_ABOVE>" http://localhost:8090/countries

# Create a country (validation: code must be exactly 2 characters)
curl -i -H "Authorization: Bearer <TOKEN>" -H "Content-Type: application/json" \
  -X POST -d '{"code":"IN","name":"India"}' http://localhost:8090/countries

# Employees / Departments
curl -s -H "Authorization: Bearer <TOKEN>" http://localhost:8090/employees
curl -s -H "Authorization: Bearer <TOKEN>" http://localhost:8090/departments
```

## Test

```bash
mvn clean test
```

## Notes

- Built with Spring Boot 2.7.x (Java 11) so that `WebSecurityConfigurerAdapter`
  and `javax.validation` match the original hands-on material.
- JWT is generated/parsed with `io.jsonwebtoken:jjwt:0.9.0`, signed with
  `HS256` and the shared secret `"secretkey"`, exactly as specified in the
  hands-on document. **This is for learning purposes only** — a real
  application should use a strong, externally-configured secret and a
  maintained JWT library version.
