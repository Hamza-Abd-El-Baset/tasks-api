# Tasks Management REST API

## 📌 Project Overview
A robust and secure RESTful API built with Java Spring Boot to manage user tasks efficiently. This project focuses on implementing Clean Layered Architecture and modern security standards to ensure maintainability and scalability.

## 🏗️ Architectural Design
The project follows a Layered Architecture pattern to separate concerns and improve testability:
* **Controller Layer:** Handles incoming HTTP requests and manages API versioning.
* **Service Layer:** Contains the core business logic and task management rules.
* **Repository Layer:** Manages data persistence and interactions with the database.

## 🔒 Security Features
Security is a core component of this API, ensuring that user data is protected and isolated:
* **Stateless Authentication:** Implemented using JSON Web Tokens (JWT) for secure, scalable session management.
* **Resource Authorization:** Strictly enforced logic ensuring that users can only access, modify, or delete their own tasks.
* **Password Security:** Secure handling of user credentials.

## 🛠️ Tech Stack
* **Backend:** Java, Spring Boot.
* **Security:** Spring Security, JWT.
* **Database:** SQL / H2 Database.
* **Build Tool:** Maven/Gradle.

## 🚀 Key Functionalities
* **User Authentication:** Secure Sign-up and Login flow.
* **Task CRUD:** Create, Read, Update, and Delete tasks with full validation.
* **Data Integrity:** Centralized error handling and request validation.

## 📂 Getting Started
1. Clone the repository: `git clone https://github.com/Hamza-Abd-El-Baset/tasks-api`.
2. Configure your database settings in `application.properties`.
3. Build the project: `./mvnw clean install`.
4. Run the application: `./mvnw spring-boot:run`.
