package com.example.kp3;

import com.example.kp3.model.Question;
import com.example.kp3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void addTest1() {
        Question question1 = new Question("How are you", "My name is Sergey");
        String question = "How are you";
        String answer = "My name is Sergey";
        Assertions.assertEquals(question1, javaQuestionService.add(question, answer));
        Assertions.assertEquals(1, javaQuestionService.getQuestions().size());
    }
    @Test
    public void removeTest1() {
        String question = "How are you";
        String answer = "My name is Sergey";
        Question question1 = new Question(question, answer);
        javaQuestionService.add(question1);
        javaQuestionService.remove(question1);
        Assertions.assertEquals(0, javaQuestionService.getQuestions().size());
    }
    @Test
    public void removeTest2() {
        String question = "How are you";
        String answer = "My name is Sergey";
        Question question1 = new Question(question, answer);
        Question question2 = new Question("hi", "by");
        javaQuestionService.add(question1);
        Assertions.assertThrows(IllegalArgumentException.class, ()->javaQuestionService.remove(question2));
    }
    @Test
    public void getAll() {
        Question question2 = new Question("hi2", "by2");
        Question question1 = new Question("hi1", "by1");
        Question question = new Question("hi", "by");
        javaQuestionService.add(question);
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        Assertions.assertEquals(3, javaQuestionService.getAll().size());
    }

    @Test
    public void getRandomQuestionTest() {
        Question question2 = new Question("hi2", "by2");
        Question question1 = new Question("hi1", "by1");
        Question question = new Question("hi", "by");
        javaQuestionService.add(question);
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        Question questionResult = javaQuestionService.getRandomQuestion();
        org.assertj.core.api.Assertions.assertThat(javaQuestionService.getAll().contains(questionResult));
    }
    @Test
    public  void getRandomQuestionTest2(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->javaQuestionService.getRandomQuestion());
    }
}
