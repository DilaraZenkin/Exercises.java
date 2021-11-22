package com.techelevator;

public class TimePeriod {
    private int startTime;
    private int endTime;
    private String startTimeString;
    private String endTimeString;


     // TimePeriod with the a given start and end time

    public TimePeriod(int st, int et, String sts, String ets)
    {
        startTime = st;
        endTime = et;
        startTimeString = sts;
        endTimeString = ets;
    }


    public int getStart()
    {
        return startTime;
    }


    public String startPrint()
    {
        return startTimeString;
    }


    public int getEnd()
    {
        return endTime;
    }


    public String endPrint()
    {
        return endTimeString;
    }


     //Checks to see if two lectures TimePeriod's overlap
     //If the Start Time or the End Time is in between another's, return true
     // Lecture to check with
     // a boolean value if the lecture's time overlaps or not

    public boolean overlap(Curriculum e)
    {
        boolean overlap = false;

        if(e.getTimeInterval().getStart() >= getStart() && e.getTimeInterval().getStart() <= getEnd())
            overlap = true;
        else if(e.getTimeInterval().getEnd() >= getStart() && e.getTimeInterval().getEnd() <= getEnd())
            overlap = true;
        else if (e.getTimeInterval().getStart() == getStart() || e.getTimeInterval().getStart() == getEnd()
                || e.getTimeInterval().getEnd() == getStart() || e.getTimeInterval().getEnd() == getEnd())
            overlap = true;

        return overlap;
    }
}
