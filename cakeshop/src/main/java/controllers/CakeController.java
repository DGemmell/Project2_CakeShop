package controllers;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import db.DBHelper;
import db.Seeds;
import model.Stock;
import model.CakeType;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

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

//Home page
            get("/cakeshop", (req, res)->{
                HashMap<String, Object> model = new HashMap
                        <String, Object>();
                List<Stock> stock = DBHelper.getAll(Stock.class);
                model.put("stock", stock);
                model.put("template", "templates/stock/index.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

        get("/cakeshop/updatecake", (req, res)->{
            HashMap<String, Object> model = new HashMap<>();
            List<Stock> cakes = DBHelper.getAll(Stock.class);
            List<CakeType> cakeTypes = DBHelper.allCakeTypes();
            model.put("cakes", cakes);
            model.put("template", "templates/stock/update.vtl");
            model.put("caketypes", cakeTypes);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//add a new cake from cake shop
        get("/cakeshop/newcake", (req, res)->{
            HashMap<String, Object> model = new HashMap<>();
            List<Stock> stock = DBHelper.getAll(Stock.class);
            List<CakeType> cakeTypes = DBHelper.allCakeTypes();
            model.put("stock", stock);
            model.put("template", "templates/stock/create.vtl");
            model.put("caketypes", cakeTypes);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//updating a cake
        get("/cakeshop/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(Stock.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/stock/show.vtl");
            model.put("stock", stock);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/cakeshop/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(Stock.class, intId);
            List<Stock> cakes = DBHelper.getAll(Stock.class);
            Map<String, Object> model = new HashMap<>();
            model.put("stock", stock);
            model.put("template", "templates/stock/edit.vtl");
            model.put("stock", stock);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post ("/cakeshop", (req, res) -> {
            String cakeType = req.queryParams("cakeType");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double price = Double.parseDouble(req.queryParams("price"));
            Stock cake = new Stock(cakeType, quantity, price, true);
            DBHelper.saveOrUpdate(cake);
            res.redirect("/cakeshop");
            return null;
        }, new VelocityTemplateEngine());


        post ("/cakeshop/updatecake", (req, res) -> {
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            String strcaketype = req.queryParams("caketype");
            CakeType enumCakeType = CakeType.valueOf(strcaketype);
            Stock cake = new Stock("brownie", quantity,15.00, true);
            DBHelper.saveOrUpdate(cake);
            res.redirect("/home");
            return null;
        }, new VelocityTemplateEngine());

        post ("/cakeshop/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(Stock.class, intId);
            int stockId = Integer.parseInt(req.queryParams("stock"));
            String cakeType  = req.queryParams("cakeType");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double price = Double.parseDouble(req.queryParams("price"));

            stock.setCakeType(cakeType);
            stock.setQuantity(quantity);
            stock.setPrice(price);
            DBHelper.saveOrUpdate(stock);
            res.redirect("/cakeshop");
            return null;

        }, new VelocityTemplateEngine());

        post ("/cakeshop/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(Stock.class, intId);

            String cakeType = req.queryParams("caketype");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double price = Double.parseDouble(req.queryParams("price"));

            stock.setCakeType(cakeType);
            stock.setQuantity(quantity);
            stock.setPrice(price);

            DBHelper.saveOrUpdate(stock);
            res.redirect("/cakeshop/:id");
            return null;

        }, new VelocityTemplateEngine());

        post ("/cakeshop/:id/delete", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(Stock.class, intId);
            DBHelper.delete(stock);
            res.redirect("/cakeshop/");
            return null;
        }, new VelocityTemplateEngine());

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });



    }
}
