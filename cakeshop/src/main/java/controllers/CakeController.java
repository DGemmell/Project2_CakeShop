package controllers;
import static spark.Spark.get;
import static spark.Spark.staticFileLocation;
import model.Cake;
import model.CakeType;
import model.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;


public class CakeController {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/public");
            ArrayList<Cake> cakes = new ArrayList();
            Cake cake1 = new Cake(CakeType.BROWNIE,40,true);
            Cake cake2 = new Cake(CakeType.MILLIONAIRES_SHORTBREAD, 20, false);
            Cake cake3 = new Cake(CakeType.ROCKY_ROAD, 25, true);
            Cake cake4 = new Cake(CakeType.CARROT_CAKE,12, true);
            Cake cake5 = new Cake(CakeType.CUP_CAKES, 100, true);
            cakes.add(cake1);
            cakes.add(cake2);
            cakes.add(cake3);
            cakes.add(cake4);
            cakes.add(cake5);

            get("/cakeshop", (req, res)->{
                HashMap<String, Object> model = new HashMap<String, Object>();
                model.put("result", cakes);
                return new ModelAndView(model, "shop.vtl");
            }, velocityTemplateEngine);






    }
}
