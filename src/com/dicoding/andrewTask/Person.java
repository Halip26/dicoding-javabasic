package com.dicoding.andrewTask;
import java.util.Date;

public class Person {
    // Atribut
    private String name;
    private int age;
    private String lastName;
    private String studentId;
    private String hobby;
    private Date birthDate;
    private Double GPA;

    // Konstruktor default
    public Person() {
        this.name = "Charlie";
        this.age = 17;
        this.lastName = "Chaplin";
        this.studentId = "S12345";
        this.hobby = "Unknown";
        this.birthDate = new Date();
        this.GPA = 0.0;
    }

    // Konstruktor dengan argumen
    public Person(String name, int age, String lastName) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
    }

    // Metode untuk mengembalikan nama lengkap
    public String getFullName() {
        return name + " " + lastName;
    }

    // Metode untuk mencetak pesan perkenalan
    public void introduceMyself() {
        System.out.println("My name is " + getFullName() + " and my age is " + age);
    }

    // Metode untuk mengembalikan name
    public String getName() {
        return name;
    }

    // Metode untuk mengembalikan age
    public int getAge() {
        return age;
    }

    // Metode untuk mengubah name
    public void setName(String name) {
        this.name = name;
    }

    // Metode untuk mengubah age
    public void setAge(int age) {
        this.age = age;
    }
    
    public static void main(String[] args) {
        // Contoh penggunaan kelas Person
        Person person1 = new Person(); // Menggunakan konstruktor default
        Person person2 = new Person("John", 25, "Doe"); // Menggunakan konstruktor dengan argumen

        // Mengakses atribut dan metode
        System.out.println("Person 1's name: " + person1.getName());
        System.out.println("Person 1's age: " + person1.getAge());

        System.out.println("Person 2's name: " + person2.getName());
        System.out.println("Person 2's age: " + person2.getAge());

        person1.introduceMyself();
        person2.introduceMyself();

        // Mengubah nama dan usia Person 1
        person1.setName("Alice");
        person1.setAge(30);

        System.out.println("Updated Person 1's name: " + person1.getName());
        System.out.println("Updated Person 1's age: " + person1.getAge());  
    }

    // Konstruktor dengan argumen
    public Person(String name, int age, String lastName, String studentId, String hobby, Date birthDate, Double GPA) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.studentId = studentId;
        this.hobby = hobby;
        this.birthDate = birthDate;
        this.GPA = GPA;
    }

    // Metode untuk mengembalikan studentId
    public String getStudentId() {
        return studentId;
    }

    // Metode untuk mengembalikan hobby
    public String getHobby() {
        return hobby;
    }

    // Metode untuk mengembalikan birthDate
    public Date getBirthDate() {
        return birthDate;
    }

    // Metode untuk mengembalikan GPA
    public Double getGPA() {
        return GPA;
    }

}
