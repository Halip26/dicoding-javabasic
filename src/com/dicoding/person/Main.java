package com.dicoding.person;

// Main.java
public class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Halipuddin", 28, "Hambali", "12653623", "coding", "26-01-1995", "3.45");
    Person person2 = new Person("Andrew", 18, "Lay", "12653623", "coding", "26-01-2003", "3.10");

    // print person1 
    System.out.println("My name is " + person1.getName() + " I'm " + person1.getAge() + " years old, " + person1.getlastName() + " is my last name," + " my student ID is " + person1.getstudentId() + "\n & my hobby is " + person1.gethobby() + ", I was born at " + person1.getbirthDate() + ", my GPA is " + person1.getgpa());

    // Print person2 
    System.out.println("My name is " + person2.getName() + " I'm " + person2.getAge() + " years old, " + person2.getlastName() + " is my last name," + " my student ID is " + person2.getstudentId() + "\n & my hobby is " + person2.gethobby() + ", I was born at " + person2.getbirthDate() + ", my GPA is " + person2.getgpa());

  }
}