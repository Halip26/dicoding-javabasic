package com.dicoding.andrewTask;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

class Item {
  private String name;
  private double price;
  private int stock;
  private String description;

  public Item(String name, double price, int stock, String description) {
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.description = description;
  }

  public String getName() {
    return name;
  }
  public double getPrice() {
    return price;
  }
  public int getStock() {
    return stock;
  }
  public String getDescription() {
    return description;
  }
}

class CartItem {
  private Item item;
  private int quantity;

  public CartItem(Item item, int quantity) {
    this.item = item;
    this.quantity = quantity;
  }

  public Item getItem() {
    return item;
  }

  public int getQuantity() {
    return quantity;
  }

}

// Class utama atau program utamanya
public class OnlineShoppingApp {
  private Map<String, User> users = new HashMap<>();
  private Map<String, Item> items = new HashMap<>();

  public String addUser (String username, String address, double balance) {
    if (users.containsKey(username)) {
      return "Nama pengguna sudah ada";
    }
    User user= new User(username, address, balance);
    users.put(username, user);
    return "Akun berhasil dibuat";
  }

  public String addItem(String name, double price, int stock, String description) {
    if (items.containsKey(name)) {
        return "Barang sudah ada dalam katalog";
    }
    Item item = new Item(name, price, stock, description);
    items.put(name, item);
    return "Barang berhasil ditambahkan ke katalog";
  }
}
