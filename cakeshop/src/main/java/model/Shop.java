package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shop")
public class Shop {

    private int id;
    private String name;
    private List<Stock> cakes;

    public Shop() {
    }

    public Shop(String name, List<Stock> cakes) {
        this.name = name;
        this.cakes = cakes;
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

    @Column(name ="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shop")
    public List<Stock> getCakes() {
        return cakes;
    }

    public void setCakes(List<Stock> cakes) {
        this.cakes = cakes;
    }


//    public void updateName() {
//        this.name = name;
//    }
}


