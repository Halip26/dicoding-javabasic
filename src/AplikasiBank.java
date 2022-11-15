import java.util.Scanner;  
class BankDetails {  
    private String noakun;  
    private String nama;  
    private String tipe_akun;  
    private long saldo; 
    private String pemisah;

    Scanner sc = new Scanner(System.in);
    //metode untuk akun baru 
    public void openAccount() {  
        System.out.println("--------------------------- ");
        System.out.print("Masukkan nomor akun: ");  
        noakun = sc.next();
        System.out.print("Masukkan tipe akun: ");  
        tipe_akun = sc.next();  
        System.out.print("Masukkan nama Anda: ");  
        nama = sc.next();  
        System.out.print("Masukkan saldo Anda: ");  
        saldo = sc.nextLong();
        System.out.print("--------------------------- " + "\r\n");  
        pemisah = sc.nextLine(); 
    }  
    //metode untuk menampilkan detail akun 
    public void showAccount() {  
        System.out.println("--------------------------- ");
        System.out.println("Nama pemilik akun: " + nama);  
        System.out.println("Nomor akun: " + noakun);  
        System.out.println("Tipe akun: " + tipe_akun);  
        System.out.println("Saldo: " + saldo);
        System.out.println("--------------------------- " + "\r\n" + pemisah);  
    }  
    //metode untuk menyetor uang 
    public void deposit() {  
        long amt;  
        System.out.println("Masukkan jumlah yang ingin Anda setor: ");
        amt = sc.nextLong();  
        saldo = saldo + amt;  
    }  
    //metode untuk penarikan uang 
    public void withdrawal() {  
        long amt;  
        System.out.println("Masukkan jumlah yang ingin Anda tarik: "); 
        amt = sc.nextLong();  
        if (saldo >= amt) {  
            saldo = saldo - amt;
            System.out.println("Saldo setelah penarikanl: " + saldo);  
        } else { 
            System.out.println("Saldo Anda kurang dari " + amt + "\r\n" + "** Transaksi gagal...!! **" );  
        }  
    }  
    //metode untuk mncari nomor akun 
    public boolean search(String ac_no) {  
        if (noakun.equals(ac_no)) {  
            showAccount();  
            return (true);  
        }  
        return (false);  
    }  
}  
public class AplikasiBank {  
    public static void main(String arg[]) {  
        try (Scanner sc = new Scanner(System.in)) {
          //membuat akun baru/awal 
          System.out.print("Berapa jumlah customers yang ingin Anda input? "); 
          int n = sc.nextInt();  
          BankDetails C[] = new BankDetails[n];  
          for (int i = 0; i < C.length; i++) {  
              C[i] = new BankDetails();  
              C[i].openAccount();  
          }  
          // perulangan berjalan sampai berjumlah 5 nomor jika tidak ditekan untuk keluar. 
          int ch;  
          do {  
              System.out.println("\n ***System Aplikasi Bank***");  
              System.out.println("\n 1. Tampilkan semua detail akun \n 2. Mencari Akun berdasarkan nomor \n 3. Setorkan jumlah \n 4. Tarik jumlah \n 5. Keluar ");  
              System.out.println("Masukkan Pilihan Anda: ");
              ch = sc.nextInt();  
                  switch (ch) {  
                      case 1:  
                          for (int i = 0; i < C.length; i++) {  
                              C[i].showAccount();  
                          }  
                          break;  
                      case 2:  
                          System.out.print("Masukkan nomor akun kamu yang ingin dicari : "); 
                          String ac_no = sc.next();  
                          boolean found = false;  
                          for (int i = 0; i < C.length; i++) {  
                              found = C[i].search(ac_no);  
                              if (found) {  
                                  break;  
                              }  
                          }  
                          if (!found) {
                              System.out.println("Pencarian gagal! Akun tidak ditemukan..!!");  
                          }  
                          break;  
                      case 3:  
                          System.out.print("Masukkan nomor Akun : "); 
                          ac_no = sc.next();  
                          found = false;  
                          for (int i = 0; i < C.length; i++) {  
                              found = C[i].search(ac_no);  
                              if (found) {  
                                  C[i].deposit();  
                                  break;  
                              }  
                          }  
                          if (!found) {
                              System.out.println("Pencarian gagal! Akun tidak ditemukan..!!");  
                          }  
                          break;  
                      case 4:  
                          System.out.print("Masukkan nomor Akun : ");  
                          ac_no = sc.next();  
                          found = false;  
                          for (int i = 0; i < C.length; i++) {  
                              found = C[i].search(ac_no);  
                              if (found) {  
                                  C[i].withdrawal();  
                                  break;  
                              }  
                          }  
                          if (!found) {  
                              System.out.println("Pencarian gagal! Akun tidak ditemukan..!!");  
                          }  
                          break;  
                      case 5:  
                          System.out.println("See you soon my love...");  
                          break;  
                  }  
              }  
              while (ch != 5);
        }  
        }  
    }  
