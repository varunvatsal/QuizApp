package com.Quiz.QuizDemo.controller;


import com.Quiz.QuizDemo.dto.Holder;
import com.Quiz.QuizDemo.dto.Question;
import com.Quiz.QuizDemo.dto.QuizStartResponse;
import com.Quiz.QuizDemo.dto.Result;
import com.Quiz.QuizDemo.model.Quiz;
import com.Quiz.QuizDemo.model.Report;
import com.Quiz.QuizDemo.model.User;
import com.Quiz.QuizDemo.service.QuizService;
import com.Quiz.QuizDemo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class QuizController {
    @Autowired
    public QuizService quizService;

    @PostMapping("/startQuiz")
    public ResponseEntity<QuizStartResponse> startQuiz(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        try{
            System.out.println(username);
            System.out.println("pp");
            System.out.println(password);
            String token = quizService.StartQuiz(username, password);
            QuizStartResponse response = new QuizStartResponse(token, "quiz started", username);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            QuizStartResponse response = new QuizStartResponse("token not created", e.getMessage(), "no username present");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/getQuestion/{token}")
    public ResponseEntity<Question> getQuestion(@PathVariable("token") String token) {
        try{
            Quiz quiz = quizService.getQuestion(token);
            Question question = new Question(quiz.getId(), quiz.getQuestion(), quiz.getOption1(), quiz.getOption2(), quiz.getOption3(), quiz.getOption4(), "");
            return ResponseEntity.status(HttpStatus.OK).body(question);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            Question response = new Question(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Question response = new Question("token not created");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/submitQues")
    public ResponseEntity<String> submitQuestion(@RequestBody Holder holder) {
        int id = holder.getId();
        String answer = holder.getAnswer();
        String token = holder.getToken();
        System.out.println(id);
        System.out.println(answer);
        System.out.println(token);
        try{
            quizService.submitAnswer(id, answer, token);
            return ResponseEntity.status(HttpStatus.CREATED).body("Answer submitted");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getReport/{token}")
    public ResponseEntity<Result> getRepot(@PathVariable("token") String token) {
        try{
            Report report = quizService.getReport(token);
            String username = JwtUtil.extractUsername(token);
            System.out.println(report);
            System.out.println(username);
            Result result = new Result(username, report.getCorrectAnswered(), report.getWrongAnswered(), "");
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            e.printStackTrace();
            Result response = new Result(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


}
