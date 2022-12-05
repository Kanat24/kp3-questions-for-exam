package com.example.kp3.service;

import com.example.kp3.model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    public Question add(String questions, String answer);

    public Question add(Question question);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion();
}
