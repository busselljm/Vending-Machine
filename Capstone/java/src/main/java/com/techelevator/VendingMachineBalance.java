package com.techelevator;

import java.math.BigDecimal;

public class VendingMachineBalance {
    private static final BigDecimal STARTING_BALANCE = new BigDecimal("0");
    private BigDecimal balance = new BigDecimal("0");
    private BigDecimal inputAmount;

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

        while (getBalance().doubleValue() > 0) {
            if (getBalance().doubleValue() >= quarterValue.doubleValue()) {
                quarters++;
                this.balance = getBalance().subtract(quarterValue);
            } else if (getBalance().doubleValue() >= dimeValue.doubleValue()) {
                dimes++;
                this.balance = getBalance().subtract(dimeValue);
            } else if (getBalance().doubleValue() >= nickelValue.doubleValue()) {
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



    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(BigDecimal inputAmount) {
        this.inputAmount = inputAmount;
    }

    //feed whole dollars


    //return change

}
