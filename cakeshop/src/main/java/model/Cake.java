package model;

import javax.persistence.*;

@Entity
@Table(name="cakes")
public class Cake {

    private int id;
    private CakeType cakeType;
    private int quantity;
    private boolean available;
    private Shop shop;

    public Cake() {
    }

    public Cake(CakeType cakeType, int quantity, boolean available) {
        this.cakeType = cakeType;
        this.quantity = quantity;
        this.available = available;
        this.shop = null;


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "caketype")
    public CakeType getCakeType() {
        return cakeType;
    }

    public void setCakeType(CakeType cakeType) {
        this.cakeType = cakeType;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "available")
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

//    Add a method to see all cake orders
//    public int getAllCakeOrders () {
//        return this.cakeOrders();
//    }
//
//    public void setCakeOrders(int cakeOrders) {
//        this.cakeOrders = cakeOrders;
//    }

    @ManyToOne
    @JoinColumn(name ="shop")
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
