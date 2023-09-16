package com.dicoding.person;

// Person.java
public class Person {
    private String name;
    private int age;
    private String lastName;
    private String studentId;
    private String hobby;
    private String birthDate;
    private String GPA;

    public Person(String name, int age, String lastName, String studentId, String hobby, String birthDate, String GPA) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.studentId = studentId;
        this.hobby = hobby;
        this.birthDate = birthDate;
        this.GPA = GPA;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getlastName() {
        return lastName;
    }
    public String getstudentId() {
        return studentId;
    }
    public String gethobby() {
        return hobby;
    }
    public String getbirthDate() {
        return birthDate;
    }
    public String getgpa() {
        return GPA;
    }
    
}