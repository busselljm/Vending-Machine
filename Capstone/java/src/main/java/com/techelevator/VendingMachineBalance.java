package com.techelevator;

import java.math.BigDecimal;

public class VendingMachineBalance {
    private static final BigDecimal STARTING_BALANCE = new BigDecimal("0");
    private BigDecimal balance;
    private BigDecimal inputAmount;
    private BigDecimal outputAmount;

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
//            if (getBalance().doubleValue() >= quarterValue.doubleValue()) {
//                quarters = getBalance().divide(quarterValue).intValue();
//                this.balance = getBalance().subtract(quarterValue.multiply(BigDecimal.valueOf(quarters)));
//            } else if (getBalance().doubleValue() >= .10) {
//                dimes = getBalance().divide(dimeValue).intValue();
//                this.balance = getBalance().subtract(dimeValue.multiply(BigDecimal.valueOf(dimes)));
//            } else if (getBalance().doubleValue() >= .05) {
//                nickels = getBalance().divide(nickelValue).intValue();
//                this.balance = getBalance().subtract(nickelValue.multiply(BigDecimal.valueOf(nickels)));
//            }
        }
        return "Giving back " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels";
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

    public BigDecimal getOutputAmount() {
        return outputAmount;
    }

    public void setOutputAmount(BigDecimal outputAmount) {
        this.outputAmount = outputAmount;
    }

    //feed whole dollars


    //return change

}
