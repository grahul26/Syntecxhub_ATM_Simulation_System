package com.atm.simulation;

public class Main {

    public static void main(String[] args) {

        Account userAccount = new Account("Rahul", 1234, 10000.0);

        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();
    }
}
