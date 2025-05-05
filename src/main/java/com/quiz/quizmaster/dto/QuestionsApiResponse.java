package com.quiz.quizmaster.dto;

import java.util.List;

public class QuestionsApiResponse {
    private int response_code;
    private List<QuestionDTO> results;

    public int getResponseCode() {
        return response_code;
    }
    public void setResponseCode(int response_code) {
        this.response_code = response_code;
    }
    public List<QuestionDTO> getResults() {
        return results;
    }
    public void setResults(List<QuestionDTO> results) {
        this.results = results;
    }
}
