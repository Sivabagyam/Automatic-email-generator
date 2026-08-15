# Automatic Email Generator

An automated email generation and notification system developed using Java and Spring Boot. The application uses HTML email templates to generate email content and manages notification data using a database.

## Features

- Generate emails using reusable HTML templates
- Store notification information in the database
- Email service implementation
- Dynamic email content
- REST API integration
- Database persistence
- Structured controller, service, and repository layers

## Technologies Used

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- REST APIs
- Maven

### Database
- MySQL

### Email and Templates
- HTML
- Java Email Service

### Tools
- Git
- GitHub
- Postman
- Spring Tool Suite
- MySQL

## Architecture

Client
   |
   v
REST Controller
   |
   v
Email Service
   |
   v
HTML Email Template
   |
   v
Notification Repository
   |
   v
MySQL

## Application Flow

Request
   |
   v
Controller
   |
   v
Service Layer
   |
   v
Generate Email Content
   |
   v
Apply HTML Template
   |
   v
Process Email
   |
   v
Store Notification Data

## Project Structure

```text
Automatic-email-generator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── pom.xml
└── README.md
