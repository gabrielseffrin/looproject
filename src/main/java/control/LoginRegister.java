package control;

import spark.Request;
import spark.Response;
import dao.GenericDao;
import model.RecipeOwner;

public class LoginRegister {

    public static Object register(Request req, Response res) {

        String name = req.queryParams("inputName");
        String email = req.queryParams("inputEmail");
        String password = req.queryParams("inputPassword");

        RecipeOwner owner = new RecipeOwner();
        owner.setEmail(email);
        owner.setName(name);
        owner.setPassword(password);

        GenericDao<RecipeOwner> gDaoOwner = new GenericDao<>();

        try {
            gDaoOwner.save(owner);
        } catch (Exception e) {
            System.out.println("deu craps");
            return "internal server error craps";
        }

        res.redirect("/");
        return "ok";
    }

    public static Object login(Request req, Response res) {

        String email = req.queryParams("inputEmail");
        String password = req.queryParams("inputPassword");

        GenericDao<RecipeOwner> gDaoOwner = new GenericDao<>();

        try {

            Object ownere = gDaoOwner.getObjectByEmailAndPassword(email, password);
            System.out.println("aaa " + ownere);
            if (ownere == null) {
                System.out.println(ownere);
            }
        } catch (Exception e) {
            System.out.println("senha ou email incorretos");
        }

        res.redirect("/");
        return "ok";
    }
}
