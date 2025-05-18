package com.example.Course.paper.JavaCOR.Service;

import com.example.Course.paper.JavaCOR.Model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    void testAddAndGetAllQuestions() {
        Question q = new Question("Что такое JVM?", "Java Virtual Machine");
        service.addQuestion(q);
        List<Question> all = service.getAllQuestions();
        assertEquals(1, all.size());
        assertEquals(q, all.get(0));
    }

    @Test
    void testRemoveQuestion() {
        Question q = new Question("Что такое OOP?", "Object Oriented Programming");
        service.addQuestion(q);
        assertTrue(service.removeQuestion("Что такое OOP?"));
        assertFalse(service.removeQuestion("Не существует"));
    }

    @Test
    void testFindQuestion() {
        Question q = new Question("Что такое Java?", "Язык программирования");
        service.addQuestion(q);
        Optional<Question> found = service.findQuestion("Что такое Java?");
        assertTrue(found.isPresent());
        assertEquals(q, found.get());
    }

    @Test
    void testGetRandomQuestions_Unique() {
        service.addQuestion(new Question("Q1", "A1"));
        service.addQuestion(new Question("Q2", "A2"));
        service.addQuestion(new Question("Q3", "A3"));
        List<Question> random = service.getRandomQuestions(2);
        assertEquals(2, random.size());
        assertNotEquals(random.get(0), random.get(1));
    }

    @Test
    void testGetRandomQuestions_RequestMoreThanAvailable() {
        service.addQuestion(new Question("Q1", "A1"));
        service.addQuestion(new Question("Q2", "A2"));
        List<Question> random = service.getRandomQuestions(5); // должно вернуть максимум 2
        assertTrue(random.size() <= 2);
    }
}