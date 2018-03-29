package db;

import model.Stock;
import model.CakeType;
import model.Shop;
import model.Stock;

import java.util.List;

public class Seeds {

    public static void seedData() {

        DBHelper.deleteAll(Shop.class);
        DBHelper.deleteAll(Stock.class);
        Stock cake1 = new Stock("Brownie",40,10.00,true);
        Stock cake2 = new Stock("Millionaires Shortbread", 20,20.00, false);
        Stock cake3 = new Stock("Rocky Road", 25,8.00, true);
        Stock cake4 = new Stock("Carrot Cake",12,18.00, true);
        Stock cake5 = new Stock("Cup Cakes", 100,3.00, true);
        DBHelper.saveOrUpdate(cake1);
        DBHelper.saveOrUpdate(cake2);
        DBHelper.saveOrUpdate(cake3);
        DBHelper.saveOrUpdate(cake4);
        DBHelper.saveOrUpdate(cake5);

        List<Stock> cakes = DBHelper.getAll(Stock.class);

//        cakes.add(cake1);
//        cakes.add(cake2);
//        cakes.add(cake3);
//        cakes.add(cake4);

        Shop shop = new Shop("Betty Browns", cakes);
        cake1.setShop(shop);
        cake2.setShop(shop);
        cake3.setShop(shop);
        cake4.setShop(shop);
        cake5.setShop(shop);

        DBHelper.saveOrUpdate(shop);
        DBHelper.saveOrUpdate(cake1);
        DBHelper.saveOrUpdate(cake2);
        DBHelper.saveOrUpdate(cake3);
        DBHelper.saveOrUpdate(cake4);
        DBHelper.saveOrUpdate(cake5);


    }
}
