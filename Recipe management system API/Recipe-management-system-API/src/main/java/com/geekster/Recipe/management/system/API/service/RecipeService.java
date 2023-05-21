package com.geekster.Recipe.management.system.API.service;

import com.geekster.Recipe.management.system.API.model.Comment;
import com.geekster.Recipe.management.system.API.model.Recipe;
import com.geekster.Recipe.management.system.API.repository.ICommentRepository;
import com.geekster.Recipe.management.system.API.repository.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private IRecipeRepository iRecipeRepository;
    @Autowired
    private ICommentRepository iCommentRepository;

    public void saveRecipe(Recipe recipe) {
        try {

            List<Comment> commentList = recipe.getComments();
            for (Comment commentObj : commentList) {
                 commentObj.setRecipe(recipe);
            }
            iRecipeRepository.save(recipe);

           }catch (Exception e){
            throw e;
        }
    }
    public List<Recipe> getAllrecepe() {
        return iRecipeRepository.findAll();
    }

    public Recipe getRecipeById(Integer recipeId) {
       return iRecipeRepository.findById(recipeId).get();
    }
    @Transactional
    public String updateRecipe(Recipe updatedRecipe) {
        iRecipeRepository.updatedRecipe(updatedRecipe.getRecipeId(),updatedRecipe.getRecipeName(),updatedRecipe.getRecipeIngredients(),updatedRecipe.getRecipeInstructions());
        return "Recipe updated Successfully!!";
    }

    public String deleteRecipe(Integer recipeId) {
        iRecipeRepository.deleteById(recipeId);
        return "Recipe deleted Successfully!!";
    }
}
