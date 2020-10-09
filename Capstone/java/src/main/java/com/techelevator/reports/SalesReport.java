package com.techelevator.reports;

import com.techelevator.product.Product;
import com.techelevator.vendingmachine.VendingMachineProducts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;


public class SalesReport extends VendingMachineProducts {

    public static void salesReport() {
        try (FileOutputStream stream = new FileOutputStream("logs/sales_report.txt", false);
             PrintWriter writer = new PrintWriter(stream)) {
            BigDecimal totalSales = new BigDecimal("0");

            for (Product product : products) {
                int itemsSold = 5 - product.getInventoryLeft();
                writer.println(product.getName() + "|" + itemsSold);
                totalSales = totalSales.add(BigDecimal.valueOf(itemsSold).multiply(product.getPrice()));
            }


            writer.println("**TOTAL SALES** $" + totalSales);
        } catch (IOException e) {
            throw new VMLogException(e.getMessage());
        }
    }
}
