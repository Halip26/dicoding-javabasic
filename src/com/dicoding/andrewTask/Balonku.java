package com.dicoding.andrewTask;
// import java.util.Scanner;

public class Balonku {
  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    // System.out.print("Masukkan kalimat dari Si Balonku: ");
    String siBalonku = "Balonku ada seribu";

    // mengambil tiga karakter pertama
    String tigaKarakterUtama =  siBalonku.substring(0, 3);
    
    // mengubah semua huruf menjadi huruf kapital
    String hurufKapital = siBalonku.toUpperCase();

    // mengganti setiap huruf "a" menjadi "o" 
    String gantiHuruf = siBalonku.replace("a", "o");

    // memeriksa apakah siBalonku mengandung kata "ada"
    boolean apakahAda = siBalonku.toLowerCase().contains("ada");

    // menambahkan kata "lima ratus" setelah siBalonku ucapkan
    String hasilAkhir = siBalonku + " lima ratus";

    // menampilkan hasilnya 
    System.out.println("Semua huruf kapital: " + hurufKapital);
    System.out.println("Tiga karakter utama: " + tigaKarakterUtama);
    System.out.println("Hasil Ganti huruf: " + gantiHuruf);
    System.out.println("Hasil akhir: " + hasilAkhir);
    System.out.println("Apakah mengandung kata 'ada': " + apakahAda);

    // menutup scanner
    // scanner.close();
  }
}
