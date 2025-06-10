package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	// to get all records  
	/* --NORMALLY RECORDS WILL DISPLAY
	 * public List<Question> getAllQuestions() {
	 * 
	 * return questionRepository.findAll(); }
	 */
	
	//IF WE PROVIDE WRONG INPUT THEN IT WILL GIVE US EXCEPTION
	public ResponseEntity<List<Question>> getAllQuestions() {
		try{
			return new ResponseEntity<>(questionRepository.findAll(),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			}
		return new ResponseEntity<>(questionRepository.findAll(),HttpStatus.BAD_REQUEST);

		}

	public List<Question> getQuestionByCategory(String cat) {

		return questionRepository.findByCategory(cat);
	}

	public String addQuestion(Question question) {
		questionRepository.save(question);
		return "Success";
	}

	public void deleteQuestion(int id) {
		questionRepository.deleteById(id);
		
	}

	
	

}
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	// to get all records  
	/* --NORMALLY RECORDS WILL DISPLAY
	 * public List<Question> getAllQuestions() {
	 * 
	 * return questionRepository.findAll(); }
	 */
	
	//IF WE PROVIDE WRONG INPUT THEN IT WILL GIVE US EXCEPTION
	public ResponseEntity<List<Question>> getAllQuestions() {
		try{
			return new ResponseEntity<>(questionRepository.findAll(),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			}
		return new ResponseEntity<>(questionRepository.findAll(),HttpStatus.BAD_REQUEST);

		}

	public List<Question> getQuestionByCategory(String cat) {

		return questionRepository.findByCategory(cat);
	}

	public String addQuestion(Question question) {
		questionRepository.save(question);
		return "Success";
	}

	public void deleteQuestion(int id) {
		questionRepository.deleteById(id);
		
	}

	public ResponseEntity<String> updateQuestion(int id, Question updatedQuestion) {
		if(!questionRepository.existsById(id)) {
			return new ResponseEntity<>("Question not found",HttpStatus.NOT_FOUND);
		}
		
		Question existingQuestion=questionRepository.findById(id).get();
		existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
		existingQuestion.setOption1(updatedQuestion.getOption1());
		existingQuestion.setOption2(updatedQuestion.getOption2());
		existingQuestion.setOption3(updatedQuestion.getOption3());
		existingQuestion.setOption4(updatedQuestion.getOption4());
		existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
		existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
		existingQuestion.setCategory(updatedQuestion.getCategory());
		
		questionRepository.save(existingQuestion);
		return new ResponseEntity<>("Question updated successfully",HttpStatus.OK);

	}

	
	

}
