package com.techelevator;

public class House {

    // Instance Variables
    private int bedrooms;
    private double bathrooms;
    private String address;
    private int length;
    private int width;
    private boolean occupied;


    // Constructor
    public House(int bedrooms, double bathrooms, String address, int length, int width, boolean occupied) {
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.address = address;
        this.length = length;
        this.width = width;
        this.occupied = occupied;
    }

    public House(int bedrooms, double bathrooms, String address) {
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.address = address;
    }
//    default constructor
//    public House() {}

    // Behaviors!
    private void myMethod() {
        System.out.println("HEY! THIS IS PRIVATE!");
    }

    public void renovate() {
        this.bedrooms++;
        this.bathrooms++;
    }

    public String toString() {
        return "House {" +
                "bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", address='" + address + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", occupied=" + occupied +
                '}';
    }

    //    public String toString() {
//        String output = "This house is located at: " + this.address + ". ";
//        output += "It has " + this.bedrooms + " bedrooms and " + this.bathrooms + " bathrooms";
//        return output;
//    }

    // Derived Property
    public int getSqFootage() {
        myMethod();
        return width * length;
    }

    // Setters & Getters
    public int getBedrooms() {
        return bedrooms;
    }

//    public void setBedrooms(int bedrooms) {
//        if (bedrooms < 0) {
//            this.bedrooms = 0;
//        } else {
//            this.bedrooms = bedrooms;
//        }
//    }

    public double getBathrooms() {
        return bathrooms;
    }

//    public void setBathrooms(double bathrooms) {
//        if (bathrooms < 0) {
//            this.bathrooms = 0;
//        } else {
//            this.bathrooms = bathrooms;
//        }
//    }

    public String getAddress() {
        return address;
    }

//    public void setAddress(String address) {
//        this.address = address;
//    }


    public int getLength() {
        return length;
    }

//    public void setLength(int length) {
//        this.length = length;
//    }

    public int getWidth() {
        return width;
    }

//    public void setWidth(int width) {
//        this.width = width;
//    }

    public boolean isOccupied() {
        return occupied;
    }

//    public void setOccupied(boolean occupied) {
//        this.occupied = occupied;
//    }
}
