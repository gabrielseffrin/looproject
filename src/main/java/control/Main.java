package control;

import dao.GenericDao;
import model.Recipe;
import model.RecipeOwner;

public class Main {
	public static void main(String[] args) {
		
		RecipeOwner man = new RecipeOwner();
		Recipe recipe = new Recipe();
		
		man.setEmail("gabrielseffrin@gmail.com");
		man.setName("Gabriel");
		man.setPassword("123");
		
		recipe.setCategory('A');
		recipe.setOwner(man);
		recipe.setNote("manda bala");
		recipe.setPreparationMode("mistura e boas");
		recipe.setStatus(true);
				
		man.setRecipe(recipe);
		
		GenericDao<RecipeOwner> genericOwner = new GenericDao<RecipeOwner>();
		GenericDao<Recipe> genericRecipe = new GenericDao<Recipe>();
		
		genericOwner.save(man);
		genericRecipe.save(recipe);
	}
}
