package com.techelevator;

import java.math.BigDecimal;

public class Product {
    public String sound;
    private String location;
    private String name;
    private BigDecimal price;
    private int inventoryLeft;
    private static final int STARTING_INVENTORY = 5;


    public Product(String location, String name, BigDecimal price, String sound) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.inventoryLeft = STARTING_INVENTORY;
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


    public void setSound(String sound) {
        this.sound = sound;
    }
}
