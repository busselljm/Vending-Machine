package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineProducts {
    private String type;

    public List<Product> products = new ArrayList<>();

    public void createProductList() throws IOException {
        Path fileName = Paths.get("inventory.txt");
        try (Scanner inventoryList = new Scanner(fileName)) {
            while (inventoryList.hasNextLine()) {
                String[] lineSeparated = inventoryList.nextLine().split("\\|");
                String location = lineSeparated[0];
                String name = lineSeparated[1];
                BigDecimal price = new BigDecimal(lineSeparated[2]);
                String type = lineSeparated[3];
                Product newProductToAdd = null;
                if (type.equals("Drink")) {
                    newProductToAdd = new Drink(location, name, price);
                } else if (type.equals("Chip")) {
                    newProductToAdd = new Chip(location, name, price);
                }
                products.add(newProductToAdd);
            }
        } catch (IOException e) {
            System.out.println("Couldn't read inventory file.");
        }
    }

    public String displayProducts() {
        String result = "";
        for (Product product : products) {
            if (!product.isAvailable()) {
                product.setName("SOLD OUT");
            }
            result += product.getLocation() + " | " + product.getName() + " | " + product.getPrice() + "\n";
        }
        return result;
    }

//    public String sound(String input) {
//        String result = "";
//        for (Product product : products) {
//            if (product.getType().contains(input)) {
//                product.setSound("Munch Munch, Yum!");
//                result = product.getSound();
//            } else if (product.getType().contains(input)) {
//                product.setSound("Crunch Crunch, Yum!");
//                result = product.getSound();
//            } else if (product.getType().contains(input)) {
//                product.setSound("Glug Glug, Yum!");
//                result = product.getSound();
//            } else if (product.getType().contains(input)) {
//                product.setSound("Chew Chew, Yum!");
//                result = product.getSound();
//            }
//        }
//        return result;
//    }
}

