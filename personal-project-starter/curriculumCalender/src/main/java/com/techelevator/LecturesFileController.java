package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class LecturesFileController {
    private String fileName = "";


    public LecturesFileController(String name)
    {
        fileName = name;
    }


    public void fileReader(DateController myCal) throws FileNotFoundException
    {
        File events = new File(fileName);
        Scanner input = new Scanner(events);
        TimePeriod timePeriod;
        Curriculum lecture;

        while (input.hasNextLine())
        {
            String eventName = input.nextLine();
            String thing = input.next().toUpperCase();
            if (Character.isLetter(thing.charAt(0)))
            {
                String[] days = thing.split("");

                String startTS = input.next();
                String startT = startTS.replaceAll(":", "");
                int startTime = Integer.parseInt(startT);

                String endTS = input.next();
                String endT = endTS.replaceAll(":", "");
                int endTime = Integer.parseInt(endT);

                timePeriod = new TimePeriod(startTime, endTime, startTS, endTS);

                String[] startD = input.next().split("/");
                if(startD[2].length() == 2)
                    startD[2] = "20" + startD[2];

                String[] endD = input.next().split("/");
                if(endD[2].length() == 2)
                    endD[2] = "20" + endD[2];

                lecture = new Curriculum(eventName, timePeriod, true);

                LocalDate newDateS = LocalDate.of(Integer.parseInt(startD[2]), Integer.parseInt(startD[0]), Integer.parseInt(startD[1]));
                //Year, month, day
                LocalDate newDateE = LocalDate.of(Integer.parseInt(endD[2]), Integer.parseInt(endD[0]), Integer.parseInt(endD[1]));

                int dayOfWeek = 0;

                while(!newDateS.isEqual(newDateE))
                {
                    for(int x=0; x<days.length; x++)
                    {
                        switch(days[x]){
                            case "M":
                                dayOfWeek = 1;
                                break;
                            case "T":
                                dayOfWeek = 2;
                                break;
                            case "W":
                                dayOfWeek = 3;
                                break;
                            case "R":
                                dayOfWeek = 4;
                                break;
                            case "F":
                                dayOfWeek = 5;
                                break;
                            case "A":
                                dayOfWeek = 6;
                                break;
                            case "S":
                                dayOfWeek = 7;
                                break;

                        }

                        if(newDateS.getDayOfWeek().getValue() == dayOfWeek)
                        {
                            myCal.addLecture(newDateS, lecture);
                        }
                    }
                    newDateS = newDateS.plusDays(1);
                }

                if (input.hasNextLine())
                    input.nextLine();
            }
            else
            {
                String[] day = thing.split("/");
                if(day[2].length() == 2)
                    day[2] = "20" + day[2];

                String startTS = input.next();
                String startT = startTS.replaceAll(":", "");
                int startTime = Integer.parseInt(startT);

                String endTS = input.next();
                String endT = endTS.replaceAll(":", "");
                int endTime = Integer.parseInt(endT);

                timePeriod = new TimePeriod(startTime, endTime, startTS, endTS);

                Curriculum curriculum = new Curriculum(eventName, timePeriod, false);

                LocalDate newDate = LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[0]), Integer.parseInt(day[1]));

                myCal.addLecture(newDate, curriculum);

                if (input.hasNextLine())
                    input.nextLine();
            }
        }
        System.out.println("Welcome to the curriculum calendar! \n");
        input.close();
    }
}
