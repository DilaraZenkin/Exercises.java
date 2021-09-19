package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Fibonacci Numbers");
		System.out.println("Enter the number here-->>");
		String numberString = keyboard.nextLine();


		int numberInt = Integer.parseInt(numberString);

		if (numberInt == 0) {
			System.out.println(numberInt);
		} else {


			int firstNumber = 0;
			int secondNumber = 1;

			for (int i = 0; i < numberInt; i++) {
				if (i == firstNumber) {

					System.out.println((firstNumber + " " + secondNumber + " "));
				} else if (i == firstNumber + secondNumber) {
					System.out.println(i + "");
					if (secondNumber >= firstNumber) {
						firstNumber = i;
					} else {
						secondNumber = i;
					}


				}


			}

		}
	}
}
