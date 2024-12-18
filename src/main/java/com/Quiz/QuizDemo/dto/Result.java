package com.Quiz.QuizDemo.dto;

public class Result {
    private String username;
    private int correctAnswered;
    private int wrongAnswered;
    private String message;

    public Result(String username, int correctAnswered, int wrongAnswered, String message) {
        this.username = username;
        this.correctAnswered = correctAnswered;
        this.wrongAnswered = wrongAnswered;
        this.message = message;
    }

    public Result(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCorrectAnswered() {
        return correctAnswered;
    }

    public void setCorrectAnswered(int correctAnswered) {
        this.correctAnswered = correctAnswered;
    }

    public int getWrongAnswered() {
        return wrongAnswered;
    }

    public void setWrongAnswered(int wrongAnswered) {
        this.wrongAnswered = wrongAnswered;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "username='" + username + '\'' +
                ", correctAnswered=" + correctAnswered +
                ", wrongAnswered=" + wrongAnswered +
                ", message='" + message + '\'' +
                '}';
    }
}
