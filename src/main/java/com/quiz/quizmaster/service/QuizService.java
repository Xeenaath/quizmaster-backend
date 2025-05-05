package com.quiz.quizmaster.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.quiz.quizmaster.dto.QuestionsApiResponse;

@Service
public class QuizService {

    private final RestTemplate restTemplate = new RestTemplate();

    public QuestionsApiResponse getQuestions(int amount, String category, String difficulty) {
        String url = String.format("https://opentdb.com/api.php?amount=%d&category=%s&difficulty=%s&type=multiple", amount, category, difficulty);
        return restTemplate.getForObject(url, QuestionsApiResponse.class);
    }
}