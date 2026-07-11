package com.oasis.atm;

public class User {

    private String userId;
    private String pin;
    private String name;

    public User(String userId, String pin, String name) {
        this.userId = userId;
        this.pin = pin;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }
}