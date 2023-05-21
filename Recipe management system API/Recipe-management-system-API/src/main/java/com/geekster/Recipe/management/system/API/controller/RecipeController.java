package com.geekster.Recipe.management.system.API.controller;

import com.geekster.Recipe.management.system.API.model.Comment;
import com.geekster.Recipe.management.system.API.model.Recipe;
import com.geekster.Recipe.management.system.API.service.CommentService;
import com.geekster.Recipe.management.system.API.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/addRecipe")
    public ResponseEntity<String> addRecipe(@Validated @RequestBody Recipe recipe){

        HttpStatus status;

        try{
            recipeService.saveRecipe(recipe);
           status = HttpStatus.OK;
        }catch (Exception e){
            System.out.println(e);
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<String>(status);
    }
    @GetMapping("getRecipeById/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer recipeId) {
        Recipe recipe = recipeService.getRecipeById(recipeId);
        if (recipe != null) {
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getAllRecipes")
    public ResponseEntity<List<Recipe>> getAllRecipes() {

        List<Recipe> allList = recipeService.getAllrecepe();
        return new ResponseEntity<>(allList,HttpStatus.OK);
    }
    @PutMapping("/updateById")
    public ResponseEntity<String> updateRecipe( @Validated @RequestBody Recipe updatedRecipe) {
        String updatedMessage = recipeService.updateRecipe(updatedRecipe);

        return new ResponseEntity<>(updatedMessage, HttpStatus.OK);
}

    @DeleteMapping("deleteById/{recipeId}")
    public String deleteRecipe(@PathVariable Integer recipeId) {
        return recipeService.deleteRecipe(recipeId);

}

///////////////////////////////////////////////////////////////////////////
    @PostMapping("/addCommentOnRecipe")
    public String recipeComment(@Validated @RequestBody Comment comment) {
    return commentService.addComment(comment);

    }
}
