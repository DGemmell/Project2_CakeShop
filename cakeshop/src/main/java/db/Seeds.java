package db;

import model.Cake;
import model.CakeType;
import model.Shop;

import java.util.List;

public class Seeds {

    public static void seedData() {

        DBHelper.deleteAll(Shop.class);
        DBHelper.deleteAll(Cake.class);
        Cake cake1 = new Cake(CakeType.BROWNIE,40,true);
        Cake cake2 = new Cake(CakeType.MILLIONAIRES_SHORTBREAD, 20, false);
        Cake cake3 = new Cake(CakeType.ROCKY_ROAD, 25, true);
        Cake cake4 = new Cake(CakeType.CARROT_CAKE,12, true);
        Cake cake5 = new Cake(CakeType.CUP_CAKES, 100, true);
        DBHelper.saveOrUpdate(cake1);
        DBHelper.saveOrUpdate(cake2);
        DBHelper.saveOrUpdate(cake3);
        DBHelper.saveOrUpdate(cake4);
        DBHelper.saveOrUpdate(cake5);

        List<Cake> cakes = DBHelper.getAll(Cake.class);

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


    }
}
