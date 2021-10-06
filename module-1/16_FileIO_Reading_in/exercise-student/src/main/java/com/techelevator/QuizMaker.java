package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Question> questions = new ArrayList<Question>();

		Scanner in = new Scanner(System.in);
		String path = "C:\\Users\\Student\\workspace\\dilarazenkin-java\\module-1\\16_FileIO_Reading_in\\exercise-student\\test_quiz.txt";
		File fileTestQuiz = new File(path);

		if (fileTestQuiz.exists() && fileTestQuiz.isFile()) {
			try (Scanner fileScanner = new Scanner(System.in)) {
				while (fileScanner.hasNextLine()) {
					questions.add(new Question(fileScanner.nextLine()));
				}
			}
		} else {
			System.out.println("File could not be read; please try again!");
		}


		try (Scanner userInput = new Scanner(System.in)) {
			int correctCount = 0;
			for (Question question : questions) {
				System.out.println(question.getQuestion());

				int counter = 1;

				for (String choice : question.getAnswers()) {
					System.out.println(counter + ". " + choice);
					counter++;
				}

				System.out.println();

				System.out.print("Your answer: ");
				int choice = userInput.nextInt();
				userInput.nextLine();
				System.out.println();


				if (choice < 1 || choice > 4) {
					System.out.println("Invalid answer!");
				} else if (choice == question.getAnswerIndex()) {
					System.out.println("Correct!");
					correctCount++;
				} else {
					System.out.println("Incorrect!");
				}
				System.out.println();
			}
			System.out.println("You got " + correctCount + " correct out of the total " + questions.size() + " questions asked");
		}
	}
}
//					String answerOfQuestionOne = userInput.nextLine();
//
//					if(answerOfQuestionOne.equals(answerOfQuestionOne[2]))
//			}
//		}
//



