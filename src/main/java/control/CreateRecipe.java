package control;

import spark.Request;
import spark.Response;
import dao.GenericDao;

public class CreateRecipe {

    public static void CreateRecipe(Request req, Response res) {
        String ingredients = req.queryParams("inputIngredients");
        String preparationMode = req.queryParams("inputPrapararionMode");
        String note = req.queryParams("inputNote");
        boolean isPublic = Boolean.parseBoolean(req.queryParams("inputIsPublic"));

    }
}
