# Student Management System

## Overview

The Student Management System is a Spring Boot application designed to manage and track students, courses, and enrollments. This system provides functionality to handle student records, course details, and the enrollment process.

## Project Structure

The project is organized into several key components:

- **Book.java**: Entity class representing a book related to the courses.
- **Course.java**: Entity class representing a course.
- **Enrollment.java**: Entity class representing the enrollment of students in courses.
- **EnrollmentId.java**: Composite key class for the Enrollment entity.
- **Sbproject2Application.java**: Main entry point for the Spring Boot application.
- **Student.java**: Entity class representing a student.
- **StudentIdentityCard.java**: Entity class for student identity cards.
- **StudentIdentityCardRepository.java**: Repository interface for managing student identity cards.
- **StudentRepository.java**: Repository interface for managing student records.

## Configuration

The application configuration is defined in `resources/application.yml`. This file includes settings for the database and other application-specific properties.

## Database

The application uses PostgreSQL as its database management system. Ensure that PostgreSQL is installed and properly configured on your machine.

## Running the Application

To run the application, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ArjanaaTernava/StudentManagementSystem.git

2. **Navigate to the project directory:**
    ```bash
    cd StudentManagementSystem
    ```
3. **Build the project:**
    ```bash
    mvn clean install
    ```
4. **Run the application:**
    ```bash
    mvn spring-boot:run
