package com.example.kp3.controller;

import com.example.kp3.IllegalAmountException;
import com.example.kp3.model.Question;
import com.example.kp3.service.ExaminerService;
import com.example.kp3.service.ExaminerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @ExceptionHandler(IllegalAmountException.class)
    public ResponseEntity<String> illegalAmountHandler() {
        return ResponseEntity.badRequest().body("Недостаточно вопросов");
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
