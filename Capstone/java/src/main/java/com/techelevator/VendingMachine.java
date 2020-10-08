package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private static List<Product> products = new ArrayList<>();

    public static void createProductList() {
        try (Scanner inventoryList = new Scanner("inventory.txt")) {
            while (inventoryList.hasNextLine()) {
                String[] lineSeparated = inventoryList.nextLine().split("\\|");
                products.add(new Product(lineSeparated[0], lineSeparated[1],
                        BigDecimal.valueOf(Double.parseDouble(lineSeparated[2])), lineSeparated[3]));
            }
        }
    }


    //check for sold out items

    //feed money

    //put account balance

    //return change

}
