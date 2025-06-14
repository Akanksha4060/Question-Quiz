package com.quiz.Question.Quiz.Dao;

import com.quiz.Question.Quiz.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    //we don't have inbuild method so we need to create it
    List<Question> findByCategory(String category);

    //this is from QuizService
    //if JAP dosen't have inbuild query then we have to write by our own
    //we are writing native query here(JPQL Query)
    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numQ);
}
