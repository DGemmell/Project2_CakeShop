import model.Stock;
import model.CakeType;
import model.Shop;
import model.Stock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;
    private Stock cake1;
    private Stock cake2;
    private Stock cake3;
    private Stock cake4;
    private Stock cake5;


    @Before
    public void before(){
        cake1 = new Stock(CakeType.BROWNIE,40,10.00,true);
        cake2 = new Stock(CakeType.MILLIONAIRES_SHORTBREAD, 20,20.00, true);
        cake3 = new Stock(CakeType.ROCKY_ROAD, 25,8.00, true);
        cake4 = new Stock(CakeType.CARROT_CAKE,12,18.00, true);
        cake5 = new Stock(CakeType.CUP_CAKES, 100,3.00, true);
        ArrayList<Stock> cakes = new ArrayList();
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
