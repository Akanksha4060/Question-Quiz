package com.quiz.Question.Quiz.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany   //we have to do mapping otherwise it will give error
    private List<Question> questions;
}
