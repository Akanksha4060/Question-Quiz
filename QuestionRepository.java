package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String cat);

	//it's from quizService to get data from Question
	@Query(value="SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT:numQue", nativeQuery=true)
	List<Question> getRandomQuestionByCategory(String category, int numQue);
	
	

}
