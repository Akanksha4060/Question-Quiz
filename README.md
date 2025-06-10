# Question-Quiz
## Objective
To develop a backend-based quiz management system using Spring Boot that allows creating, retrieving, and organizing quiz questions, and generating quizzes dynamically based on category and question count.

## Features
- Add, fetch, and delete quiz questions via REST APIs.
- Filter questions by category and difficulty level.
- Auto-generate quizzes with a random set of questions by category.
- Maintain a ManyToMany relationship between Quiz and Question entities.
- Proper exception handling with standardized HTTP responses.

## Technologies Used
- Language: Java
- Framework: Spring Boot, Spring Data JPA
- Database: MySQL
- Tools:Maven, Postman
- Annotations: @Entity, @Id, @GeneratedValue, @ManyToMany, @RequestMapping, @RestController
- Architecture: Layered architecture (Controller → Service → Repository)





