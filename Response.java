package com.quiz.Question.Quiz.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor //provide parametrized and default constructor
public class Response {
    private int id;
    private String response;
}
