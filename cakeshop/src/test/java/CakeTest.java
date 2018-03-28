import model.Cake;
import model.CakeType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CakeTest {

    private Cake cake;

    @Before
    public void before(){
        this.cake = new Cake(CakeType.BROWNIE, 40,10.00, true);

    }

    @Test
    public void canGetCakeType(){
        assertEquals(CakeType.BROWNIE, cake.getCakeType());

    }

    @Test
    public void canGetQuantity(){
        assertEquals(40, cake.getQuantity());
    }

    @Test
    public void canGetPrice(){
        assertEquals(10.00, cake.getPrice(),0.1);
    }

    @Test
    public void availableTrue(){
        assertEquals(true, cake.isAvailable());
    }

    @Test
    public void availableFalse(){
        cake.setAvailable(false);
        assertEquals(false, cake.isAvailable());
    }


}
