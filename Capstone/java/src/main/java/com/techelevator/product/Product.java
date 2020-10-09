package com.techelevator.product;

import java.math.BigDecimal;

public class Product {
    private String sound;
    private String location;
    private String name;
    private BigDecimal price;
    private int inventoryLeft;
    private static final int STARTING_INVENTORY = 5;
    private String type;


    public Product(String location, String name, BigDecimal price, String sound, String type) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.inventoryLeft = STARTING_INVENTORY;
        this.sound = sound;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
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

    public void setInventoryLeft(int inventoryLeft) {
        this.inventoryLeft = inventoryLeft;
    }

    public String getSound() {
        return sound;
    }

}
