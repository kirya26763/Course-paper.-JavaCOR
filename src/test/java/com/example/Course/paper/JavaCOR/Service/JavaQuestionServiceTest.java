package com.example.Course.paper.JavaCOR.Service;

import com.example.Course.paper.JavaCOR.Model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {


    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    void testAddAndGetAllQuestions() {
        Question q = new Question("Что такое JVM?", "Java Virtual Machine");
        service.add(q);
        Collection<Question> all = service.getAll();
        assertEquals(1, all.size());
        assertTrue(all.contains(q));
    }

    @Test
    void testPreventDuplicateQuestions() {
        Question q1 = new Question("Что такое Java?", "Язык");
        Question q2 = new Question("Что такое Java?", "Язык");
        service.add(q1);
        service.add(q2);
        Collection<Question> all = service.getAll();
        assertEquals(1, all.size());
    }

    @Test
    void testRemoveQuestion() {
        Question q = new Question("Что такое ООП?", "объектно-ориентированное программирование");
        service.add(q);
        Question removed = service.remove(q);
        assertEquals(q, removed);

        Question notFound = service.remove(new Question("Не существует", "нет"));
        assertNull(notFound);
    }

    @Test
    void testGetRandomQuestions() {
        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");
        service.add(q1);
        service.add(q2);

        Question random = service.getRandomQuestion();
        assertNotNull(random);
        assertTrue(service.getAll().contains(random));
    }

    @Test
    void testGetRandomQuestion_WhenEmpty() {
        assertNull(service.getRandomQuestion());
    }
}
