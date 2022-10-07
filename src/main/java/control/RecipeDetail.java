package control;

import spark.Request;
import spark.Response;

import java.util.HashMap;

import dao.GenericDao;
import model.Recipe;
import spark.ModelAndView;

public class RecipeDetail {

    public static ModelAndView recipeDetail(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        GenericDao<Recipe> gDao = new GenericDao<>();
        Recipe recipe = new Recipe();

        try {
            long id_recipe = Long.parseLong(req.params("id"));

            recipe = gDao.getObjectById(recipe, id_recipe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("erro no banco");
        }

        model.put("recipe", recipe);
        return new ModelAndView(model, "view/recipeDetail/recipeDetail.vm");
    }
}
