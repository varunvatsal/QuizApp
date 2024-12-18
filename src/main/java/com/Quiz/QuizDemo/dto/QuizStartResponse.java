package com.Quiz.QuizDemo.dto;

public class QuizStartResponse {
    private String token;
    private String message;
    private String username;

    public QuizStartResponse(String token, String message, String username) {
        this.token = token;
        this.message = message;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "QuizStartResponse{" +
                "token='" + token + '\'' +
                ", message='" + message + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
