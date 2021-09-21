package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
<<<<<<< HEAD
		String name= "Tom";
=======
		String name = "Tom";
		// String name = new String("Tom");
>>>>>>> fb638b9a201fe0a579224f09ac385d27f38b60ad

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		//                   000000000011111111112222222222233333333334
		//                   012345678901234567890123456789012345678901
		String obligatory = "Hello World, You're World awesome World and I love you";
		char d = obligatory.charAt(10);
		String dString = obligatory.substring(10, 11);

		char[] charArray = obligatory.toCharArray();


		Scanner keyboard = new Scanner(System.in);

		while(true) {
			System.out.println("Enter (C)elsius or (F)ahrenheit >>> ");
			String userChoice = keyboard.nextLine();
			if (userChoice.toLowerCase().trim().startsWith("c")) {
				break;
			} else {
				System.out.println("Try again!");
				System.out.println(userChoice + " is not valid input.");
			}
		}

		boolean flag = true;
		for (int i = 0; i < 10 && flag; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == i) {
					flag = false;
					break;
				}
			}
		}

		System.out.println(i);

		// Immutable!
		obligatory = obligatory.toUpperCase();
		obligatory.startsWith("HELLO");


		// "Hello World, You're World awesome World and I love you"
		int firstWorld = obligatory.indexOf("World"); // 6
		obligatory = obligatory.substring(firstWorld + 1);
		// "orld, You're World awesome World and I love you"
		int secondWorld = obligatory.indexOf("World"); // 13
		int lastWorld = obligatory.lastIndexOf("World");


		String garbage = "             Hello There Tom this is a long       sentence          ";
		String slightlyLessGarbage = garbage.trim();
		// "Hello There Tom this is a long       sentence"


String obligatory = "Hello World, You're awesome and I love you";
char h = obligatory.charAt(10);
String dString = obligatory.substring(10, 11);

		 char[] charArray = obligatory.toCharArray();

		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter here-->");
		String userChoice = keyboard.nextLine();

		// Immutable
		obligatory= obligatory.toUpperCase();
		obligatory.startsWith("HELLO");

		if( userChoice.charAt(0) == 'C' || userChoice.charAt(0) == 'c') {

		}
		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();



		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */

<<<<<<< HEAD
		String hello1 = new String("Hello");
		System hello2 = new String("Hello");
=======
		String hello1 = new String("Hello"); // 0xFACE
		String hello2 = new String("Hello"); // 0xFADE
>>>>>>> fb638b9a201fe0a579224f09ac385d27f38b60ad

		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1; // 0xFACE
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		//                 0123456789
		String language = "JavaScript";
		for (int i = 0; i < language.length(); i++) {
			String thisLetter = language.substring(i, i+1);

			System.out.println(thisLetter);
		}

		String example;  // example is null
//		example.length(); // Null Pointer Exception

		String example2 = "";
		example2.length(); // 0





	}
}
