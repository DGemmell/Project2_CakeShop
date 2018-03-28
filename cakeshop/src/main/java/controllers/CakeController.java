package controllers;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import db.DBHelper;
import db.Seeds;
import model.Cake;
import model.CakeType;
import model.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
                List<Cake> cakes = DBHelper.getAll(Cake.class);
                model.put("cakes", cakes);
                model.put("template", "templates/index.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

        get("/cakeshop/newcake", (req, res)->{
            HashMap<String, Object> model = new HashMap<>();
            List<Cake> cakes = DBHelper.getAll(Cake.class);
            model.put("cakes", cakes);
            model.put("template", "templates/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/cakeshop/newcake", (req, res) -> {
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            String strcaketype = req.queryParams("caketype");
            CakeType enumCakeType = CakeType.valueOf(strcaketype);
            Cake cake = new Cake(enumCakeType, quantity, true);
            DBHelper.saveOrUpdate(cake);
            res.redirect("/home");
            return null;
        }, new VelocityTemplateEngine());






    }
}
