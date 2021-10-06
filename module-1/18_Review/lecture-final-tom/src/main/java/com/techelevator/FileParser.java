package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {

    public List<QuizQuestion> parseQuizFile(String path) {
        File quizFile = new File(path);
        List<QuizQuestion> questionList = new ArrayList<>();
        try {
            Scanner quizFileStreamer = new Scanner(quizFile);

            while (quizFileStreamer.hasNextLine()) {
                String line = quizFileStreamer.nextLine();
                QuizQuestion q = new QuizQuestion(line);
                questionList.add(q);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + path);
        }

        return questionList;
    }
}
