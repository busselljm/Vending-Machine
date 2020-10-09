package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product {

    public Drink(String location, String name, BigDecimal price) {
        super(location, name, price, "Glug Glug, Yum!");
    }
}
