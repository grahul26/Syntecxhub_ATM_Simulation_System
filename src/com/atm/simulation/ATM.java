package com.atm.simulation;

import java.util.Scanner;

public class ATM {

    private Account account;
    private boolean sessionActive;

    public ATM(Account account) {
        this.account = account;
        this.sessionActive = false;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("        Welcome to ATM          ");
        System.out.println("================================");

        while (!sessionActive) {
            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();

            if (account.validatePin(enteredPin)) {
                sessionActive = true;
                System.out.println("Login successful. Welcome " + account.getAccountHolderName());
                showMenu(sc);
            }
        }

        sc.close();
    }

    private void showMenu(Scanner sc) {

        while (sessionActive) {

            System.out.println("\n------ ATM MENU ------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    sessionActive = false;
                    System.out.println("Session ended. Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
