package com.techelevator.reports;

import com.techelevator.product.Product;
import com.techelevator.vendingmachine.VendingMachineProducts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VMLog extends VendingMachineProducts {

    public static void logGiveMoney(double moneyAmount, BigDecimal balance) {
        try (FileOutputStream stream = new FileOutputStream("logs/log.txt", true);
             PrintWriter writer = new PrintWriter(stream)) {
            //date, time, feed money, amount given, total balance
            LocalDateTime current = LocalDateTime.now();
            String date = current.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            String time = current.format(DateTimeFormatter.ISO_LOCAL_TIME);
            String timeNoMill = time.substring(0, time.length()-8);

            writer.println(date + " " + timeNoMill + " FEED MONEY $" + BigDecimal.valueOf(moneyAmount) + " $" + balance);
        } catch (IOException e) {
            throw new VMLogException(e.getMessage());
        }
    }

    public static void logPurchase(String location, BigDecimal balance) {
        try (FileOutputStream stream = new FileOutputStream("logs/log.txt", true);
             PrintWriter writer = new PrintWriter(stream)) {
            //date, time, feed money, amount given, total balance
            LocalDateTime current = LocalDateTime.now();
            String date = current.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            String time = current.format(DateTimeFormatter.ISO_LOCAL_TIME);
            String timeNoMill = time.substring(0, time.length()-8);
            String item = "";
            BigDecimal price = new BigDecimal("0");

            for (Product product : products) {
                if (product.getLocation().contains(location.toUpperCase())) {
                    item = product.getName();
                    price = product.getPrice();
                }
            }

            writer.println(date + " " + timeNoMill + " " + item + " " + location.toUpperCase() + " $" + price + " $" + balance);
        } catch (IOException e) {
            throw new VMLogException(e.getMessage());
        }
    }

    public static void logReturnMoney(BigDecimal beforeBalance, BigDecimal balance) {
        try (FileOutputStream stream = new FileOutputStream("logs/log.txt", true);
             PrintWriter writer = new PrintWriter(stream)) {
            //date, time, feed money, amount given, total balance
            LocalDateTime current = LocalDateTime.now();
            String date = current.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            String time = current.format(DateTimeFormatter.ISO_LOCAL_TIME);
            String timeNoMill = time.substring(0, time.length()-8);

            writer.println(date + " " + timeNoMill + " GIVE CHANGE $" + beforeBalance + " $" + balance);
        } catch (IOException e) {
            throw new VMLogException(e.getMessage());
        }
    }
}
