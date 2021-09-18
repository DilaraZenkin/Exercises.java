package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Fibonacci Numbers");
		System.out.println("Enter the number here-->>");
		String numberString = keyboard.nextLine();


		int numberInt = Integer.parseInt(numberString);

		int firstNumber = 0;
		int secondNumber = 1;
		int summary = 0;
		for(int i=2; i<numberInt; i++) {
			summary = summary + i;

			System.out.println(firstNumber + "" + secondNumber + "");



		}




	}

}
