package com.dicoding.inheritance;

public class Kucing extends Hewan {
  public Kucing() {
    super(); // akan tetap memanggil constructor dari parent Class
    System.out.println("construct Kucing");
  }
}
