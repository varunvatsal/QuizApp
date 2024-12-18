# Quiz Taking App

This is a simple Quiz Taking application built using **Spring Boot** and an **in-memory H2 database**. The application provides RESTful APIs to start a quiz, fetch questions, submit answers, and generate a quiz report.

---

## Features
- Start a new quiz and obtain a token for API authentication.
- Fetch quiz questions one at a time.
- Submit answers for questions and track progress.
- Retrieve a detailed quiz report after completing the quiz.
- Access and debug stored data using the in-memory H2 database.

---

## API Endpoints

### 1. Start Quiz(POST)
- **URL:** `localhost:8080/startQuiz`
- **Description:** Starts a new quiz session and returns a token that is required for all subsequent API calls.
- **Response Example:**
  ```json
  {
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJWQVJVTiIsImV4cCI6MTczNDYxMjAwM30.xSxZYLSfLWgjAqk5yLDFYv76ZVxR7GywDp6xk6reUGvdGw9TdsGQ7F-xD3XTw92StLGrNxFnzCTW49zqsifVpw",
    "message": "quiz started",
    "username": "VARUN"
  }
- **Rquest Body:**
  ```json
  {
    "id": 1,
    "username": "VARUN",
    "password": "VARUN@123"
  }
