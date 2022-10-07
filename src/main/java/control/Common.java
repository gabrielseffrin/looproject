package control;

import java.util.HashMap;

import antlr.collections.List;
import dao.DaoRecipe;
import dao.GenericDao;
import model.Recipe;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class Common {

    public static ModelAndView pageHome(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "view/index.vm");
    }

    public static ModelAndView header(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "view/header.vm");
    }

    public static ModelAndView login(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "view/login/login.vm");
    }

    public static ModelAndView register(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "view/register/userRegister.vm");
    }

    public static ModelAndView footer(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "view/footer.vm");
    }

    public static ModelAndView minMenu(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "view/minMenu.vm");
    }

    public static ModelAndView recipes(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        DaoRecipe gRecipe = new DaoRecipe();
        Recipe recipe = new Recipe();
        model.put("allrecipes", gRecipe.listRecipesPublic(recipe));
        return new ModelAndView(model, "view/recipes/recipes.vm");
    }

    public static ModelAndView createRecipe(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "view/recipeCreation/recipeCreation.vm");
    }

    public static ModelAndView recipeBook(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        DaoRecipe gRecipe = new DaoRecipe();
        Recipe recipe = new Recipe();
        model.put("allrecipes", gRecipe.getElementsByIdRecipeOwner(recipe, 1));
        return new ModelAndView(model, "view/userRecipes/recipeBook.vm");
    }
}
