package com.quiz.Question.Quiz.Service;

import com.quiz.Question.Quiz.Dao.QuestionDao;
import com.quiz.Question.Quiz.Dao.QuizDao;
import com.quiz.Question.Quiz.Model.Question;
import com.quiz.Question.Quiz.Model.QuestionWrapper;
import com.quiz.Question.Quiz.Model.Quiz;
import com.quiz.Question.Quiz.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    //we get question from here
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);

        //setting quiz
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        //we don't have question so we need to set it from QuestionDao
        quiz.setQuestions(questions);
        quizDao.save(quiz);  //generate raandom question and saving it into quiz
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
//------------------------------------------------------------

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id){
        //we use optional here because the id we mentioned present or notin quiz so it return/handle null exception
        //data might come or not
        Optional<Quiz> quiz=quizDao.findById(id);
        //quiz have question but we need to convert that question into question wrapper
        //when we use optional we first need to get the object and then question
        List<Question> questionFromDB=quiz.get().getQuestions();
        //but we can't return it. becoz List is of QuestionWrapper Not of Question
        //So, we have to convert each Question into QuestionWrapper
        List<QuestionWrapper> questionsForUser=new ArrayList<>();
        //..so,we can use loop here
        for(Question q:questionFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }
    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        //if we don't write Optinal<> the use get()
        Quiz quiz = quizDao.findById(id).get(); // Optional: add null check here
        List<Question> questions = quiz.getQuestions();// get question from quiz

        //comparing value in the responce and  the questions
        int right = 0;// to count right answer
        int i = 0;  // to perform iteration
        for (Response response : responses) {
            String correctAnswer = questions.get(i).getRightAnswer();   //for right asnwer
            String userAnswer = response.getResponse();  //answer enter by user

            //check ans for null & matches with user responce
            if (correctAnswer != null && correctAnswer.equals(userAnswer)) {
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }


}

