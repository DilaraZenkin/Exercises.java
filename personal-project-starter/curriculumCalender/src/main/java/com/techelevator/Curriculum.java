package com.techelevator;

public class Curriculum {
    private String name;
    private TimePeriod timePeriod;
    private boolean isRegular;


    public Curriculum(String n, TimePeriod tP, boolean isR)
    {
        name = n;
        timePeriod = tP;
        isRegular = isR;
    }


    public String getName()
    {
        return name;
    }


    public TimePeriod getTimeInterval()
    {
        return timePeriod;
    }


     //Returns a boolean value if the event given is a regular even or not
    // return true or false if the event is a regular event

    public boolean getIsRegular()
    {
        return isRegular;
    }
}
