package com.Quiz.QuizDemo.dto;

public class Holder {
    private String answer;
    private int id;
    private String token;

    public Holder(String answer, int id, String token) {
        this.answer = answer;
        this.id = id;
        this.token = token;
    }

    public Holder() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    @Override
    public String toString() {
        return "Holder{" +
                "answer='" + answer + '\'' +
                ", id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}