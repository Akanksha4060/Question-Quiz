package com.example.demo.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	QuizRepository quizRepository;
	
	@Autowired   //questions comes from QuestionRepository(from database)
	QuestionRepository questionRepository;

	public ResponseEntity<String> createQuiz(String category, int numQue, String title) {
		
		//for getting questions
		List<Question> questions=questionRepository.getRandomQuestionByCategory(category,numQue);
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizRepository.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
}
