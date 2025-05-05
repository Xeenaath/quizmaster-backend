package com.quiz.quizmaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizmaster.dto.QuestionsApiResponse;
import com.quiz.quizmaster.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public QuestionsApiResponse getQuiz(
            @RequestParam(defaultValue = "5") int amount,
            @RequestParam(defaultValue = "9") String category,
            @RequestParam(defaultValue = "easy") String difficulty) {
        return quizService.getQuestions(amount, category, difficulty);
    }
}