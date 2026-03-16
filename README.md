# Tasks Management REST API

## 📌 Project Overview
A robust and secure RESTful API built with **Java Spring Boot** to manage user tasks efficiently. [cite_start]This project focuses on implementing **Clean Layered Architecture** and modern security standards to ensure maintainability and scalability[cite: 74, 77].

## 🏗️ Architectural Design
The project follows a **Layered Architecture** pattern to separate concerns and improve testability:
* **Controller Layer:** Handles incoming HTTP requests and manages API versioning.
* **Service Layer:** Contains the core business logic and task management rules.
* **Repository Layer:** Manages data persistence and interactions with the database.
* **DTOs (Data Transfer Objects):** Ensures secure and optimized data exchange between layers.

## 🔒 Security Features
[cite_start]Security is a core component of this API, ensuring that user data is protected and isolated[cite: 76]:
* [cite_start]**Stateless Authentication:** Implemented using **JSON Web Tokens (JWT)** for secure, scalable session management[cite: 76].
* [cite_start]**Resource Authorization:** Strictly enforced logic ensuring that users can only access, modify, or delete their own tasks.
* **Password Security:** (Optional: mention BCrypt if used) Secure handling of user credentials.

## 🛠️ Tech Stack
* **Backend:** Java, Spring Boot.
* [cite_start]**Security:** Spring Security, JWT[cite: 76].
* [cite_start]**Database:** H2 Database (for development/testing) / SQL.
* **Build Tool:** Maven/Gradle.
* **API Testing:** Postman.

## 🚀 Key Functionalities
* [cite_start]**User Authentication:** Secure Sign-up and Login flow[cite: 76].
* [cite_start]**Task CRUD:** Create, Read, Update, and Delete tasks with full validation[cite: 74, 75].
* **Data Integrity:** Centralized error handling and request validation.

## 📂 Getting Started
1. [cite_start]Clone the repository: `git clone https://github.com/Hamza-Abd-El-Baset/tasks-api`.
2. Configure your database settings in `application.properties`.
3. Build the project: `./mvnw clean install`.
4. Run the application: `./mvnw spring-boot:run`.
