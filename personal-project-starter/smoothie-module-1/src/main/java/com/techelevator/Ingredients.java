package com.techelevator;

public class Ingredients {
    private String name;
    private double cup;

    public Ingredients(String name, double cup) {
        this.name = name;
        this.cup = cup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCup() {
        return cup;
    }

    public void setCup(double cup) {
        this.cup = cup;
    }
}
