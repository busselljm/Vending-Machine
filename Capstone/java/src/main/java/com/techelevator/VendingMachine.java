package com.techelevator;

import java.io.IOException;

public class VendingMachine extends VendingMachineBalance {

    VendingMachineBalance vmBalance = new VendingMachineBalance();

    public VendingMachine() {
        try {
            createProductList();
        } catch (IOException e) {
            System.out.println("Couldn't find inventory file.");
        }
    }

}

