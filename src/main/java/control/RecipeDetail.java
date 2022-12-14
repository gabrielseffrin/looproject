package control;

import spark.Request;
import spark.Response;
import util.FormatList;

import java.util.ArrayList;
import java.util.HashMap;

import dao.GenericDao;
import model.Recipe;
import spark.ModelAndView;

public class RecipeDetail {

    public static ModelAndView recipeDetail(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        GenericDao<Recipe> gDao = new GenericDao<>();
        Recipe recipe = new Recipe();

        ArrayList<String> dataRecipe = new ArrayList<>();

        try {
            long id_recipe = Long.parseLong(req.params("id"));

            recipe = gDao.getObjectById(recipe, id_recipe);

            dataRecipe.add(FormatList.formatList(recipe.getIngredients()));
            dataRecipe.add(FormatList.formatList(recipe.getPreparationMode()));
            dataRecipe.add(FormatList.formatList(recipe.getNote()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("erro no banco");
        }

        if (SessionControl.getInstance().getUser().getId() == recipe.getOwner().getId())
            model.put("edit",
                    "<a class='btn btn-danger text-white' style='background-color: #dd4b39;' href='#!' role='button'>" +
                            "<i class='far fa-edit'></i></a>");
        else
            model.put("edit", "");

        model.put("dataRecipe", dataRecipe);
        model.put("recipe", recipe);
        return new ModelAndView(model, "view/recipeDetail/recipeDetail.vm");
    }
}
