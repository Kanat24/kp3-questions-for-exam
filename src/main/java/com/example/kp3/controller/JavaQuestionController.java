package com.example.kp3.controller;

import com.example.kp3.model.Question;
import com.example.kp3.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(String question, String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(Question question) {
        return javaQuestionService.remove(question);
    }

    @GetMapping("/")
    public Collection<Question> getAllQuestions() {
        return javaQuestionService.getAll();
    }

    @PostMapping("/")
    public Question createQuestion(@RequestBody Question question) {
        return javaQuestionService.add(question);
    }
}
