import db.DBHelper;
import model.Stock;
import model.CakeType;
import model.Shop;
import model.Stock;
import org.hibernate.annotations.SourceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {

        DBHelper.deleteAll(Shop.class);
        DBHelper.deleteAll(Stock.class);
        Stock cake1 = new Stock("BROWNIE",50,10.00,true);
        Stock cake2 = new Stock("MILLIONAIRES_SHORTBREAD", 20,15.00, false);
        Stock cake3 = new Stock("ROCKY_ROAD", 25,8.00, true);
        Stock cake4 = new Stock("CARROT_CAKE",12,18.00, true);
        Stock cake5 = new Stock("CUP_CAKES", 110,3.00, true);
        cake5.SellQuantity(20);
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

        Shop shop = new Shop("Betty Browns",cakes);
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

        List<CakeType> allCakeTypes = DBHelper.allCakeTypes();




    }
}
