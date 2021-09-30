package com.techelevator;

public class SquareWall extends RectangleWall {
    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength);

    }

    @Override
    public int getSideLength() {
        return sideLength;
    }


    public int getArea() {
        return sideLength * sideLength;
    }

    public String toString() {
        return getName()+ " " + "(" +getSideLength()+  "x" +  getSideLength() +")" +  " " + "square";
    }
}
