# App-Name

## Overview

This project is a template for an enterprise-level backend application with **Microservices
Architecture** using **Java**.

It serves as a practice project to demonstrate the implementation of microservices using
modern **Java** and **Spring Boot** and follow some of the best practices in development.

---

## Notable Features

- **Automatic Audit Logs Recording**: Uses Spring **AOP** to create Audit Events automatically
  whenever any API in any of the services are called and uses **Kafka** to send them to the Audit
  Service to be recorded, allowing the controllers to be clutter-free and simple.
- **Clean and concise Restful API in all services**: the API follows the modern best practices in
  Restful services recommendations like using **ResponseEntity** and returning **ProblemDetails**.
- **CQRS**: Command and Query Separation Principle to implement Business logic.
- **ArchUnit**: to validate architectural boundaries and verify adherence to best coding standards
- **@RestControllerAdvice**: to handle specific exceptions and return a unified and standard error
  response instead of an exception stack trace using Spring **ProblemDetail**.
- **OpenAPI and Swagger Docs**: to provide detailed documentation for all endpoints.
- **Entity and DTO separation**: decouples core business logic from presentation using request and
  response pojo.
- **Core Entity and Jpa separation**: core entities have no association with JPA and are never
  annotated with @Entity.

## Quick Info

![Java](https://img.shields.io/badge/java-21-brightgreen)
![SpringBoot](https://img.shields.io/badge/spring--boot-3.4.1-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.9.9-blue)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-brightgreen)

![Last Commit](https://img.shields.io/github/last-commit/arivan-amin/Clean-Microservices-Template)
![Repo Size](https://img.shields.io/github/repo-size/arivan-amin/Clean-Microservices-Template)
![Contributors](https://img.shields.io/github/contributors/arivan-amin/Clean-Microservices-Template)
![Platform](https://img.shields.io/badge/platform-Linux%20%7C%20Windows%20%7C%20MacOS-informational)

## 🛠️ Architecture concepts demonstrated and implemented

- **Microservices**
- **Clean Architecture**
- **Clean Code**
- **Command-Query Responsibility Separation**
- **Solid Principles**
- **Loose Coupling of Components**
- **Spring Dependency Injection**
- **Aspect-Oriented Programming (AOP)**

---

## 🛠️ Technical Features Implemented

- **Microservices Architecture**.
- **Automatic Audit Logs recording**: Uses Spring AOP to automatically store audit logs.
- **Robust Monitoring**: Real-time monitoring with Grafana, Loki, and Tempo.
- **Event-Driven Communication**: Using Kafka.
- **Centralized Logging & Tracing**: Using Logback and Tempo.
- **Database Migrations**: Using Liquibase.
- **Dockerized Deployment**: Using Docker and Docker Compose.

---

### Currently, the following services are implemented, other services will be added:

- Discovery Server
- API Gateway
- Employee Service
- Audit Service

---

## Technologies used and their responsibility

- **Java 21**
- **Spring Boot**
- **Spring Cloud**
- **Eureka**: Dynamic service registry.
- **MySQL**: Services data storage.
- **MongoDB**: Storage for Audit logs.
- **Kafka**: Event streaming for microservices.
- **Docker**
- **Grafana, Loki, Tempo**: Observability stack for metrics, logging, and tracing.
- **JUnit & Mockito**: Unit testing and Mocking.
- **Swagger/OpenAPI**: API documentation.
- **Liquibase**: Database Migrations.
- **Lombok**: Cleaner code with reduced boilerplate.

---

## Grafana Monitoring Sample

![image](https://raw.githubusercontent.com/arivan-amin/Healthcare-Management-Microservices/master/Docs/Grafana/Grafana-Dashboard-1.png)

## 🚀 Installation Guide

### Prerequisites

- **Java 21**
- **Maven**
- **Docker** & **Docker Compose**

---

### Steps to Get Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/arivan-amin/Clean-Microservices-Template.git
   cd Clean-Microservices-Template
   ```

2. **Build Core Module:**
   ```bash
   cd Core
   mvn clean install
   cd ..
   ```

3. **Build and Package the Project:**
   ```bash
   mvn clean package
   ```

4. **Set Environment Variables (Linux/MacOS):**
   ```bash
   export EUREKA_USER=admin
   export EUREKA_PASSWORD=admin
   ```
   ```
   *(For Windows, use `set` command)*
   ```

5. **Run Services with Docker Compose:**
   ```bash
   docker compose up -d
   ```

6. **Access the Services:**
    - **API Gateway:** [http://localhost:8080](http://localhost:8080)
    - **Eureka Dashboard:** [http://localhost:8080/eureka/web](http://localhost:8080/eureka/web)
    - **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    - **Grafana Dashboard:** [http://localhost:3000/dashboards](http://localhost:3000/dashboards)

7. **Grafana Dashboard Setup:**
    - Import pre-built dashboard JSON configuration from `docker/grafana/` folder.

---

## 🧪 Testing

- **Run Unit and Integration Tests:**
   ```bash
   mvn test
   ```

---

## ⚙️ Microservices Overview

- **Discovery Server**: Dynamic service discovery and registry.
- **API Gateway**: Centralized entry point for routing and security.
- **Core Module**: Shared utilities and functionality.
- **Employee Service**: Manages employee data.
- **Audit Service**: Logs events and ensures compliance.

---

## 🤝 Contributing

We welcome contributions! Fork the repository, create a new branch, and submit a pull request.

---

## 📜 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more
details.

---

## 📧 Contact

For questions or inquiries:

- **Name:** Arivan Amin
- **Email:** [arivanamin@gmail.com](mailto:arivanamin@gmail.com)
