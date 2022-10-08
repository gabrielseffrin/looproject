package control;

import dao.GenericDao;
import model.Recipe;
import model.RecipeOwner;
import spark.Request;
import spark.Response;

public class CreateRecipe {

    public static Object createRecipe(Request req, Response res) {

        try {

            String nameRecipe = req.queryParams("inputNameRecipe");
            String ingredients = req.queryParams("inputIngredients");
            String preparationMode = req.queryParams("inputPrapararionMode");
            String note = req.queryParams("inputNote");
            String catogory = req.queryParams("inputCategory");
            boolean isPublic = Boolean.parseBoolean(req.queryParams("inputIsPublic"));
            System.out.println(catogory);
            System.out.println(isPublic);
            System.out.println(isPublic);
            System.out.println(isPublic);
            boolean status = true;

            Recipe recipe = new Recipe();
            RecipeOwner owner = new RecipeOwner();
            GenericDao<RecipeOwner> gDaoOwner = new GenericDao<>();
            recipe.setNameRecipe(nameRecipe);
            recipe.setIngredients(ingredients);
            recipe.setPreparationMode(preparationMode);
            recipe.setNote(note);
            recipe.setCategory(catogory);
            recipe.setIsPublic(isPublic);
            recipe.setStatus(status);
            recipe.setOwner(gDaoOwner.getObjectById(owner, 9));

            GenericDao<Recipe> gDaoRecipe = new GenericDao<>();
            gDaoRecipe.save(recipe);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        res.redirect("/recipes/recipes");
        return "ok";
    }
}
