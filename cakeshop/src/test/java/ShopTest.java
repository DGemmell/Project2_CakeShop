import model.Cake;
import model.CakeType;
import model.Shop;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;
    private Cake cake1;
    private Cake cake2;
    private Cake cake3;
    private Cake cake4;
    private Cake cake5;


    @Before
    public void before(){
        cake1 = new Cake(CakeType.BROWNIE,40,10.00,true);
        cake2 = new Cake(CakeType.MILLIONAIRES_SHORTBREAD, 20,20.00, true);
        cake3 = new Cake(CakeType.ROCKY_ROAD, 25,8.00, true);
        cake4 = new Cake(CakeType.CARROT_CAKE,12,18.00, true);
        cake5 = new Cake(CakeType.CUP_CAKES, 100,3.00, true);
        ArrayList<Cake> cakes = new ArrayList();
        cakes.add(cake1);
        cakes.add(cake2);
        cakes.add(cake3);
        cakes.add(cake4);
        cakes.add(cake5);

        shop = new Shop("Betty Browns", cakes );
    }

    @Test
    public void canGetName(){
        assertEquals("Betty Browns", shop.getName());
    }

    @Test
    public void canUpdateName(){
        shop.setName("Betty Better Browns");
        assertEquals("Betty Better Browns", shop.getName());
    }

    @Test
    public void canGetCakelist(){

    }









}
