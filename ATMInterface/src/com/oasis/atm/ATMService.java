package com.oasis.atm;

import java.util.ArrayList;

public class ATMService {

    private User user;
    private Account account;
    private ArrayList<Transaction> transactions;

    public ATMService() {
        user = new User("USER001", "1234", "Satyajith");
        account = new Account(10000);
        transactions = new ArrayList<>();
    }

    public boolean login(String userId, String pin) {
        if (user.getUserId().equals(userId)
                && user.getPin().equals(pin)) {
            return true;
        }
        return false;
    }
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        account.deposit(amount);

        transactions.add(
                new Transaction("Deposited ₹" + amount));

        System.out.println("₹" + amount +
                " deposited successfully.");

        System.out.println("Current Balance : ₹" +
                account.getBalance());
    }
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        boolean success = account.withdraw(amount);

        if (success) {
            transactions.add(
                    new Transaction("Withdrawn ₹" + amount));

            System.out.println("₹" + amount +
                    " withdrawn successfully.");

            System.out.println("Current Balance : ₹" +
                    account.getBalance());
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
    public void showTransactionHistory() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("===== Transaction History =====");

        for (Transaction t : transactions) {
            System.out.println(t.getDescription());
        }
    }
    public double getBalance() {
        return account.getBalance();
    }
    public void transfer(String receiverId,
            double amount) {

		if (amount <= 0) {
		System.out.println("Invalid amount!");
		return;
		}
		
		boolean success = account.withdraw(amount);
		
		if (success) {
		transactions.add(
		       new Transaction(
		               "Transferred ₹" +
		               amount +
		               " to " +
		               receiverId));
		
		System.out.println("₹" +
		       amount +
		       " transferred successfully to " +
		       receiverId);
		
		System.out.println("Current Balance : ₹" +
		       account.getBalance());
		} else {
		System.out.println("Insufficient Balance!");
		}
}
}