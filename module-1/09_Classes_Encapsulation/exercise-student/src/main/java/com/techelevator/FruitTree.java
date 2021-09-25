package com.techelevator;

public class FruitTree {

    // DATA: Instance variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;


    // Constructor
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        piecesOfFruitLeft = startingPiecesOfFruit;
    }


    // Derived Property:
    public boolean pickFruit(int numberOfPiecesToRemove) {
        if(piecesOfFruitLeft < numberOfPiecesToRemove) {
            return false;
        }

        piecesOfFruitLeft -= numberOfPiecesToRemove;

        return true;
    }

    // Getters and Setters
public String getTypeOfFruit() {
        return typeOfFruit;
}
public int getPiecesOfFruitLeft(){
        return piecesOfFruitLeft;
}
}
