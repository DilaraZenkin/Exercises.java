package com.techelevator;


import java.io.*;
import java.util.Scanner;

public class FizzWriter {


	public static void main(String[] args) {
//		Scanner userInput = new Scanner(System.in);
//		System.out.println("Create a directory!");
//		System.out.println("Enter the path >>> ");
//		String newDirectoryPath = userInput.nextLine();
//		File newDirectory = new File(newDirectoryPath);
//
//		if (newDirectory.exists()) {
//			System.out.println("This directory already exists!");
//		} else {
//			newDirectory.mkdir();
//			System.out.println("New Directory created at: " + newDirectory.getAbsolutePath());
//		}
//
//
//		System.out.println("Let's create a file in that directory!");
//		System.out.println("Enter new file name >>> ");
//		String newFileName = userInput.nextLine();
//
//		File newFile = new File(newDirectoryPath, newFileName);
//
//		if (newFile.exists()) {
//			System.out.println("That file already exists!");
//		} else {
//
//			// try-with-resources
//			try (PrintWriter writer = new PrintWriter(newFile)) {
//
//				for (int i = 1; i <= 300; i++) {
//					writer.print(i + "\n");
//
//				}
//			} catch (FileNotFoundException e) {
//				System.out.println("File not found!");
//			}

			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter source filename: ");
			String file = scanner.nextLine();

			File theFile = new File("source_file_FizzWriter.txt");

			if (!theFile.exists()) {
				System.out.println("Error: " + file + " not found.");
				return;
			}
			File destinationFile = new File("destination_FizzWriter.txt");
			try {
				FileWriter writer = new FileWriter(destinationFile);
				for (int num = 1; num <= 300; num++) {
					if (num % 15 == 0) writer.write("FizzBuzz\r\n");
					else if (num % 3 == 0) writer.write("Fizz\r\n");
					else if (num % 5 == 0) writer.write("Buzz\r\n");
					else writer.write(String.format("%d\r\n", num));
				}
				writer.flush();
				writer.close();
				System.out.println(file + " overwritten successfully.");

			} catch (IOException e) {
				System.out.println("Error: " + file + " not found.");
			}

		}
	}


