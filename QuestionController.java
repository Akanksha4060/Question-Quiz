package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	//to get all record
	/* --NORMALLY RECORDS WILL DISPLAY
	@GetMapping("allQuestions")
	public List<Question> getallQuestions() {
		return questionService.getAllQuestions();
	}*/
	
	//IF WE PROVIDE WRONG INPUT THEN IT WILL GIVE US EXCEPTION
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>>getallQuestions() {
		return questionService.getAllQuestions();
	}
	
	//on the basis of category we mentioned, we get data
	@GetMapping("category/{cat}")
	public List<Question> getQuestionsByCategory(@PathVariable String cat){
		return questionService.getQuestionByCategory(cat);
	}
	
	//to add record 
	@PostMapping("add")
	public String addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}	
	
	//to delete record
	@DeleteMapping("delete/{id}")
	public String deleteQuestion(@PathVariable int id) {
		questionService.deleteQuestion(id);
		return "redirect:/allQuestions";
	}
	
	//to update record
	
}
