package control;

import spark.Request;
import spark.Response;
import dao.GenericDao;
import model.RecipeOwner;

public class LoginRegister {

    public static Object login(Request req, Response res) {

        res.redirect("/");
        return "ok";
    }

    public static Object register(Request req, Response res) {
        String name = req.queryParams("inputName");
        String email = req.queryParams("inputEmail");
        String password = req.queryParams("inputPassword");

        RecipeOwner owner = new RecipeOwner();
        owner.setEmail(email);
        owner.setName(name);
        owner.setPassword(password);

        GenericDao<RecipeOwner> dao = new GenericDao<>();

        try {
            dao.save(owner);
        } catch (Exception e) {
            System.out.println("deu craps");
            return "internal server error craps";
        }

        res.redirect("/");
        return "ok";
    }
}
