package com.quiz.quizmaster.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quiz.quizmaster.dto.CategoryDto;
import com.quiz.quizmaster.dto.CategoriesApiResponse;
import com.quiz.quizmaster.model.Category;
import com.quiz.quizmaster.repository.CategoryRepository;

@Service
public class CategoryService {
    private final RestTemplate restTemplate;
    private final CategoryRepository categoryRepository;

    public CategoryService(RestTemplate restTemplate, CategoryRepository categoryRepository) {
        this.restTemplate = restTemplate;
        this.categoryRepository = categoryRepository;
    }

    public void fetchAndStoreCategories() {
        String url = "https://opentdb.com/api_category.php";

        CategoriesApiResponse response = restTemplate.getForObject(url, CategoriesApiResponse.class);

        if (response != null && response.getTriviaCategories() != null) {
            List<Category> categories = response.getTriviaCategories().stream()
                .map(this::mapDtoToEntity)
                .collect(Collectors.toList());

            categoryRepository.saveAll(categories);
        }
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    private Category mapDtoToEntity(CategoryDto dto) {
        return new Category(dto.getId(), dto.getName());
    }

}
