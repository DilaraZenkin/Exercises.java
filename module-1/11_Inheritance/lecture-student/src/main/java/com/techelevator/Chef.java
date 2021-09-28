package com.techelevator;

public class Chef extends Person {
    private int yearsExperience;
    private String speciality;

    public Chef(String firstName, String lastName, int age, int yearsExperience, String speciality) {
        super();

        this.yearsExperience = yearsExperience;
        this.speciality = speciality;


    }
    @Override
    public String getFirstName() {
        String firstName = super.getFirstName();
        return "Chef" + firstName;
    }

}
