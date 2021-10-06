package com.techelevator;

import java.util.List;

public class QuizMaker {

	public static void main(String[] args) {

		UserInteraction ui = new UserInteraction();
		String path = ui.promptUserForFilePath();
		FileParser fileParser = new FileParser();
		List<QuizQuestion> questionList = fileParser.parseQuizFile(path);
		int correctAnswers = 0;
		for(QuizQuestion q : questionList) {
			q.shuffle();
			ui.askQuizQuestion(q);

			int guess = ui.promptUserForGuess(q.getAnswers().size());
			if (q.isCorrectAnswer(guess)) {
				ui.correct();
				correctAnswers++;
			} else {
				ui.incorrect();
			}
		}
		ui.summary(correctAnswers, questionList.size());
	}
}
