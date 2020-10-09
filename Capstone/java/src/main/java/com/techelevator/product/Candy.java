package com.techelevator.product;

import java.math.BigDecimal;

public class Candy extends Product{

    public Candy(String location, String name, BigDecimal price) {
        super(location, name, price, "Munch Munch, Yum!", "Candy");
    }
}
