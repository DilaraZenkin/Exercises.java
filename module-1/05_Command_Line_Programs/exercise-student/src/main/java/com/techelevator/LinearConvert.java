package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to the Linear Conversion");
		System.out.println("Please enter the length here: ");

		String convertString = keyboard.nextLine();

		System.out.println("Is the measurement in (m)eter or (f)eet?");
		System.out.println("Please type m or f: ");

		String name = keyboard.nextLine();

		Double convertDoubleMeter = Double.parseDouble(convertString);
		Double convertDoubleFeet = Double.parseDouble(convertString);

		if(name.equalsIgnoreCase("m")) {
			System.out.println((convertDoubleMeter * 3.2808399) + " feet");
		} else if(name.equalsIgnoreCase("f")) {
			System.out.println((convertDoubleFeet * 0.3048) + " meter");
		}

	}

}
