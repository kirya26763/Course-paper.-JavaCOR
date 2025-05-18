package com.example.Course.paper.JavaCOR.Service;

import com.example.Course.paper.JavaCOR.Model.Question;
import com.example.Course.paper.JavaCOR.Service.Interfaces.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExaminerServiceImplTest {

    private QuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        questionService = Mockito.mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void testGetQuestions_ReturnsCorrectAmount() {
        List<Question> questions = Arrays.asList(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"),
                new Question("Q3", "A3")
        );
        when(questionService.getAllQuestions()).thenReturn(questions);

        List<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
    }

    @Test
    void testGetQuestions_TooManyRequested() {
        List<Question> questions = List.of(
                new Question("Q1", "A1")
        );
        when(questionService.getAllQuestions()).thenReturn(questions);

        assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(5));
    }

    @Test
    void testGetQuestions_AllUnique() {
        List<Question> questions = Arrays.asList(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"),
                new Question("Q3", "A3")
        );
        when(questionService.getAllQuestions()).thenReturn(questions);

        List<Question> result = examinerService.getQuestions(3);
        assertEquals(3, result.size());
        assertEquals(3, result.stream().distinct().count());
    }
}
