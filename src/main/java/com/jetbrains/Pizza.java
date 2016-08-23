package com.jetbrains;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.DoubleRangeValidator;
import com.vaadin.ui.Notification;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Currency;

/**
 * Created by lpierau on 23.08.16.
 */
public class Pizza {

    private Double price;
    private String name;



    public Pizza(String name, Double price){
        this.price = price;
        this.name  = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) throws Validator.InvalidValueException {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
