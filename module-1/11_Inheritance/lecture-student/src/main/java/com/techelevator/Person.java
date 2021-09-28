package com.techelevator;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.age = 10;
    }

    public String getFirstName() {
        return firstName;
    }
}
