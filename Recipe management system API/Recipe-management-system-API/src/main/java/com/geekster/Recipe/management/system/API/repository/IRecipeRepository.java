package com.geekster.Recipe.management.system.API.repository;

import com.geekster.Recipe.management.system.API.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe , Integer> {
    @Modifying
    @Query(value = "update recipe set recipe_Name = :recipeName, recipe_Ingredients = :recipeIngredients , recipe_Instructions = :recipeInstructions where recipe_Id = :recipeId" , nativeQuery = true)
    void updatedRecipe(Integer recipeId, String recipeName, String recipeIngredients, String recipeInstructions);
}
