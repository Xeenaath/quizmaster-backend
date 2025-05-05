package com.quiz.quizmaster.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriesApiResponse {
    @JsonProperty("trivia_categories")
    private List<CategoryDto> trivia_categories;

    public List<CategoryDto> getTriviaCategories() {
        return trivia_categories;
    }

    public void setTriviaCategories(List<CategoryDto> trivia_categories) {
        this.trivia_categories = trivia_categories;
    }
}
