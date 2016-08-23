package com.jetbrains;

import com.vaadin.data.validator.DoubleRangeValidator;

import java.util.Currency;

/**
 * Created by lpierau on 23.08.16.
 */
public class Pizza {

    private DoubleRangeValidator validator = new DoubleRangeValidator("Preis stimmt nicht",0.0,99999.99999);
    private Double price;
    private String name;

    public Pizza(String name, Double price){
        this.price = price;
        this.name  = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
