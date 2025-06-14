package com.quiz.Question.Quiz.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.UserTransaction;
import lombok.Data;

@Data //no need for setter getter if we use this
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
