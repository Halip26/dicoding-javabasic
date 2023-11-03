package com.dicoding.andrewTask.onlineShop;

import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private String address;
    private double balance;
    private List<CartItem> cart = new ArrayList<>();
    private List<List<CartItem>> purchaseHistory = new ArrayList<>();

    public User(String username, String address, double balance) {
        this.username = username;
        this.address = address;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public List<List<CartItem> > getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setBalance(double d) {
      balance = d;
    }
}
