package com.dicoding.andrewTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta pengguna untuk memasukkan nomor akun
        System.out.print("Masukkan nomor akun: ");
        String accountNumber = scanner.nextLine();

        // Meminta pengguna untuk memasukkan saldo awal
        System.out.print("Masukkan saldo awal: ");
        double initialBalance = getNextDouble(scanner);

        // Meminta pengguna untuk memasukkan mata uang
        System.out.print("Masukkan mata uang: ");
        String currency = scanner.nextLine();

        // Membuat objek BankAccount dengan nilai yang diinput oleh pengguna
        BankAccount bankAccount = new BankAccount(accountNumber, initialBalance, currency);

        // Menampilkan informasi tentang objek bankAccount
        System.out.println("Nomor akun: " + bankAccount.getAccountNumber());
        System.out.println("Saldo: " + bankAccount.getBalance() + " " + bankAccount.getCurrency());
        System.out.println("Tanggal pembukaan kartu: " + bankAccount.getCardOpeningDate());
        System.out.println("Mata uang: " + bankAccount.getCurrency());

        // Meminta pengguna untuk memasukkan jumlah uang yang ingin disimpan
        System.out.print("Masukkan jumlah uang yang ingin disimpan: ");
        double amountToSave = getNextDouble(scanner);
        
        // Memanggil metode save untuk menyimpan sejumlah uang ke dalam akun
        bankAccount.save(amountToSave);

        // Meminta pengguna untuk memasukkan jumlah uang yang ingin ditarik
        System.out.print("Masukkan jumlah uang yang ingin ditarik: ");
        double amountToWithdraw = getNextDouble(scanner);

        // Memanggil metode withdraw untuk menarik sejumlah uang dari akun
        bankAccount.withdraw(amountToWithdraw);

        // Menutup scanner setelah selesai digunakan
        scanner.close();
    }

    private static double getNextDouble(Scanner scanner) {
      while (!scanner.hasNextDouble()) {
          System.out.println("Input tidak valid. Masukkan angka.");
          scanner.nextLine(); // Clear invalid input
      }
      
      return Double.parseDouble(scanner.nextLine());
    }
  
}
