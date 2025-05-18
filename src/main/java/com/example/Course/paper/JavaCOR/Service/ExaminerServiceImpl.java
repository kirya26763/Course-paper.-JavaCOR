package com.example.Course.paper.JavaCOR.Service;

import com.example.Course.paper.JavaCOR.Service.Interfaces.ExaminerService;
import com.example.Course.paper.JavaCOR.Service.Interfaces.QuestionService;
import com.example.Course.paper.JavaCOR.Model.Question;
import com.example.Course.paper.JavaCOR.Util.RandomUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = questionService.getAllQuestions();

        if (amount > allQuestions.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Запрошено больше вопросов, чем доступно: " + allQuestions.size());
        }

        Set<Integer> usedIndexes = new HashSet<>();
        List<Question> result = new ArrayList<>();

        while (result.size() < amount) {
            int index = RandomUtil.getRandomQuestion(allQuestions.size());
            if (usedIndexes.add(index)) {
                result.add(allQuestions.get(index));
            }
        }

        return result;
    }
}