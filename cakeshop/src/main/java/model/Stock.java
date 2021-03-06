package model;

import javax.persistence.*;

@Entity
@Table(name="stock")
public class Stock {

    private int id;
    private String cakeType;
    private int quantity;
    private double price;
    private boolean available;
    private Shop shop;

    public Stock() {
    }

    public Stock(String cakeType, int quantity, double price, boolean available) {
        this.cakeType = cakeType;
        this.quantity = quantity;
        this.price = price;
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
    public String getCakeType() {
        return cakeType;
    }

    public void setCakeType(String cakeType) {
        this.cakeType = cakeType;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "available")
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @ManyToOne
    @JoinColumn(name ="shop")
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int SellQuantity(int count){
        this.quantity = quantity - count;
        return quantity;

    }

    public int BuyQuantity(int count){
        this.quantity = quantity + count;
        return quantity;
    }
}

