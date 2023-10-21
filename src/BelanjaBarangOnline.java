import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

public class BelanjaBarangOnline {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();

    public String addUser(String username, String address, double balance) {
        if (users.containsKey(username)) {
            return "Nama pengguna sudah ada";
        }
        User user = new User(username, address, balance);
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
            catalog.append(item.getName()).append(" - Harga: $").append(item.getPrice())
                    .append(" - Stok: ").append(item.getStock()).append("\n");
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
            return "Stok barang tidak mencukupi";
        }
        user.getCart().add(new CartItem(item, quantity));
        return quantity + " " + itemName + " berhasil ditambahkan ke keranjang belanja";
    }

    public String removeFromCart(String username, String itemName, int quantity) {
        User user = users.get(username);
        Item item = items.get(itemName);
        if (user == null || item == null) {
            return "Pengguna atau barang tidak ditemukan";
        }
        for (CartItem cartItem : user.getCart()) {
            if (cartItem.getItem() == item) {
                if (cartItem.getQuantity() < quantity) {
                    return "Jumlah barang dalam keranjang tidak mencukupi";
                }
                user.getCart().remove(cartItem);
                return quantity + " " + itemName + " berhasil dihapus dari keranjang belanja";
            }
        }
        return itemName + " tidak ditemukan dalam keranjang belanja";
    }

    public String calculateTotal(String username) {
        User user = users.get(username);
        if (user == null) {
            return "Pengguna tidak ditemukan";
        }
        double total = 0;
        for (CartItem cartItem : user.getCart()) {
            total += cartItem.getItem().getPrice() * cartItem.getQuantity();
        }
        return "Total belanja: $" + total;
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
        StringBuilder history = new StringBuilder("Riwayat Belanja:\n");
        for (List<CartItem> cart : user.getPurchaseHistory()) {
            for (CartItem cartItem : cart) {
                history.append(cartItem.getItem().getName()).append(" - Harga: $")
                        .append(cartItem.getItem().getPrice()).append(" - Jumlah: ")
                        .append(cartItem.getQuantity()).append("\n");
            }
        }
        return history.toString();
    }

    public String logout(String username) {
        User user = users.get(username);
        if (user == null) {
            return "Pengguna tidak ditemukan";
        }
        return username + " berhasil keluar dari akun";
    }

    public static void main(String[] args) {
        BelanjaBarangOnline onlineShop = new BelanjaBarangOnline();
        System.out.println(onlineShop.addUser("user1", "Jl. Contoh 123", 1000));
        System.out.println(onlineShop.addItem("Barang A", 10, 50, "Deskripsi Barang A"));
        System.out.println(onlineShop.addItem("Barang B", 20, 30, "Deskripsi Barang B"));

        System.out.println(onlineShop.addToCart("user1", "Barang A", 5));
        System.out.println(onlineShop.addToCart("user1", "Barang B", 3));
        System.out.println(onlineShop.calculateTotal("user1"));
        System.out.println(onlineShop.makePayment("user1"));
        System.out.println(onlineShop.viewPurchaseHistory("user1"));
        System.out.println(onlineShop.logout("user1"));
    }
}
