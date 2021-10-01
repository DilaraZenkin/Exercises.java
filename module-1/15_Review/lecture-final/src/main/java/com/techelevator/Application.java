package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {


		List<Die> dice = new ArrayList<Die>();
		int numberOfDice = 3;
		while(numberOfDice-- > 0) {
			dice.add(new Die(6));
		}

		int sum = 0;
		for(Die die : dice) {
			sum += die.roll();
		}

		System.out.println(dice);
		System.out.println("Total: " + sum);

	}




	public static void main2(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a phrase >>> ");
		String input = keyboard.nextLine();

		SpongeBob bob = new SpongeBob();
		String output = bob.covertToSpongeBobCase(input);

		System.out.println("Before: " + input);
		System.out.println("After: " + output);
	}
}
