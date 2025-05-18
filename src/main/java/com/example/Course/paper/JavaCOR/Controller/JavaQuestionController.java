package com.example.Course.paper.JavaCOR.Controller;

import com.example.Course.paper.JavaCOR.Model.Question;
import com.example.Course.paper.JavaCOR.Service.JavaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    @Autowired
    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PostMapping("/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.addQuestion(new Question(question, answer));
        return "Вопрос успешно добавлен.";
    }

    @DeleteMapping("/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        boolean removed = javaQuestionService.removeQuestion(question);
        return removed ? "Вопрос успешно удалён." : "Вопрос не найден.";
    }

    @GetMapping
    public List<Question> getAllQuestions() {

        return javaQuestionService.getAllQuestions();
    }
}