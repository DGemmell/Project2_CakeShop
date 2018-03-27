package model;

import java.util.ArrayList;

public class Shop {

    private int id;
    private String name;
    private ArrayList<Cake> cakes;

    public Shop(String name, ArrayList<Cake> cakes) {
        this.name = name;
        this.cakes = cakes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(ArrayList<Cake> cakes) {
        this.cakes = cakes;
    }


    public void updateName() {
        this.name = name;
    }
}


