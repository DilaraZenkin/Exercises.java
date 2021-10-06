package com.techelevator;

import java.util.ArrayList;

public class Question {
    // Data
    private String question;
    private ArrayList<String> answers = new ArrayList<String>();
    private int answerIndex;

    //Constructor

    public Question(String questionSignature) {

        String[] questionArray = questionSignature.split("\\|");
        this.question = questionArray[0];


        //Methods
        for(int i=0; i<questionArray.length; i++) {
            if(questionArray[i].endsWith("*")) {
                String fixed = questionArray[i].substring(0, questionArray.length-1);
                if(fixed.endsWith("*")) fixed= fixed.substring(0, fixed.length()-1);
                questionArray[i]=fixed;
                answerIndex = i;
            }
            answers.add(questionArray[i]);
        }

    }

    //Getters

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
}
