# Software Requirements Specification (SRS)

## 1. Introduction
The Online Movie Ticket Booking System is a responsive web application designed to allow users to easily browse movies, select show timings, and book seats online. The backend has been modernized to use Java/Spring Boot instead of Django.

## 2. Objective
Develop a web-based application enabling robust ticketing operations and secure admin capabilities for movie management.

## 3. Core Modules
- **User Registration & Login**: Authentication and session management system.
- **Movie & Show Management**: Privileged CRUD operations for adding/removing movies and their schedules.
- **Seat Selection & Ticket Booking**: Visual seating grids, pricing, and ticket issuance.
- **Admin Dashboard**: Centralized management portal for operational oversight.

## 4. Key Considerations
- **Concurrency Control**: Prevents ticket collision globally in the selected seat availability matrix.
- **UI/UX**: Responsive and premium aesthetic designed with modern CSS and Bootstrap.
