package control;

import static spark.Spark.*;

import dao.GenericDao;
import model.Recipe;
import model.RecipeOwner;
import spark.template.velocity.VelocityTemplateEngine;

public class Main {
	public static void main(String[] args) {

		VelocityTemplateEngine engine = new VelocityTemplateEngine();
		staticFiles.location("/public"); // informando ao velocity sobre o css

		get("/", Common::pageHome, engine);
		get("/header", Common::header, engine);
		get("/footer", Common::footer, engine);
		get("/minMenu", Common::minMenu, engine);
		get("/recipes/recipes", Common::recipes, engine);
		get("/recipeCreation/recipeCreation", Common::createRecipe, engine);
		get("/userRecipes/recipeBook", Common::recipeBook, engine);
		/*
		 * RecipeOwner man = new RecipeOwner();
		 * Recipe recipe = new Recipe();
		 * 
		 * man.setEmail("gabrielseffrin@gmail.com");
		 * man.setName("Gabriel");
		 * man.setPassword("123");
		 * 
		 * recipe.setCategory('A');
		 * recipe.setOwner(man);
		 * recipe.setNote("manda bala");
		 * recipe.setPreparationMode("mistura e boas");
		 * recipe.setStatus(true);
		 * 
		 * man.setRecipe(recipe);
		 * 
		 * GenericDao<RecipeOwner> genericOwner = new GenericDao<RecipeOwner>();
		 * GenericDao<Recipe> genericRecipe = new GenericDao<Recipe>();
		 * 
		 * genericOwner.save(man);
		 * genericRecipe.save(recipe);
		 */
	}
}