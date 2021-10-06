package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int lineCounter = 1;

		System.out.print("Name of file: ");
		String fileName = userInput.nextLine();
		File fileAlice = new File(fileName);

		try (Scanner fileScanner = new Scanner(fileAlice)) {
			System.out.print("Search word: ");
			String word = userInput.nextLine();

			System.out.print("Case sensy? (Y/N): ");
			String choice = userInput.nextLine().toLowerCase();

			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				if (choice.startsWith("n")) {
					if(line.toLowerCase().contains(word.toLowerCase())) {
						System.out.println("Line " + lineCounter + ": " + line);
					}
				} else if (line.contains(word)) {
					System.out.println("Line " + lineCounter + ": " + line);
				}
				lineCounter++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not open file: " + e.getMessage());
		}
	}
}
