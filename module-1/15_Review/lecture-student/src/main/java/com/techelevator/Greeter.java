package com.techelevator;

import java.time.LocalDate;
import java.time.LocalTime;

public class Greeter {
    private String greeting;

    public Greeter() {
        this.greeting = "Hello World!";
    }

    public String greetingAndTime() {
        return this.greeting + " Today is " + LocalDate.now() + " and it is currently: " + LocalTime.now();
    }

    public String getGreeting() {
        return this.greeting;
    }
}