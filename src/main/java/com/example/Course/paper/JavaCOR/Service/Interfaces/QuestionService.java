package com.example.Course.paper.JavaCOR.Service.Interfaces;

import com.example.Course.paper.JavaCOR.Model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}