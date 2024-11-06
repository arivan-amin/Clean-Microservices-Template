# App-Name

## Overview

This project is an **App-Name** developed as a **Microservices Architecture** using **Java**.
The system is designed to manage ___________ as a microservices using modern **Java** technologies.

## Technologies Used

- **Java 21**: Core programming language.
- **Spring Boot**: Framework for building microservices.
- **Spring Cloud**: For managing microservices, service discovery, and load balancing.
- **Eureka**: Service registry for microservices.
- **MySQL**: Relational database for persistent storage.
- **MongoDB**: NoSQL database for storing data.
- **Docker**: Containerization of microservices.
- **Kafka**: Message broker for event-driven communication between services.
- **Swagger/OpenAPI**: API documentation and testing.
- **JUnit & Mockito**: Testing frameworks for unit and integration testing.
- **Flyway**: Database migration tools.
- **Lombok**: Reducing boilerplate code.
- **Grafana**: For observability and monitoring services through dashboards.
- **loki**: For centralized logging.
- **tempo**: For distributed tracing.

## Installation

### Prerequisites

- **Java 21**
- **Maven**
- **Docker**
- **Docker Compose**

### Steps to Run the Project

1. ### Clone the repository:

    ```bash
    git clone https://github.com/username/repo.git
    cd App-Name
    ```

2. ### Build and install the Core Module because all modules depend on it:

    ```bash
    cd Core
    mvn clean install
    cd ..
    ```
3. ### Build the project, and it will load the images to your local docker repository using JIB:

    ```bash
    mvn clean package
    ```

4. ### Set Eureka username and password environment variables and docker host ip:
    - on **Linux**: add the below variables to your **.bashrc** file and reload or reboot
    ```bash
    export EUREKA_USER=admin
    export EUREKA_PASSWORD=admin
    ```
    - on **Windows**: run the below commands
    ```bash
    set EUREKA_USER=admin
    set EUREKA_PASSWORD=admin
    ```
5. ### Run the services using Docker Compose:
    ```bash
    docker compose up -d
    ```

6. ### Access the services:
    - **API Gateway:** `http://localhost:8080`
    - **Eureka Dashboard:** `http://localhost:8080/eureka/web`
    - **Swagger UI:** `http://localhost:8080/swagger-ui.html`
    - **Grafana:** `http://localhost:3000/dashboards`

7. ### Accessing the Grafana Dashboards for monitoring Spring Boot and MySQL
    - Open your browser and navigate to **Grafana** at: http://localhost:3000/dashboards
    - In the **Grafana** dashboards page, click on the **New** icon on the top right side and select
      **Import**.
    - Choose both json file located at: **project-root/docker/grafana/**
    - Complete the import process, now you should have a dashboard to monitor Spring Boot.

## Testing

- Unit and integration tests are available for each microservice.
- Run the tests using Maven:

    ```bash
    mvn test
    ```

## Microservices

The system is divided into several microservices, each responsible for a specific domain:

- **API Gateway**: Serves as the single entry point for all client requests, routing them to the
  appropriate microservices. It handles request aggregation, load balancing, and provides a
  centralized point for managing cross-cutting concerns such as authentication and logging.
- **Audit Service**: Provides centralized logging and auditing for all actions within the system. It
  records critical events, such as user activities and service interactions, to ensure transparency
  and compliance.
- **Core Service**: Provides foundational services and shared functionality used across other
  microservices. This could include utility functions, common data access layers, or basic service
  management features.
- **Discovery Service**: Implements service discovery mechanisms, allowing microservices to find and
  communicate with each other dynamically. It maintains a registry of available services and their
  locations.

## Contributing

**Contributions are welcome!** Please fork the repository and submit a pull request for any
improvements
or bug fixes.

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more
details.

## Contact

For any questions or inquiries, please contact:

- **Name: Arivan Amin**
- **Email: arivanamin@gmail.com**
