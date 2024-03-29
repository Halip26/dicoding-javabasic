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
    int nomor = 1; // inisialisasi variable nomor
    
    // looping for untuk menampilkan nomor barang
    for (Item item : items.values()) {
      catalog.append(nomor).append(". ")
            .append(item.getName())
            .append(" - Harga: Rp.")
            .append(item.getPrice())
            .append(" - Stock: ")
            .append(item.getStock())
            .append("\n");
      nomor++; // penghitung kenaikan setelah setiap iterasi
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
    if (user.getBalance() < total) {
      return "Saldo tidak mencukupi";
    }
    user.getPurchaseHistory().add(new ArrayList<>(user.getCart()));
    // kosongkan keranjang setelah menambahkannya ke riwayat pembelian
    user.getCart().clear(); 
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
    int nomor = 1; // inisialisasi variabel nomor
    // looping untuk memberi nomor urutan pesanan
    for (List<CartItem> cart : history) {
        historyString.append("Pesanan ").append(nomor).append(":\n");
        for (CartItem cartItem : cart) {
            historyString.append(cartItem.getItem().getName())
                .append(" - Harga: Rp.").append(cartItem.getItem().getPrice())
                .append(" - Jumlah: ").append(cartItem.getQuantity())
                .append("\n");
        }
        nomor++; // angka kenaikan setelah setiap iterasi
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

    // Tambabkan barang-barang elektronik ke katalog
    onlineShop.addItem("Laptop", 1000.0, 10, "Laptop gaming kondisi bagus");
    onlineShop.addItem("Smartphone", 500.0, 20, "Ponsel terbaru 2023");
    onlineShop.addItem("TV", 800.0, 15, "TV LED 4K");
    onlineShop.addItem("SSD Drive", 120.0, 25, "Storage besar 2TB");
    onlineShop.addItem("Headphone", 50.0, 30, "Headphone berkualitas tinggi");
    onlineShop.addItem("Kamera DSLR", 1500.0, 8, "Kamera DSLR profesional");
    onlineShop.addItem("Smartwatch", 300.0, 12, "Smartwatch pintar dengan berbagai fitur");
    onlineShop.addItem("Speaker Bluetooth", 80.0, 18, "Speaker Bluetooth portabel");
    onlineShop.addItem("Drone", 700.0, 6, "Drone dengan kamera 4K");
    onlineShop.addItem("Monitor Komputer", 250.0, 14, "Monitor resolusi tinggi");
    onlineShop.addItem("Mouse Gaming", 40.0, 22, "Mouse gaming dengan sensor akurat");
    onlineShop.addItem("Printer Inkjet", 150.0, 11, "Printer inkjet berkualitas tinggi");
    onlineShop.addItem("Router WiFi", 60.0, 17, "Router WiFi cepat");

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

