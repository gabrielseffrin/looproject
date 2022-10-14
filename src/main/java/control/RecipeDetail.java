package control;

import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import dao.GenericDao;
import model.Recipe;
import spark.ModelAndView;

public class RecipeDetail {

    public static ModelAndView recipeDetail(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        GenericDao<Recipe> gDao = new GenericDao<>();
        Recipe recipe = new Recipe();
        String ingredient = "";

        try {
            long id_recipe = Long.parseLong(req.params("id"));

            recipe = gDao.getObjectById(recipe, id_recipe);
            String[] ingredients = recipe.getIngredients().split(";\\s");

            ArrayList<String> ingredienList = new ArrayList<>();

            for (int i = 0; i < ingredients.length; i++) {
                ingredienList.add(ingredients[i]);

                System.out.println(ingredient.toString());
            }

            Iterator<String> aux = ingredienList.iterator();
            while (aux.hasNext()) {
                ingredient += aux.next() + "<br>";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("erro no banco");
        }

        model.put("ingredients", ingredient);
        model.put("recipe", recipe);
        return new ModelAndView(model, "view/recipeDetail/recipeDetail.vm");
    }
}
