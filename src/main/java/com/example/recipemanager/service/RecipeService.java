package com.example.recipemanager.service;

import com.example.recipemanager.exception.UserNotFoundException;
import com.example.recipemanager.model.Recipe;
import com.example.recipemanager.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private final RecipeRepo recipeRepo;

    @Autowired
    public RecipeService(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    public Recipe addRecipe(Recipe recipe) {
        recipe.setRecipeCode(UUID.randomUUID().toString());
        return recipeRepo.save(recipe);
    }

    public List<Recipe> findAllRecipes() {
        return recipeRepo.findAll();
    }

    public Recipe updateRecipe(Recipe recipe)
    {
        return recipeRepo.save(recipe);
    }

    public Recipe findRecipeById(Long id)
    {
        return recipeRepo.findRecipeById(id).orElseThrow(() -> new UserNotFoundException("Recipe with id "+id+" not found "));
    }

    public void deleteRecipe(Long id){
        recipeRepo.deleteById(id);
    }


}
