package com.Quiz.QuizDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String token;
    private int correctAnswered;
    private int wrongAnswered;
    private int nextQuestion;

    public Report() {

    }

    public Report(String token, int correctAnswered, int wrongAnswered, int nextQuestion) {
        this.token = token;
        this.correctAnswered = correctAnswered;
        this.wrongAnswered = wrongAnswered;
        this.nextQuestion = nextQuestion;
    }

    public Report(int id, String token, int correctAnswered, int wrongAnswered, int nextQuestion) {
        this.id = id;
        this.token = token;
        this.correctAnswered = correctAnswered;
        this.wrongAnswered = wrongAnswered;
        this.nextQuestion = nextQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public int getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(int nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", correctAnswered='" + correctAnswered + '\'' +
                ", wrongAnswered='" + wrongAnswered + '\'' +
                ", nextQuestion=" + nextQuestion +
                '}';
    }
}
