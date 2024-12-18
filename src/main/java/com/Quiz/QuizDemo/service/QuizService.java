package com.Quiz.QuizDemo.service;


import com.Quiz.QuizDemo.dao.QuizRepo;
import com.Quiz.QuizDemo.dao.ReportRepo;
import com.Quiz.QuizDemo.dao.UserRepo;
import com.Quiz.QuizDemo.model.Quiz;
import com.Quiz.QuizDemo.model.Report;
import com.Quiz.QuizDemo.model.User;
import com.Quiz.QuizDemo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    ReportRepo reportRepo;

    @Autowired
    UserRepo userRepo;

    public String StartQuiz(String username, String password) {

        if(username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if(password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        User user = userRepo.findByUsername(username);
        if(user == null) {
            throw new IllegalArgumentException("User not found");
        }
        if(!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Wrong password");
        }
        String token = JwtUtil.generateToken(username);
        Report report = new Report(token, 0, 0, 1);
        reportRepo.save(report);
        return token;
    }

    public Quiz getQuestion(String token) throws NoSuchElementException {
        if(token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }
        Report report = reportRepo.nextQuiz(token);
        int nextQuestionId = report.getNextQuestion();
        Quiz nexQuiz =  quizRepo.findById(nextQuestionId).get();
        report.setNextQuestion(++nextQuestionId);
        reportRepo.save(report);
        return nexQuiz;
    }

    public void submitAnswer(int id, String answer, String token) throws NoSuchElementException {
        if(id == 0 || answer == null || token == null){
            throw new IllegalArgumentException("Id and Answer cannot be null");
        }
        Quiz quiz = quizRepo.findById(id).get();
        Report report = reportRepo.nextQuiz(token);
        int correct = report.getCorrectAnswered();
        int wrong = report.getWrongAnswered();

        if(Objects.equals(quiz.getAnswer(), answer)){
            report.setCorrectAnswered(++correct);
        }else {
            report.setWrongAnswered(++wrong);
        }

        reportRepo.save(report);
    }

    public Report getReport(String token){
        if(token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }
        Report report = reportRepo.nextQuiz(token);
        return report;
    }

}
