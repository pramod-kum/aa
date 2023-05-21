<center>
<h1> 🏚️Recipe management system API</h1>
</center>
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
</center>
This project is a Recipe management system project built using Spring Boot with Java.

---

## Framework Used
* Spring Boot

---

## Language Used
* Java

---

## Data Model

The Recipe and Comment Class is defined inside the model packages with validation anotation, which has the following attributes:
   
   inside Recipe Class:-
   
   recipeId : Recipe ID <br>
   recipeName : Recipe Name <br>
   recipeIngredients : Recipe Ingredients <br>
   recipeInstructions : Recipe Instructions <br>
   
   @OneToMany(cascade = CascadeType.ALL)<br>
   private List<Comment> comments<br>
   
   inside Comment Class:- <br>   
   commentId : Comment Id <br>
   comment : Comment <br>
   
   @ManyToOne <br>
   private Recipe recipe <br>

---

## Data Flow

1. The user sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

## Functions used :-

### API Endpoints :-
</br>

* PostMapping: /addRecipe

This endpoint makes a call to method in recipeService class which is connected to database. In database we add a new recipe given through API.

* PostMapping: /addCommentOnRecipe

This endpoint makes a call to method in commentService class which is connected to database. In database we add sum new Commants to a specific Recipe through API.

* GetMapping: /getRecipeById

This endpoint returns a specifi Recipi based on id through API.

* GetMapping: /getAllRecipes

This endpoint returns all Recipi through given API Endpoint.

* PutMapping: /updateById

This endpoint makes a call to method in RecipeService class which is connected to database. In database we update a Specific Recipe based on id.


* DeleteMapping: /deleteById

This endpoint makes a call to method in RecipeService class which is connected to database. In database we delete a Specific Recipe based on id.


## JpaRepository extended by IRecipeRepository And ICommentRepository interface.


We have used CrudRepository to implement CRUD Operations.

---

## 📝Project Summary

I have created Recipe management system project.  In this the you can add the Recipe , can add Commants on recipe.  Can delete Recipe update Recipe. based on given Endpoints.

![Alt text](https://media.tenor.com/Ra5kgH_k8yMAAAAj/thank-you-thank-you-heart.gif)
