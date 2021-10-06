package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		int lineCounter = 1;
		Scanner userInput = new Scanner(System.in);
			System.out.println("What is the fully qualified name of the file that should be searched?");
			String fileName = userInput.nextLine();

			System.out.println("What is the search word you are looking for?");
			String word = userInput.nextLine();

			System.out.println("Should the search be case sensitive? (Y/N)");
			String choice = userInput.nextLine();

			File fileAlice = new File(fileName);
			if (fileAlice.exists() && fileAlice.isFile()) {
				try (Scanner fileScanner = new Scanner(fileAlice)) {
					while (fileScanner.hasNextLine()) {
						String line = fileScanner.nextLine();
						if (choice.equalsIgnoreCase("n")) {
							if (line.toLowerCase().contains(word.toLowerCase())) {
								System.out.println("Line " + lineCounter + ": " + line);
							}
						} else if (line.contains(word)) {
							System.out.println("Line " + lineCounter + ": " + line);
						}
						lineCounter++;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("File could not be read; please try again.");
			}


		}
	}

























//WordSearch ws = new WordSearch();
//Scanner keyboard = new Scanner(System.in);
//System.out.println("What is the fully qualified name of the file that should be search?");
//String wcFilePath = keyboard.nextLine();
//System.out.println("What is the search word you are looking for?");
//
//		File aliceFile = new File(wcFilePath);
//try {
//	Scanner scan = new Scanner(aliceFile);
//	System.out.println("What is the fully qualified name of the file that should be search?");
//	String fileName = scan.nextLine();
//
//} catch (Exception e) {
//	System.out.println("Couldn't open " + aliceFile.getName());
//}
//
//		int flag = 0;
//		int lineNumber = 0;
//
//		System.out.println("What is the fully qualified name of the file that should be search?");
//		String fileName = scan.nextLine();
//
//
//		System.out.println("What is the search word you are looking for?");
//		String word = scan.nextLine();
//
//		System.out.println("Should the search word be case sensitive? (Y/N)");
//		String choice = scan.nextLine();
//
//		if (choice.equals("N")) {
//			word = word.toLowerCase();
//			flag = 1;
//			try {
//				BufferedReader reader = new BufferedReader(new FileReader("dr_jekyll_mr_hyde.txt"));
//				//reader = new BufferedReader(new FileReader(fileName));
//				String line = reader.readLine();
//				lineNumber++;
//
//				while (line != null) {
//					if (flag == 1) {
//						String temp = line.toLowerCase();
//						if (temp.contains(word)) {
//							System.out.println(lineNumber + ")" + line);
//						}
//					} else if (line.contains(word)) {
//						System.out.println(lineNumber + ")" + line);
//					}
//				}
//
//				line = reader.readLine();
//				lineNumber++;
//
//				reader.close();
//			} catch (IOException e) {
//				System.out.println("File not found!");
//			}
//		}
	//}
//}