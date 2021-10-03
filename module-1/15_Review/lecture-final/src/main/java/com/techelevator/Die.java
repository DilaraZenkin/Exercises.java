package com.techelevator;

import java.util.Random;

public class Die {

    private final int numberOfSides;
    private int value;

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        roll();
    }

    public final int roll() {
        Random rando = new Random();
        this.value = rando.nextInt(this.numberOfSides) + 1;
        return this.value;
    }

    public final int getNumberOfSides() {
        return this.numberOfSides;
    }

    public final int getValue() {
        return this.value;
    }

    @Override
    public final String toString() {
        Integer val = new Integer(this.value);
        return val.toString();
    }
}
