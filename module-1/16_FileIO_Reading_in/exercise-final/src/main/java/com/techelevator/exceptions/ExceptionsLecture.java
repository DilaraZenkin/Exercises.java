package com.techelevator.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsLecture {

	public static void main2(String[] args) {
		String[] cities = new String[] {"Pittsburgh", "Philadelphia", "Harrisburg"};

		try {
			System.out.println(cities[0] + " is a city in Pennsylvania");
			System.out.println(cities[1] + " is a city in Pennsylvania");
			System.out.println(cities[2] + " is a city in Pennsylvania");
			doSomethingStupid();
			System.out.println(cities[3] + " is a city in Pennsylvania");
			System.out.println(" I forgot Johnstown and Erie!");
			System.out.println("Oh well, too bad for them");
		} catch (Exception e) {
			System.out.println("Oh no! We had a problem!");
			System.out.println("Printing out the stack trace anyway:");
			e.printStackTrace();
		}

		System.out.println("That's all, folks");
	}

	public static void doSomethingStupid() {
		try {
			System.out.println(100 / 0);
		} catch (Exception e) {
			System.out.println("Whoops!");
		}
	}

	public static void fahrenheitToFahrenheit() {
		Scanner scan = new Scanner(System.in);

		boolean weHaveValidInput = false;

		while(!weHaveValidInput) {
			System.out.print("Enter the number of degrees Fahrenheit >>> ");
			String userTyped = scan.nextLine();

			try {
				int userTypedAsInteger = Integer.parseInt(userTyped);
				weHaveValidInput = true;
				System.out.println(userTypedAsInteger + " degrees F is equal to: " + userTypedAsInteger + " in F");
			} catch (Exception e) {
				System.out.println("Hey! Play nice!");
				System.out.println(e.getMessage() + " is not a number!");
			}
		}

		System.out.println("Done!");

	}

	public static int calculateHotelRoomCharge(int numberOfNights, int numberOfGuests) throws HotelException {
		int extraGuestCharge = 25;
		int roomRate = 100;

		if (numberOfNights < 1) {
			System.out.println("Don't do that!");
			//throw new IllegalArgumentException("Non-positive number of nights!");
			throw new HotelException();
		}

		if (numberOfGuests < 1) {
			System.out.println("Don't do that!");
			// throw new IllegalArgumentException("Non-positive number of guests!");
			throw new HotelException();

		}

		return (numberOfGuests * extraGuestCharge) * numberOfNights + (numberOfNights * roomRate);
	}

	public static void main(String[] args) {
		System.out.println("Let's book a hotel room!");
		Scanner darkly = new Scanner(System.in);
		System.out.print("How many people? >>> ");
		int ppl = Integer.parseInt(darkly.nextLine());
		System.out.print("How many nights? >>> ");
		int nights = Integer.parseInt(darkly.nextLine());


		int totalCharge = calculateHotelRoomCharge(ppl, nights);
		System.out.println(ppl + " Guests for " + nights + " nights has a total charge of: " + totalCharge);

		System.out.println("Done!");
	}


}
