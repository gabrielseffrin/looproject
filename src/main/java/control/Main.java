package control;

import static spark.Spark.*;

import spark.template.velocity.VelocityTemplateEngine;

public class Main {
	public static void main(String[] args) {

		VelocityTemplateEngine engine = new VelocityTemplateEngine();
		staticFiles.location("/public");

		/* links */
		get("/", Common::pageHome, engine);
		get("/header", Common::header, engine);
		get("/login/login", Common::login, engine);
		get("/register/register", Common::register, engine);
		get("/footer", Common::footer, engine);
		get("/minMenu", Common::minMenu, engine);
		get("/recipes/recipes", Common::recipes, engine);
		get("/recipeCreation/recipeCreation", Common::createRecipe, engine);
		get("/userRecipes/recipeBook", Common::recipeBook, engine);

		/* login and register */
		post("/register", LoginRegister::register);
		post("/login", LoginRegister::login);
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