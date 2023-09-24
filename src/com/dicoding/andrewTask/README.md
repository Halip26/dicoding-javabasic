# Penjelasan Pada script BankAccount

Kode di class BankAccount adalah contoh implementasi kelas BankAccount dalam bahasa Java. Kelas ini memiliki atribut-atribut berikut:

accountNumber (String): menyimpan nomor akun dari rekening bank.
balance (double): menyimpan jumlah saldo dari rekening bank.
cardOpeningDate (Date): menyimpan tanggal pembukaan kartu.
currency (String): menyimpan mata uang yang digunakan.
Selain itu, kelas ini memiliki konstruktor untuk menginisialisasi objek BankAccount dengan nilai-nilai awal. Seluruh atribut di dalam kelas ini memiliki akses modifier private, yang berarti atribut-atribut ini hanya dapat diakses dan diubah oleh metode-metode yang ada di dalam kelas ini sendiri.

Terdapat metode-metode getter (getAccountNumber, getBalance, getCardOpeningDate, getCurrency) yang digunakan untuk mendapatkan nilai dari atribut-atribut tersebut, dan metode-metode setter (setAccountNumber, setBalance, setCardOpeningDate, setCurrency) yang digunakan untuk mengubah nilai dari atribut-atribut tersebut.

Selain itu, terdapat juga metode save dan withdraw yang digunakan untuk menyimpan dan menarik sejumlah uang dari rekening bank. Metode save akan menambahkan jumlah yang dimasukkan ke saldo, sedangkan metode withdraw akan mengurangi saldo jika jumlah yang dimasukkan tersedia dalam saldo.

Dalam kedua metode tersebut, terdapat juga penggunaan pernyataan System.out.println untuk mencetak pesan ke konsol.

Dengan adanya akses modifier private dan metode getter dan setter yang sesuai, penggunaan atribut dan manipulasi nilai dari luar kelas BankAccount dapat dikontrol dan dikelola dengan aman.

## kenapa variablenya harus kita private ?

Variabel-variabel dalam kelas BankAccount dideklarasikan dengan access modifier private untuk menyembunyikan akses langsung dari luar kelas. Ini mengikuti prinsip enkapsulasi dalam pemrograman berorientasi objek, yang berfokus pada konsep menyembunyikan rincian implementasi dan membatasi akses langsung ke data.

Dengan menggunakan access modifier private, kita menunjukkan bahwa atribut-atribut dalam kelas BankAccount hanya dapat diakses dan dimodifikasi dari dalam kelas itu sendiri. Ini memberikan isolasi dan perlindungan terhadap manipulasi yang tidak sah dan menghindari kesalahan atau ketidaksesuaian dalam penyimpanan atau pengambilan data.

Saat variabel-variabel dideklarasikan dengan access modifier private, kita perlu menyediakan metode-metode publik (getter dan setter) untuk mengakses dan mengubah nilai atribut-atribut tersebut dari luar kelas. Ini memberikan kontrol dan validasi yang lebih baik saat mengakses atau mengubah data.

Dengan menggunakan metode getter dan setter, kita dapat menerapkan logika validasi atau aturan bisnis tertentu sebelum nilai atribut diubah. Hal ini membantu menjaga integritas data dan membuat kode yang lebih terstruktur.

Dengan kata lain, penggunaan access modifier private untuk variabel-variabel dalam kelas BankAccount memungkinkan kita untuk membatasi akses langsung ke data dan mengontrol bagaimana nilai-nilai tersebut diakses dan diubah dari luar kelas. Ini mendukung prinsip enkapsulasi dan memastikan penggunaan yang aman dan konsisten dari objek BankAccount.

## Penjelasan BankAccount.java

Berikut adalah penjelasan kode dalam bahasa Indonesia:

Kode di atas adalah sebuah kelas BankAccount yang merepresentasikan akun bank. Di dalam kelas ini terdapat beberapa variabel, yaitu accountNumber (nomor akun), balance (saldo), cardOpeningDate (tanggal pembukaan kartu), dan currency (mata uang).

Kemudian, terdapat sebuah konstruktor yang digunakan untuk menginisialisasi objek BankAccount dengan parameter nomor akun, saldo awal, dan mata uang. Konstruktor ini juga menginisialisasi tanggal pembukaan kartu dengan menggunakan tanggal hari ini.

Kelas BankAccount juga memiliki beberapa getter dan setter untuk mendapatkan dan mengubah nilai dari variabel accountNumber, balance, cardOpeningDate, dan currency.

Selain itu, kelas ini memiliki metode save() untuk menyimpan sejumlah uang ke dalam akun. Metode ini akan menambahkan nilai amount ke variabel balance dan mencetak pesan bahwa penyimpanan berhasil beserta saldo terbaru.

Kelas BankAccount juga memiliki metode withdraw() untuk menarik sejumlah uang dari akun. Metode ini akan memeriksa apakah saldo mencukupi sebelum melakukan penarikan. Jika saldo cukup, maka nilai amount akan dikurangi dari variabel balance dan mencetak pesan bahwa penarikan berhasil beserta saldo terbaru. Jika saldo tidak mencukupi, maka akan mencetak pesan bahwa saldo tidak mencukupi.

Selain itu, terdapat validasi pada metode setCurrency() dimana nilai currency hanya dapat bernilai "ID" atau "US". Jika nilai currency tidak sesuai, maka akan mencetak pesan peringatan bahwa mata uang yang tersedia hanya "ID" dan "US".

Demikian penjelasan mengenai kode tersebut dalam bahasa Indonesia.

## Penjelasan Main.java

Kode di atas adalah sebuah program sederhana yang memungkinkan pengguna untuk mengelola akun bank. Program ini menggunakan konsep objek dan menerima input dari pengguna menggunakan kelas Scanner.

Pada awal program, pengguna diminta untuk memasukkan nomor akun, saldo awal, dan mata uang. Nilai-nilai ini kemudian digunakan untuk membuat objek BankAccount.

Setelah objek BankAccount berhasil dibuat, program akan menampilkan informasi tentang akun tersebut, seperti nomor akun, saldo, tanggal pembukaan kartu, dan mata uang.

Selanjutnya, pengguna diminta untuk memasukkan jumlah uang yang ingin disimpan ke dalam akun. Setelah itu, program akan memanggil metode save() dari objek BankAccount untuk menyimpan uang tersebut ke dalam akun.

Kemudian, pengguna diminta untuk memasukkan jumlah uang yang ingin ditarik. Program akan memanggil metode withdraw() dari objek BankAccount untuk menarik uang tersebut dari akun.

Terakhir, program akan menutup objek Scanner yang digunakan untuk menerima input dari pengguna.

Metode getNextDouble() digunakan untuk memvalidasi input pengguna dan memastikan bahwa yang dimasukkan adalah angka. Jika input yang dimasukkan bukan angka, pesan kesalahan akan ditampilkan dan pengguna diminta untuk memasukkan input yang benar.
