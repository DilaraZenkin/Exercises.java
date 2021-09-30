package com.techelevator;

public class RectangleWall extends Wall{
    public int length;
    public int height;
   public int sideLength;

    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.height = height;
        this.length= length;

    }

    public RectangleWall(String name, String color, int sideLength) {
       super(name, color);
       this.sideLength = sideLength;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

   public int getSideLength() {
        return sideLength;
    }

    public int getArea() {
        return height * length;
    }

    public String toString() {
        return getName()+ " " + "(" +getLength()+  "x" +  getHeight() +")" +  " " + "rectangle";
    }

}
