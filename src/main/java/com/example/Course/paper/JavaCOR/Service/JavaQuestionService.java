package com.example.Course.paper.JavaCOR.Service;

import com.example.Course.paper.JavaCOR.Model.Question;
import com.example.Course.paper.JavaCOR.Service.Interfaces.QuestionService;
import com.example.Course.paper.JavaCOR.Util.RandomUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        // Возвращаем null, если вопрос уже был (или можно выбросить исключение)
        return null;
    }

    @Override
    public Question remove(Question question) {
        boolean removed = questions.remove(question);
        return removed ? question : null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions); // защитим от изменений извне
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null; // или выбросить исключение
        }
        int index = RandomUtil.getRandomQuestion(questions.size());
        return new ArrayList<>(questions).get(index);
    }
}