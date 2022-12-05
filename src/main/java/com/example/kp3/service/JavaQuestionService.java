package com.example.kp3.service;

import com.example.kp3.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
   private static final Random RANDOM = new Random();

    private final Set<Question> questions = new HashSet<>();

    public Set<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        this.questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)){
            throw new IllegalArgumentException("This question is not on the list.");
        }
        this.questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()){
            throw new IllegalArgumentException("В списке нет вопросов");
        }
        return questions.stream().skip(RANDOM.nextInt(0, questions.size())).findFirst().orElseThrow();
    }
}
