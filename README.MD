# Cinema Room REST Service

A Spring Boot-based REST API service for managing a cinema room booking system. This application provides endpoints for seat reservation, booking management, and cinema statistics.

## Features

- View available seats in the cinema room
- Book tickets for available seats
- Return/refund tickets
- Get statistics about purchases and income
- Secure admin access for statistics
- Error handling for edge cases
- RESTful API architecture

## Technology Stack

- Java 21
- Spring Boot
- Spring MVC
- Jakarta EE
- Lombok
- Gradle
- RESTful API principles

## Project Structure

- `controllers/`: REST API endpoints
- `services/`: Business logic implementation
- `entities/`: Data model classes
- `repositories/`: Data access layer
- `dto/`: Data Transfer Objects
- `exception/`: Custom exception handling

## API Endpoints

The service provides the following endpoints:

- `GET /seats` - View available seats
- `POST /purchase` - Purchase a ticket
- `POST /return` - Return a purchased ticket
- `GET /stats` - Get statistics (protected endpoint)


## Error Handling

The service includes comprehensive error handling for various scenarios:
- Out of bounds seat selection
- Already purchased seats
- Invalid tokens for returns
- Unauthorized statistics access

## Acknowledgments

- Project created as part of the JetBrains Academy Java Backend Developer track
- Built using Spring Boot framework
