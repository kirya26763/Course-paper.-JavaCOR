package com.example.Course.paper.JavaCOR.Service.Interfaces;

import com.example.Course.paper.JavaCOR.Model.Question;

import java.util.List;

public interface ExaminerService {

    List<Question> getQuestions(int amount);
}