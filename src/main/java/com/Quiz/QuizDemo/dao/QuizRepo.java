package com.Quiz.QuizDemo.dao;

import com.Quiz.QuizDemo.model.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepo extends CrudRepository<Quiz, Integer>
{
}
