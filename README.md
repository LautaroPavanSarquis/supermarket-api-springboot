# Supermarket API

REST API built with **Spring Boot** to manage a simple supermarket system.  
This project was created to demonstrate backend development skills including:

- REST API design
- Database integration with MySQL
- DTO architecture
- Docker containerization
- Local API testing with Postman

The API allows managing **branches, products and sales**, persisting all data in a MySQL database.

---

# Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Docker
- Docker Compose
- Maven

---

# Architecture

The project follows a layered architecture commonly used in Spring applications:

Controller → Service → Repository → Database

Main concepts used:

- **DTO pattern** to separate API responses from persistence models
- **Service layer** to encapsulate business logic
- **Repository layer** using Spring Data JPA
- **Exception handling** for API responses
- **Mapper** to convert entities to DTOs

---

# Running the Project

The project is fully **Dockerized** and can be run with a single command.

### 1️⃣ Build and start containers


docker compose up --build


This will start:

- Spring Boot API
- MySQL database

---

### 2️⃣ API access

Once the containers are running:

# Database

The application uses **MySQL** running inside Docker.

Configuration is handled through environment variables defined in `docker-compose.yml`.

The database is automatically created if it does not exist.

# Testing the API

The API was tested locally using **Postman**.

Typical operations include:

- Create branches
- Register products
- Register sales
- Retrieve stored data

All endpoints follow standard REST conventions.

---

# Learning Goals

This project was built to practice and demonstrate:

- Building REST APIs with Spring Boot
- Working with relational databases
- Structuring backend applications using layered architecture
- Containerizing backend applications with Docker
- Running multi-container environments using Docker Compose

---

# Future Improvements

Possible next steps for the project:

- Add authentication (Spring Security / JWT)
- Add integration tests
- Add API documentation with Swagger
- Improve validation and error handling


# Author

Lautaro Pavan

Backend developer focused on Java and Spring Boot.
