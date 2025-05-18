package com.example.Course.paper.JavaCOR.Service.Interfaces;

import com.example.Course.paper.JavaCOR.Model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    void addQuestion(Question question);

    boolean removeQuestion(String questionText);

    Optional<Question> findQuestion(String questionText);

    List<Question> getAllQuestions();

    List<Question> getRandomQuestions(int amount);
}