package com.techelevator;

public class HomeworkAssignment {
    // DATA: Instance variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    // Constructor
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    // Derived Property: letterGrade(there is no "string

    public String getLetterGrade () {
        //letterGrade = earnedMarks / possibleMarks;
        String letterGrade = null;

        // I multiplied 1.0 to turn it double.

        if(((1.0 * earnedMarks / possibleMarks) * 100) >=90) {
            return "A";
        } else if (((1.0 * earnedMarks / possibleMarks) * 100) >=80) {
            return  "B";
        } else if (((1.0 * earnedMarks / possibleMarks) * 100) >=70) {
            return "C" ;
        } else if(((1.0 * earnedMarks / possibleMarks) * 100) >=60) {
            return "D";
        } else {
            return "F";
        }

    }


// Getters and Setters
    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;

    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }
}
