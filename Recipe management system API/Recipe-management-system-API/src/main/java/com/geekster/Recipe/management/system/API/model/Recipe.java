package com.geekster.Recipe.management.system.API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Recipe.class, property = "recipeId")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;

    @NotBlank
    @Size(max = 100)
    private String recipeName;

    @NotBlank
    @Size(max = 1000)
    private String recipeIngredients;

    @NotBlank
    @Size(max = 1000)
    private String recipeInstructions;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "recipe")
    private List<Comment> comments;
}
