package com.quiz.Question.Quiz.Controller;

import com.quiz.Question.Quiz.Model.Question;
import com.quiz.Question.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")  //request coming for question this controller will handle it
public class QuestionController {

    //object of QuestionService
    @Autowired
    QuestionService questionService;

    //to get all question
    @GetMapping("allQuestions")
    public List<Question> getAllQuestion(){    //we are returning objects
        return questionService.getAllQuestions(); //we are requesting for get all question from service
    }

    //want questions by category
    @GetMapping("category/{cat}") ///{cat} we gonna mention category/topic
    //whatever value o variable cat will assign to String category
    //if variable same no need to mention inside PathVariable("cat")
    public List<Question> getQuestionByCategory(@PathVariable("cat") String category){
        return questionService.getQuestionByCategory(category);
    }

    //want question by id
    @GetMapping("id/{id}")
    public Question getQuestionById(@PathVariable int id){
        return questionService.getQuestionById(id);
    }

    //want to add questions
    @PostMapping("add")
    public String addQuestion(@RequestBody Question que){
        return questionService.addQuestion(que);
    }

    //want to delete by id
    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable int id){
        questionService.deleteById(id);
        return "redirect:/allQuestions";
    }
    //want to update question by id
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable int id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }


}
