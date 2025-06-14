package com.quiz.Question.Quiz.Service;

import com.quiz.Question.Quiz.Dao.QuestionDao;
import com.quiz.Question.Quiz.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }
    public List<Question> getQuestionByCategory(String category){
        return questionDao.findByCategory(category);
    }
    public Question getQuestionById(int id){
        return questionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }
    public String addQuestion(Question que){
        questionDao.save(que);
        return "success";
    }
    public void deleteById(int id){
        questionDao.deleteById(id);

    }
    public ResponseEntity<String> updateQuestion(int id, Question updatedQuestion) {
        if (!questionDao.existsById(id)) {
            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
        }

        Question existingQuestion = questionDao.findById(id).get();

        existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
        existingQuestion.setOption1(updatedQuestion.getOption1());
        existingQuestion.setOption2(updatedQuestion.getOption2());
        existingQuestion.setOption3(updatedQuestion.getOption3());
        existingQuestion.setOption4(updatedQuestion.getOption4());
        existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
        existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
        existingQuestion.setCategory(updatedQuestion.getCategory());

        questionDao.save(existingQuestion);
        return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
    }



}
