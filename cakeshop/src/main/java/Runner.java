import db.DBHelper;
import model.Cake;
import model.CakeType;
import model.Shop;
import org.hibernate.annotations.SourceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {

        DBHelper.deleteAll(Shop.class);
        DBHelper.deleteAll(Cake.class);
        Cake cake1 = new Cake(CakeType.BROWNIE,50,10.00,true);
        Cake cake2 = new Cake(CakeType.MILLIONAIRES_SHORTBREAD, 20,15.00, false);
        Cake cake3 = new Cake(CakeType.ROCKY_ROAD, 25,8.00, true);
        Cake cake4 = new Cake(CakeType.CARROT_CAKE,12,18.00, true);
        Cake cake5 = new Cake(CakeType.CUP_CAKES, 110,3.00, true);
        cake5.SellQuantity(20);
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

        List<CakeType> allCakeTypes = DBHelper.allCakeTypes();




    }
}
