package com.oasis.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATMService atm = new ATMService();

        System.out.println("===== ATM INTERFACE =====");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (!atm.login(userId, pin)) {
            System.out.println("Invalid User ID or PIN!");
            sc.close();
            return;
        }

        System.out.println("Login Successful!");

        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                atm.showTransactionHistory();
                break;

            case 2:
                System.out.print("Enter amount: ");
                double withdrawAmount = sc.nextDouble();
                atm.withdraw(withdrawAmount);
                break;

            case 3:
                System.out.print("Enter amount: ");
                double depositAmount = sc.nextDouble();
                atm.deposit(depositAmount);
                break;
            case 4:
                System.out.print("Enter Receiver User ID: ");
                sc.nextLine(); // clears buffer
                String receiverId = sc.nextLine();

                System.out.print("Enter amount: ");
                double transferAmount = sc.nextDouble();

                atm.transfer(receiverId, transferAmount);
                break;
            case 5:
                System.out.println("Thank you for using ATM!");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}