package com.atm.simulation;

public class Account {

    private String accountHolderName;
    private int pin;
    private double balance;
    private int pinAttempts;

    public Account(String accountHolderName, int pin, double balance) {
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = balance;
        this.pinAttempts = 0;
    }

    public boolean validatePin(int enteredPin) {
        if (pinAttempts >= 3) {
            System.out.println("Your account is blocked due to 3 incorrect attempts.");
            return false;
        }

        if (this.pin == enteredPin) {
            pinAttempts = 0;
            return true;
        } else {
            pinAttempts++;
            System.out.println("Incorrect PIN. Attempts left: " + (3 - pinAttempts));
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash: ₹" + amount);
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
