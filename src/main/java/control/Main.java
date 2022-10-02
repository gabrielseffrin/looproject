package control;

import static spark.Spark.*;

import java.util.HashMap;

import dao.GenericDao;
import model.Recipe;
import model.RecipeOwner;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

public class Main {
	public static void main(String[] args) {

		VelocityTemplateEngine engine = new VelocityTemplateEngine();
		staticFiles.location("/public"); // informando ao velocity sobre o css

		get("/", Main::pageHome, engine);
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

	private static ModelAndView pageHome(Request req, Response res) {
		HashMap<String, Object> model = new HashMap<>();
		return new ModelAndView(model, "view/index.vm");
	}
}
