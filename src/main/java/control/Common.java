package control;

import java.util.HashMap;

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
        return new ModelAndView(model, "view/recipes/recipes.vm");
    }
}
