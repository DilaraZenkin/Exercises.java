package com.techelevator;

import java.util.Scanner;

public class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    // public= access modified=make everything public.
    // static= ???we will talk about later.
    // void= return type=there is no return statement= there is nothing come out off it. there could be input but no output.
    // main=method name
    // (input)
    public static void main(String[] args) {

        // Establish connection to the keyboard
        Scanner keyboard = new Scanner(System.in);


        //prompt user
        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        // 20% off!

        String discountString = keyboard.nextLine();
        int discountInt = Integer.parseInt(discountString);

        System.out.println("Discount from $500: ");
        System.out.println((discountInt /100.0) *500);


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");






    }

}