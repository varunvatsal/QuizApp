package com.Quiz.QuizDemo.dao;

import com.Quiz.QuizDemo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

    @Query(value = "select * from quiz_user where username = ?1", nativeQuery = true)
    public User findByUsername(String username);
}
