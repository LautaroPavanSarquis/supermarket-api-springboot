Supermarket API

Backend REST API built with Spring Boot to manage a basic supermarket system.
This project was created to demonstrate backend development skills including REST API design, database integration, and Docker containerization.

It provides endpoints to manage:

Branches

Products

Sales

The project is fully containerized with Docker and can be executed locally with Docker Compose.

Tech Stack
Technology	Purpose
Java 21	Programming language
Spring Boot	Backend framework
Spring Data JPA	Database access
Hibernate	ORM
MySQL	Relational database
Docker	Containerization
Docker Compose	Multi-container orchestration
Maven	Dependency management
Project Architecture

The application follows a layered architecture commonly used in Spring Boot applications.

Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL Database
Package Structure
api
├── Controller
├── DTOs
├── Exception
├── Mappers
├── Model
├── Repository
├── Service
└── resources
Key Concepts Implemented

DTO Pattern
Separates API responses from database entities.

Service Layer
Encapsulates business logic.

Repository Layer
Uses Spring Data JPA to handle persistence.

Exception Handling
Custom exceptions for better API responses.

Entity Mapping
Entities mapped to database tables using JPA annotations.

Running the Project

The project is fully dockerized, so the easiest way to run it is using Docker.

Start the application
docker compose up --build

This command will start:

Spring Boot API container

MySQL database container

Accessing the API

Once the containers are running:

http://localhost:8080
Database

The API connects to a MySQL database running in Docker.

Database configuration is defined through environment variables in:

docker-compose.yml

The database is automatically created if it does not exist.

Example Endpoints
Branches
POST /branches
GET /branches
Products
POST /products
GET /products
Sales
POST /sales
GET /sales
API Testing

All endpoints were tested locally using Postman.

Typical workflow tested:

Create branches

Register products

Register sales

Retrieve stored data

Learning Goals

This project was built to practice and demonstrate:

Building REST APIs with Spring Boot

Implementing layered backend architectures

Working with relational databases

Containerizing applications with Docker

Running multi-container environments with Docker Compose

Possible Improvements

Future enhancements could include:

API documentation with Swagger / OpenAPI

Authentication with Spring Security + JWT

Integration and unit tests

Request validation with Bean Validation

Pagination for large datasets

Author

Lautaro Pavan

Backend developer focused on Java, Spring Boot and backend architectures.