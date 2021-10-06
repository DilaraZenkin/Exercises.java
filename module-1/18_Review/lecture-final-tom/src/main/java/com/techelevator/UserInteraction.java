package com.techelevator;

import java.util.List;
import java.util.Scanner;

public class UserInteraction {

    private static Scanner keyboard;

    public UserInteraction() {
        keyboard = new Scanner(System.in);
    }

    public void askQuizQuestion(QuizQuestion q) {
        System.out.println(q.getQuestion());
        List<String> answers = q.getAnswers();

        int counter = 1;
        for(String answer : answers) {
            System.out.println(counter + ". " + answer);
            counter++;
        }

    }

    public int promptUserForGuess(int maxValue) {
        boolean haveValidInput = false;
        int number = -1;

        while(!haveValidInput) {
            System.out.print("What is your guess? >>> ");
            String guess = keyboard.nextLine();
            try {
                number = Integer.parseInt(guess);
                if (number < 1 || number > maxValue) {
                    System.out.println(number + " is not a valid option!");
                } else {
                    haveValidInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " is not a valid number! Try again.");
            }
        }

        return number;
    }

    public String promptUserForFilePath() {
        System.out.print("Enter the path to the quiz question file >>> ");
        String path = keyboard.nextLine();
        return path;
    }

    public void correct() {
        System.out.println("You got that right!");
    }

    public void incorrect() {
        System.out.println("You got that WRONG!");
    }

    public void summary(int correctAnswers, int totalQuestions) {
        System.out.println("Done!");
        System.out.println("You got " + correctAnswers + " out of " + totalQuestions + " correct!" );
        System.out.println(((double)correctAnswers * 100) / totalQuestions + "%" );
    }
}
