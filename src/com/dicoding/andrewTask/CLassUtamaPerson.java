package com.dicoding.andrewTask;

import java.util.Date;

public class CLassUtamaPerson {
  public static void main(String[] args) {
      // Contoh penggunaan kelas Person
      Person person1 = new Person(); // Menggunakan konstruktor default
      @SuppressWarnings("deprecation")
      Person person2 = new Person("John", 25, "Doe", "S67890", "Reading", new Date(1998, 5, 15), 3.8); // Menggunakan konstruktor dengan argumen

      // Mengakses atribut dan metode
      System.out.println("Person 1's student ID: " + person1.getStudentId());
      System.out.println("Person 1's hobby: " + person1.getHobby());
      System.out.println("Person 1's birth date: " + person1.getBirthDate());
      System.out.println("Person 1's GPA: " + person1.getGPA());

      System.out.println("Person 2's student ID: " + person2.getStudentId());
      System.out.println("Person 2's hobby: " + person2.getHobby());
      System.out.println("Person 2's birth date: " + person2.getBirthDate());
      System.out.println("Person 2's GPA: " + person2.getGPA());

      person1.introduceMyself();
      person2.introduceMyself();

      // Mengubah nama dan usia Person 1
      person1.setName("Alice");
      person1.setAge(30);

      System.out.println("Updated Person 1's name: " + person1.getName());
      System.out.println("Updated Person 1's age: " + person1.getAge());
  }
  
}
