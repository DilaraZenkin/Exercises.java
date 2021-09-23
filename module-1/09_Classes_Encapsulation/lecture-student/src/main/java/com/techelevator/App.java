package com.techelevator;

public class App {
    public static void main(String[] args) {

        House h = new House(3, 2.5,"123 Main", 100,100, true);
        House h2 = new House(5, 4.0, "124 Main");

        System.out.println("Before renovations:");
        System.out.println(h.getBedrooms());
        System.out.println(h.getBathrooms());

        h.renovate();

        System.out.println("After renovations:");
        System.out.println(h.getBedrooms());
        System.out.println(h.getBathrooms());


        System.out.println(h.toString());
        System.out.println(h2);

        System.out.println(12);

    }
}
