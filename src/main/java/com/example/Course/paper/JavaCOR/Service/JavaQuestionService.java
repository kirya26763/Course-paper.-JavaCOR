package com.example.Course.paper.JavaCOR.Service;

import com.example.Course.paper.JavaCOR.Model.Question;
import com.example.Course.paper.JavaCOR.Service.Interfaces.QuestionService;
import com.example.Course.paper.JavaCOR.Util.RandomUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public boolean removeQuestion(String questionText) {
        return questions.removeIf(q -> q.getQuestion().equalsIgnoreCase(questionText));
    }

    @Override
    public Optional<Question> findQuestion(String questionText) {
        return questions.stream()
                .filter(q -> q.getQuestion().equalsIgnoreCase(questionText))
                .findFirst();
    }

    @Override
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }

    @Override
    public List<Question> getRandomQuestions(int amount) {
        Set<Integer> usedIndexes = new HashSet<>();
        List<Question> result = new ArrayList<>();

        while (result.size() < amount && usedIndexes.size() < questions.size()) {
            int index = RandomUtil.getRandomQuestion(questions.size());
            if (usedIndexes.add(index)) {
                result.add(questions.get(index));
            }
        }

        return result;
    }
}