package com.techelevator.vendingmachine;

import com.techelevator.product.Product;

import java.math.BigDecimal;

public class VendingMachineBalance extends VendingMachineProducts{
    private BigDecimal balance = new BigDecimal("0");

    public BigDecimal getBalance() {
        return balance;
    }

    public String returnMoney() {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        BigDecimal quarterValue = new BigDecimal("0.25");
        BigDecimal dimeValue = new BigDecimal("0.10");
        BigDecimal nickelValue = new BigDecimal("0.05");

        while (getBalance().compareTo(BigDecimal.ZERO) > 0) {
            if (getBalance().compareTo(quarterValue) >= 0) {
                quarters++;
                this.balance = getBalance().subtract(quarterValue);
            } else if (getBalance().compareTo(dimeValue) >= 0) {
                dimes++;
                this.balance = getBalance().subtract(dimeValue);
            } else if (getBalance().compareTo(nickelValue) >= 0) {
                nickels++;
                this.balance = getBalance().subtract(nickelValue);
            }
        }
        return "Giving back " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels";
    }

    public String addMoney(BigDecimal amountToDeposit) {
        this.balance = balance.add(BigDecimal.valueOf(amountToDeposit.intValue()));
        return "Current balance is $" + getBalance();
    }

    public String subtractMoney(BigDecimal productCost) {
        balance = getBalance().subtract(productCost);
        return "Current balance is $" + getBalance();
    }

    public String chooseProducts(String input) {
        String result = "";
        for (Product product : products) {
            if (product.getLocation().contains(input)) {
                if (getBalance().compareTo(product.getPrice()) >= 0) {
                    if (product.isAvailable()) {
                        result = subtractMoney(product.getPrice()) + "\n" + product.getSound();
                        product.setInventoryLeft(product.getInventoryLeft() - 1);
                    } else {
                        result = "Product out of stock, please make another selection.";
                    }
                } else {
                    result = "Not enough money, please add more or make another selection.";
                }
            }
        }
        return result;
    }
}
