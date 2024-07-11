package com.example.recipemanager;

import com.example.recipemanager.model.Recipe;
import com.example.recipemanager.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Resource Layer: Handles HTTP requests and responses

@RestController  //This annotation indicates that the class is a controller where
                 // every method returns a domain object instead of a view.
//RecipeResource controller methods return instances of the Recipe class, which are domain objects representing recipes.

@RequestMapping("/recipe")//all endpoints in this controller will be prefixed with /recipe.
public class RecipeResource {

    private final RecipeService recipeService; //variable that will hold an instance of RecipeService.


    //Constructor dependency injection. When Spring creates an instance of RecipeResource,
    // it will look for a RecipeService bean in the application context and pass it to the constructor:

public RecipeResource(RecipeService recipeService) { //constructor for the RecipeResource class
    this.recipeService = recipeService;
    //this.recipeService refers to the instance variable declared at the top of the class

}

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipe(){

    //List is a generic collection type in Java,
        // part of the java.util package, which can hold an ordered collection of objects.
    List<Recipe> recipes = recipeService.findAllRecipes(); //calls the findAllRecipes method from
        // the RecipeService to get a list of all recipes
    return new ResponseEntity<>(recipes, HttpStatus.OK);
}

    @GetMapping("/find/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id){
    //Path Variable: The method takes an id from the URL, which is passed to the service layer.
        Recipe recipe = recipeService.findRecipeById(id);
        //recipeService.findRecipeById(id) fetches a Recipe object corresponding to the provided ID.
        return new ResponseEntity<>(recipe, HttpStatus.OK);
        //The data returned from the service layer is passed back to the controller, which wraps it in a ResponseEntity.
    }


}
