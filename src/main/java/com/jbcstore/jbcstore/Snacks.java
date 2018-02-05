package com.jbcstore.jbcstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Snacks {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String Crunchiness;
    private String price;


    public String getCrunchiness() {
        return Crunchiness;
    }

    public void setCrunchiness(String crunchiness) {
        Crunchiness = crunchiness;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
