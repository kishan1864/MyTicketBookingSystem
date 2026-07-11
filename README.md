# 🎬 Movie Ticket Booking System

A backend-based Movie Ticket Booking System developed using Spring Boot that allows users to browse movies, book tickets, and manage bookings through a clean and scalable architecture. The project follows industry-standard development practices such as layered architecture, dependency injection, and RESTful API design.

## Features

- User registration and login
- Role-based access (Admin/User)
- Movie management
- Show scheduling
- Ticket booking and cancellation
- Booking history
- Admin dashboard for managing movies and shows
- Database integration using MySQL
- RESTful API architecture
- Exception handling and validation

## AI Enhancement

The project is designed to support AI-powered features. The initial enhancement focuses on personalized movie recommendations based on user booking history and genre preferences.

Planned AI features include:
- Personalized movie recommendations
- AI chatbot for booking assistance
- Review sentiment analysis
- Smart movie suggestions based on user interests

## Tech Stack

**Backend**
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

**Database**
- MySQL

**Tools**
- IntelliJ IDEA
- Postman
- Git
- GitHub

## Project Structure

```
src
├── controller
├── service
├── repository
├── domain
├── dto
├── exception
├── config
└── MovieTicketBookingApplication.java
```

## Architecture

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
MySQL Database
```

## Getting Started

### Clone the repository

```bash
git clone https://github.com/your-username/movie-ticket-booking.git
```

### Navigate to the project

```bash
cd movie-ticket-booking
```

### Configure Database

Update the database credentials in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/movie_booking
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run the application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

## Default Admin Account

When the application starts for the first time, a default administrator account is created automatically if it does not already exist.

```
Username: admin
Password: admin
```

> It is recommended to change the default password before using the application in a production environment.

## Future Improvements

- JWT Authentication
- Spring Security
- Online payment integration
- Seat selection with real-time availability
- Email notifications
- AI recommendation engine
- Docker support
- Unit and integration testing
- CI/CD pipeline

## Learning Outcomes

This project helped strengthen my understanding of:

- Spring Boot fundamentals
- Dependency Injection and IoC
- REST API development
- JPA and Hibernate
- Repository Pattern
- Layered Architecture
- Database design
- Exception handling
- Backend application development

## Author

**Kishan Sahu**

B.Tech Computer Science & Engineering (AI & ML)  
DIT University, Dehradun

---

If you find this project useful, feel free to star the repository.
