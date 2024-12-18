package com.Quiz.QuizDemo.dao;

import com.Quiz.QuizDemo.model.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepo extends CrudRepository<Report, Integer> {

    @Query(value = "select * from report where token= ?1", nativeQuery = true)
    public Report nextQuiz(String token);
}
