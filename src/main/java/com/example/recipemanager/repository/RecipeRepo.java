package com.example.recipemanager.repository;

import com.example.recipemanager.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    //Long is the type of the primary key --> Long id
    Optional<Recipe> findRecipeById(Long id);
}
