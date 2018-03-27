package model;

public class Cake {

    private int id;
    private CakeType cakeType;
    private int quantity;
    private boolean available;

    public Cake(CakeType cakeType, int quantity, boolean available) {
        this.cakeType = cakeType;
        this.quantity = quantity;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CakeType getCakeType() {
        return cakeType;
    }

    public void setCakeType(CakeType cakeType) {
        this.cakeType = cakeType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
