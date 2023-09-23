package com.dicoding.andrewTask;

import java.util.Date;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private Date cardOpeningDate;
    private String currency;

    // Konstruktor untuk inisialisasi objek BankAccount dengan nomor akun, saldo awal, tanggal pembukaan kartu, dan mata uang
    public BankAccount(String accountNumber, double balance, String currency) {
      this.accountNumber = accountNumber;
      this.balance = balance;
      // Menggunakan tanggal hari ini
      this.cardOpeningDate = new Date(); 
      this.currency = currency;
  }

    // Getter untuk mendapatkan nomor akun
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter untuk mengubah nomor akun
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter untuk mendapatkan saldo
    public double getBalance() {
        return balance;
    }

    // Setter untuk mengubah saldo
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter untuk mendapatkan tanggal pembukaan kartu
    public Date getCardOpeningDate() {
        return cardOpeningDate;
    }

    // Setter untuk mengubah tanggal pembukaan kartu
    public void setCardOpeningDate(Date cardOpeningDate) {
        this.cardOpeningDate = cardOpeningDate;
    }

    // Getter untuk mendapatkan mata uang
    public String getCurrency() {
        return currency;
    }

  // Setter untuk mengubah mata uang
  public void setCurrency(String currency) {
    if (currency.equals("ID") || currency.equals("US")) {
        this.currency = currency;
    } else {
        System.out.println("Warning: the currency available only on ID & US!");
    }
  }

    // Metode save untuk menyimpan sejumlah uang ke dalam akun
    public void save(double amount) {
        balance += amount;
        System.out.println("Penyimpanan sebesar " + amount + " " + currency + " berhasil. Saldo Anda saat ini: " + balance + " " + currency);
    }

    // Metode withdraw untuk menarik sejumlah uang dari akun
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Maaf, saldo Anda tidak mencukupi.");
        } else {
            balance -= amount;
            System.out.println("Penarikan sebesar " + amount + " " + currency + " berhasil. Sisa saldo Anda: " + balance + " " + currency);
        }
    }
}

