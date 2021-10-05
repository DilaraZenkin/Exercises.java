package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to File Copier!");
		System.out.println("Which file should be copied? >>> ");
		String fileToCopyAsString = keyboard.nextLine();

		System.out.println("What is the name of the output file? >>> ");
		String fileToCreateAsString = keyboard.nextLine();

		File fileToCopy = new File(fileToCopyAsString);
		File fileToCreate = new File(fileToCreateAsString);

		try (PrintWriter printWriter = new PrintWriter(fileToCreate)) {

			Scanner scanner = new Scanner(fileToCopy);
			while(scanner.hasNextLine()) {
				String currentLine = scanner.nextLine();
				printWriter.println(currentLine);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		}

	}


	public static void main2(String[] args) {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

//		System.out.println("Enter a path: ");
//		String userPath = userInput.nextLine();
//
//		File userFile = new File(userPath);
//		if (userFile.exists()) {
//			System.out.println("This exists!");
//			if (userFile.isDirectory()) {
//				System.out.println("This is a directory!");
//			} else {
//				System.out.println("This is a file!");
//			}
//
//			System.out.println("Size: " + userFile.length());
//
//		} else {
//			System.out.println("This file has yet to be created!");
//		}
//		System.out.println("Regular path: " + userFile.getPath());
//		System.out.println("Absolute path: " + userFile.getAbsolutePath());
//

		System.out.println("Create a directory!");
		System.out.println("Enter the path >>> ");
		String newDirectoryPath = userInput.nextLine();
		File newDirectory = new File(newDirectoryPath);

		if(newDirectory.exists()) {
			System.out.println("This directory already exists!");
		} else {
			newDirectory.mkdir();
			System.out.println("New Directory created at: " + newDirectory.getAbsolutePath());
		}


		System.out.println("Let's create a file in that directory!");
		System.out.println("Enter new file name >>> ");
		String newFileName = userInput.nextLine();

		File newFile = new File(newDirectoryPath, newFileName);

		if (newFile.exists()) {
			System.out.println("That file already exists!");
		} else {

			// try-with-resources
			try (PrintWriter writer = new PrintWriter(newFile)) {
				System.out.println("Enter a message for the new file >>> ");

				for (int i = 0; i < 10000; i++) {
					writer.print(i);
					if (i % 1000 == 0) {
						writer.println();
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			}

		}

		System.out.println("Done!");

	}

}
