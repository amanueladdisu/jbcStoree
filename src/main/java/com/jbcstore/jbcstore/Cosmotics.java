package com.jbcstore.jbcstore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cosmotics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String brand;
    private String Price;
    private String popularity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
}

