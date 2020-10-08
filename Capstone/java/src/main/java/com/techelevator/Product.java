package com.techelevator;

import java.math.BigDecimal;

public class Product {
    private String location;
    private String name;
    private BigDecimal price;
    private String type;
    private int inventoryLeft;
    private static final int STARTING_INVENTORY = 5;


    public Product(String location, String name, BigDecimal price, String type) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.type = type;
        this.inventoryLeft = STARTING_INVENTORY;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getInventoryLeft() {
        return inventoryLeft;
    }

    public boolean isAvailable() {
        boolean available = false;
        if (this.inventoryLeft >= 1) {
            available = true;
        }
        return available;
    }

    public void purchaseItem() {
        inventoryLeft = inventoryLeft - 1;
    }




}
