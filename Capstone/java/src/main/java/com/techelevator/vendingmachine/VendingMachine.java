package com.techelevator.vendingmachine;

import java.io.IOException;

public class VendingMachine extends VendingMachineBalance {

    public VendingMachine() {
        try {
            createProductList();
        } catch (IOException e) {
            System.out.println("Couldn't find inventory file.");
        }
    }

}

