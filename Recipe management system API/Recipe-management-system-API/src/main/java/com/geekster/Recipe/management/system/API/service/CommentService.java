package com.geekster.Recipe.management.system.API.service;

import com.geekster.Recipe.management.system.API.model.Comment;
import com.geekster.Recipe.management.system.API.model.Recipe;
import com.geekster.Recipe.management.system.API.repository.ICommentRepository;
import com.geekster.Recipe.management.system.API.repository.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private ICommentRepository iCommentRepository;
    @Autowired
    private IRecipeRepository iRecipeRepository;

    public String addComment(Comment comment) {
        Recipe recipeObj = iRecipeRepository.findById(comment.getRecipe().getRecipeId()).get();
        comment.setRecipe(recipeObj);
        iCommentRepository.save(comment);
        return "Comment added successfully!!";
    }
}
