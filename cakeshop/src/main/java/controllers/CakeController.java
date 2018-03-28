package controllers;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import db.DBHelper;
import db.Seeds;
import model.Stock;
import model.CakeType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;


public class CakeController {

    public static void main(String[] args) {

        Seeds.seedData();

        staticFileLocation("/public");

           get("/home", (req, res)->{
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
             }, new VelocityTemplateEngine());


            get("/cakeshop", (req, res)->{
                HashMap<String, Object> model = new HashMap<String, Object>();
                List<Stock> cakes = DBHelper.getAll(Stock.class);
                model.put("cakes", cakes);
                model.put("template", "templates/index.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

        get("/cakeshop/updatecake", (req, res)->{
            HashMap<String, Object> model = new HashMap<>();
            List<Stock> cakes = DBHelper.getAll(Stock.class);
            List<CakeType> cakeTypes = DBHelper.allCakeTypes();
            model.put("cakes", cakes);
            model.put("template", "templates/update.vtl");
            model.put("caketypes", cakeTypes);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/cakeshop/updatecake", (req, res) -> {
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            String strcaketype = req.queryParams("caketype");
            CakeType enumCakeType = CakeType.valueOf(strcaketype);
            Stock cake = new Stock(enumCakeType, quantity,15.00, true);
            DBHelper.saveOrUpdate(cake);
            res.redirect("/home");
            return null;
        }, new VelocityTemplateEngine());






    }
}
