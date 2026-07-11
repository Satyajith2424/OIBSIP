package com.oasis.atm;

public class Transaction {

    private String description;

    public Transaction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}