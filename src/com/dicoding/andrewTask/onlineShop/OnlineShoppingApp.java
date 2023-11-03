package com.dicoding.andrewTask.onlineShop;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

  public String viewCatalog() {
    StringBuilder catalog = new StringBuilder("Katalog Barang:\n");
    for (Item item : items.values()) {
      catalog.append(item.getName()).append(" - Harga: Rp.").append(item.getPrice()).append(" - Stock: ").append(item.getStock()).append("\n");
    } 
    return catalog.toString();
  }

  public String addToCart(String username, String itemName, int quantity) {
    User user = users.get(username);
    Item item = items.get(itemName);

    if (user == null || item == null) {
      return "Pengguna atau barang tidak ditemukan";
    }
    if (item.getStock() < quantity) {
      return "Stock barang tidak mencukupi";
    }
    user.getCart().add(new CartItem(item, quantity));
    item.stock -= quantity;
    return quantity + " " + itemName + " berhasil ditambahkan ke keranjang belanja";
  }

  public String removeFromCart (String username, String itemName, int quantity) {
    User user = users.get(username);
    Item item = items.get(itemName);

    if (user == null || item == null){
      return "Pengguna atau barang tidak ditemukan";
    }

    for (CartItem cartItem : user.getCart()) {
      if (cartItem.getQuantity() < quantity) {
        return "Jumlah barang dalam keranjang tidak mencukupi";
      }
      user.getCart().remove(cartItem);
      item.stock += quantity;
      return quantity + " " + itemName + " berhasil dihapus dari keranjang belanja";
    }

    return itemName + " tidak ditemukan dalam kearanjang belanja";
  }

  public String calculateTotal (String username) {
    User user = users.get(username);
    if (user == null) {
      return "Pengguna tidak ditemukan";
    }
    double total = 0;
    for (CartItem cartItem : user.getCart()) {
      total += cartItem.getItem().getPrice() * cartItem.getQuantity();
    }
    return "Total belanja: Rp." + total;
  }

  public String makePayment(String username) {
    User user = users.get(username);
    if (user == null) {
      return "Pengguna tidak ditemukan";
    }

    double total = 0;
    for (CartItem cartItem : user.getCart()) {
      total += cartItem.getItem().getPrice() * cartItem.getQuantity();
    }
    if (user.getBalance() < total ) {
      return "Saldo tidak mencukupi";
    }
    user.getCart().clear();
    user.getPurchaseHistory().add(new ArrayList<>(user.getCart()));
    user.setBalance(user.getBalance() - total);
    return "Pembayaran berhasil";
  }

  public String viewPurchaseHistory(String username) {
    User user = users.get(username);
    if (user == null) {
      return "Pengguna tidak ditemukan";
    }
    
    List<List<CartItem>> history = user.getPurchaseHistory();

    if (history.isEmpty()) {
      return "Riwayat belanja kosong";
    }

    StringBuilder historyString = new StringBuilder("Riwayat Belanja:\n");
    for (List<CartItem> cart : history) {
      for (CartItem cartItem : cart) {
        historyString.append(cartItem.getItem().getName()).append(" - Harga: Rp.").append(cartItem.getItem().getPrice()).append(" - Jumlah: ").append(cartItem.getQuantity()).append("\n");
      }
    }
    return historyString.toString();
  }

  public String logout (String username) {
    User user = users.get(username);
    if (user == null) {
      return "Pengguna tidak ditemukan";
    }
    return username + " berhasil keluar dari akun anda";
  }

  // untuk input nilai dll
  public static void main(String[] args) {
    OnlineShoppingApp onlineShop = new OnlineShoppingApp();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Selamat datang di online Shopping App!");

    while (true) {
      System.out.println("\nSilahkan pilih tindakan yg ingin Anda lakukan:");
      System.out.println("1. Buat akun");
      System.out.println("2. Lihat katalog barang");
      System.out.println("3. Tambahkan barang ke keranjang");
      System.out.println("4. Hapus barang dari keranjang");
      System.out.println("5. Hitung total belanja");
      System.out.println("6. Lakukan pembayaran");
      System.out.println("7. Lihat riwayat belanja");
      System.out.println("8. Keluar");
      System.out.println("---------------------------------------");

      int choice = scanner.nextInt();
      // membuang newline
      scanner.nextLine();

      switch (choice) {
        case 1 : 
          System.out.print("Masukkan nama pengguna: ");
          String username = scanner.nextLine();
          System.out.print("Masukkan alamat anda: ");
          String address = scanner.nextLine();
          System.out.print("Masukkan saldo akun anda: ");
          double balance = scanner.nextDouble();
          scanner.nextLine();
          System.out.println(onlineShop.addUser(username, address, balance));
          break;

        case 2 : 
          System.out.println(onlineShop.viewCatalog());
          break;

        case 3:
          System.out.print("Masukkan nama pengguna: ");
          username = scanner.nextLine();
          System.out.print("Masukkan nama barang yang ingin ditambahkan ke keranjang: ");
          String itemName = scanner.nextLine();
          System.out.print("Masukkan jumlah barang: ");
          int quantity = scanner.nextInt();
          scanner.nextLine(); // Membuang newline
          System.out.println(onlineShop.addToCart(username, itemName, quantity));
          break;
        case 4:
          System.out.print("Masukkan nama pengguna: ");
          username = scanner.nextLine();
          System.out.print("Masukkan nama barang yang ingin dihapus dari keranjang: ");
          itemName = scanner.nextLine();
          System.out.print("Masukkan jumlah barang yang ingin dihapus: ");
          quantity = scanner.nextInt();
          scanner.nextLine(); // Membuang newline
          System.out.println(onlineShop.removeFromCart(username, itemName, quantity));
          break;
        case 5:
          System.out.print("Masukkan nama pengguna: ");
          username = scanner.nextLine();
          System.out.println(onlineShop.calculateTotal(username));
          break;
        case 6:
          System.out.print("Masukkan nama pengguna: ");
          username = scanner.nextLine();
          System.out.println(onlineShop.makePayment(username));
          break;
        case 7:
          System.out.print("Masukkan nama pengguna: ");
          username = scanner.nextLine();
          System.out.println(onlineShop.viewPurchaseHistory(username));
          break;
        case 8:
          System.out.println("Terima kasih telah menggunakan Online Shopping App!");
          scanner.close();
          System.exit(0);
        default:
          System.out.println("Pilihan tidak valid. Silakan coba lagi.");
      }
    }
  } 
}
