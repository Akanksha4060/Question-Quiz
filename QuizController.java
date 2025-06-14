package com.quiz.Question.Quiz.Controller;

import com.quiz.Question.Quiz.Model.QuestionWrapper;
import com.quiz.Question.Quiz.Model.Response;
import com.quiz.Question.Quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz") //request coming for quiz this controller will handle it
public class QuizController {

    @Autowired
    QuizService quizService;

    //want to create quiz
    @PostMapping("create")                   //if we want to accept url parameter
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }

    //want quiz question
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int id){
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }
}
