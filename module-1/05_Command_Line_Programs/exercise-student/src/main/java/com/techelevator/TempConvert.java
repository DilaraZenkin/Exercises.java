package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to the Temperature Conversion");
		System.out.println("Enter the temperature here: ");

		String convertString = keyboard.nextLine();


		System.out.println("Is the temperature in (C)elcius or (F)ahrenheit? ");
		System.out.println("Please type C or F");
		String name = keyboard.nextLine();

		Double convertDoubleFahrenheit = Double.parseDouble(convertString);
		Double convertDoubleCelsius = Double.parseDouble(convertString);

		if (name.equalsIgnoreCase("F")) {
			System.out.println(((convertDoubleFahrenheit - 32) / 1.8) + " C");

		} else if (name.equalsIgnoreCase("C")) {

			System.out.println(((convertDoubleCelsius * 1.8) + 32) + " F");


		}

	}
}

