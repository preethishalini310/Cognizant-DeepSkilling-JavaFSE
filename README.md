# Microservices Composite Hands-On — Account & Loan with Eureka + API Gateway

Solution for the "Creating Microservices for account and loan" hands-on exercise
(Spring Boot 3 + Spring Cloud 2023.0.1, Java 17).

## Modules

| Module | Port | Role |
|---|---|---|
| `eureka-server` | 8761 | Service registry (Eureka Discovery Server) |
| `account-service` | 8080 | `GET /accounts/{number}` — dummy account lookup |
| `loan-service` | 8081 | `GET /loans/{number}` — dummy loan lookup |
| `api-gateway` | 9090 | Spring Cloud Gateway routing to both services via discovery, with a global logging filter |

Each module is an independent, self-contained Maven project (its own `pom.xml`), matching
the exercise's structure of separate microservices rather than a multi-module build.

## Prerequisites

- JDK 17+
- Maven 3.9+
- Ports 8080, 8081, 8761, 9090 free on localhost

## Build

From the repo root, build each module:

```bash
cd eureka-server && mvn clean package -DskipTests && cd ..
cd account-service && mvn clean package -DskipTests && cd ..
cd loan-service && mvn clean package -DskipTests && cd ..
cd api-gateway && mvn clean package -DskipTests && cd ..
```

## Run (start in this order)

```bash
# Terminal 1
cd eureka-server && mvn spring-boot:run

# Terminal 2 (wait for eureka-server to finish starting)
cd account-service && mvn spring-boot:run

# Terminal 3
cd loan-service && mvn spring-boot:run

# Terminal 4
cd api-gateway && mvn spring-boot:run
```

## Verify

1. **Eureka registry** — http://localhost:8761
   You should see `ACCOUNT-SERVICE`, `LOAN-SERVICE`, and `API-GATEWAY` listed under
   "Instances currently registered with Eureka".

2. **Direct service calls**
   ```bash
   curl http://localhost:8080/accounts/00987987973432
   # { "number": "00987987973432", "type": "savings", "balance": 234343.0 }

   curl http://localhost:8081/loans/H00987987972342
   # { "number": "H00987987972342", "type": "car", "loan": 400000.0, "emi": 3258.0, "tenure": 18 }
   ```

3. **Through the API Gateway** (routes are auto-created from the Eureka service IDs,
   lower-cased, thanks to `spring.cloud.gateway.discovery.locator`):
   ```bash
   curl http://localhost:9090/account-service/accounts/00987987973432
   curl http://localhost:9090/loan-service/loans/H00987987972342
   ```

4. **Gateway logging filter** — the `api-gateway` console should print a line like
   `====>Request URL http://localhost:9090/account-service/accounts/00987987973432`
   for every request that passes through, via `LogFilter` (`GlobalFilter`).

## Project layout

```
microservices-composite/
├── eureka-server/
│   └── src/main/java/com/cognizant/eurekaserver/EurekaServerApplication.java
├── account-service/
│   └── src/main/java/com/cognizant/account/
│       ├── AccountServiceApplication.java
│       ├── controller/AccountController.java
│       └── model/Account.java
├── loan-service/
│   └── src/main/java/com/cognizant/loan/
│       ├── LoanServiceApplication.java
│       ├── controller/LoanController.java
│       └── model/Loan.java
└── api-gateway/
    └── src/main/java/com/cognizant/gateway/
        ├── ApiGatewayApplication.java
        └── filters/LogFilter.java
```

## Notes

- Both `account-service` and `loan-service` return static/dummy data — there's no
  database wired up, matching the exercise's "simple service without any backend
  connectivity" requirement.
- `api-gateway` doesn't hand-write routes in `application.properties`; it relies on
  `spring.cloud.gateway.discovery.locator.enabled=true` to build routes automatically
  from whatever is registered in Eureka.
