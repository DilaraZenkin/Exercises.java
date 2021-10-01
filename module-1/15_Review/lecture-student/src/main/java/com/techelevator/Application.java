package com.techelevator;

public class Application {

	public static void main(String[] args) {
		System.out.println("Running my application!");

		Greeter whatUpG = new Greeter();
		System.out.println(whatUpG.greetingAndTime());

		System.out.println("Done!");
	}
}
