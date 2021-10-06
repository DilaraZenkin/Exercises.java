package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizQuestion {
    private String question;
    private List<String> answers = new ArrayList<>();  // eager instantiation
    private String correctAnswer;

    public QuizQuestion(String line) {
        // What color is the sky?|yellow|blue*|green|red
        String[] pieces = line.split("\\|");
        this.question = pieces[0];  // What color is the sky?

        for (int i = 1; i < pieces.length; i++) {
            String answer = pieces[i];

            if (answer.endsWith("*")) {   // blue*
                answer = answer.substring(0, answer.length() - 1);  // blue
                this.correctAnswer = answer; // correct answer!
            }
            this.answers.add(answer);
        }

    }

    public boolean isCorrectAnswer(int guess) {
        int index = guess - 1; // adjust for 0-indexing
        return this.answers.get(index) == this.correctAnswer;
    }

    public String getQuestion() {
        return this.question;
    }

    public List<String> getAnswers() {
        List<String> doItMyself = new ArrayList<>(this.answers);
        return doItMyself;
    }

    public void shuffle() {
        Collections.shuffle(this.answers);
    }

}
