package com.example.kp3.service;

import com.example.kp3.model.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}
