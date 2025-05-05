package com.quiz.quizmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizmaster.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>  {

}
