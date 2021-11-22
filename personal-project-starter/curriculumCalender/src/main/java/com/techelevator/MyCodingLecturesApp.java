package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MyCodingLecturesApp {
    public static void main(String[] args) throws IOException
    {
        LocalDate today = LocalDate.now();
        DateController myCal = new DateController(today);

        myCal.printCalendar(myCal.currentDay());

        LecturesFileController file = new LecturesFileController("lectures.txt");
        file.fileReader(myCal);

        Scanner input = new Scanner(System.in);

        System.out.print("Select one of the following options: \n" +
                "[V]iew   [C]reate   [L]ecture list   [D]elete    [Q]uit \n");

        String choice = input.next();
        String choiceTwo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");

        while (!choice.equalsIgnoreCase("Q"))
        {
            switch(choice.toUpperCase()){
                case "V":
                    System.out.println("[D]ay view or [M]view ?");
                    choiceTwo = input.next();

                    while(!choiceTwo.equalsIgnoreCase("G"))
                    {
                        switch(choiceTwo.toUpperCase()){
                            case "D":
                                System.out.println(formatter.format(myCal.currentDay()));
                                System.out.println(myCal.getLecture(myCal.currentDay()));
                                System.out.println("[P]revious or [N]ext or [G]o back to main menu ?");
                                choiceTwo = input.next();

                                while(!choiceTwo.equalsIgnoreCase("G"))
                                {
                                    switch(choiceTwo.toUpperCase()){
                                        case "P":
                                            myCal.previousDay();
                                            System.out.println(formatter.format(myCal.currentDay()));
                                            System.out.println(myCal.getLecture(myCal.currentDay()));
                                            break;
                                        case "N":
                                            myCal.nextDay();
                                            System.out.println(formatter.format(myCal.currentDay()));
                                            System.out.println(myCal.getLecture(myCal.currentDay()));
                                            break;
                                    }
                                    System.out.println("[P]revious or [N]ext or [G]o back to main menu ?");
                                    choiceTwo = input.next();
                                }
                                break;
                            case "M":
                                myCal.printCalendar(myCal.currentDay());
                                System.out.println("[P]revious or [N]ext or [G]o back to main menu ?");
                                choiceTwo = input.next();

                                while(!choiceTwo.equalsIgnoreCase("G"))
                                {
                                    switch(choiceTwo.toUpperCase()){
                                        case "P":
                                            myCal.previousMonth();
                                            myCal.printCalendar(myCal.currentDay());
                                            break;
                                        case "N":
                                            myCal.nextMonth();
                                            myCal.printCalendar(myCal.currentDay());
                                            break;
                                    }
                                    System.out.println("[P]revious or [N]ext or [G]o back to main menu ?");
                                    choiceTwo = input.next();
                                }
                                break;
                        }
                    }
                    break;

                case "C":
                    System.out.print("Name: ");
                    input.nextLine();
                    String name = input.nextLine();

                    System.out.print("Date [mm/dd/yyyy]: ");
                    String date = input.next();
                    String[] day = date.split("/");
                    if(day[2].length() == 2)
                        day[2] = "20" + day[2];

                    System.out.print("Start [24hr]: ");
                    String start = input.next();
                    String startT = start.replaceAll(":", "");
                    int startTime = Integer.parseInt(startT);

                    System.out.print("End [24hr]: ");
                    String end = input.next();
                    String endT = end.replaceAll(":", "");
                    int endTime = Integer.parseInt(endT);

                    TimePeriod timePeriod = new TimePeriod(startTime, endTime, start, end);
                    Curriculum event = new Curriculum(name, timePeriod, false);
                    LocalDate newDate = LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[0]), Integer.parseInt(day[1]));

                    if(!myCal.timeOverlapCheck(newDate, event))
                    {
                        myCal.addLecture(newDate, event);
                        System.out.println("Created! " + "\n"  + myCal.getLecture(newDate));
                    }
                    else
                    {
                        System.out.println("lecture not created. Time conflict. \n");
                    }
                    break;

                case "G":
                    System.out.print("Enter the date to go to [mm/dd/yyyy]: ");
                    date = input.next();
                    day = date.split("/");
                    if(day[2].length() == 2)
                        day[2] = "20" + day[2];

                    newDate = LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[0]), Integer.parseInt(day[1]));

                    System.out.println(formatter.format(newDate));
                    System.out.println(myCal.getLecture(newDate));
                    break;

                case "L":
                    System.out.println(myCal.getLectureListAll());
                    break;

                case "D":
                    System.out.print("[S]elected, [A]ll, or [DR]egular ? ");
                    choiceTwo = input.next();

                    switch(choiceTwo.toUpperCase()){
                        case "S":
                            System.out.print("Enter the date to delete one lecture [mm/dd/yyyy]: ");
                            date = input.next();
                            day = date.split("/");
                            if(day[2].length() == 2)
                                day[2] = "20" + day[2];
                            newDate = LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[0]), Integer.parseInt(day[1]));

                            System.out.println(formatter.format(newDate));
                            System.out.println(myCal.getLecture(newDate));

                            if(!myCal.getLecture(newDate).equals("No lectures listed!"))
                            {
                                System.out.print("Enter the name of the lecture to delete: ");
                                input.nextLine();
                                String name2 = input.nextLine();

                                Curriculum cr = myCal.findLecture(newDate, name2);

                                boolean removed = myCal.removeOneTimeAddLectureSpecific(newDate, cr);

                                if(removed == true)
                                {
                                    System.out.println("The lecture is deleted. Here is the current scheduled lecture: ");
                                    System.out.println(formatter.format(newDate));
                                    System.out.println(myCal.getLecture(newDate));
                                }
                                else
                                    System.out.println("The lecture was not deleted.");
                            }
                            break;

                        case "A":
                            System.out.print("Enter the date to delete all lectures [mm/dd/yyyy]: ");
                            date = input.next();
                            day = date.split("/");
                            if(day[2].length() == 2)
                                day[2] = "20" + day[2];
                            newDate = LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[0]), Integer.parseInt(day[1]));

                            boolean removed2 = myCal.removeOneTimeLectureAll(newDate);
                            if(removed2 == true)
                            {
                                System.out.println("The non-regular lectures are deleted: ");
                                System.out.println(formatter.format(newDate));
                                System.out.println(myCal.getLecture(newDate));
                            }
                            else
                                System.out.println("The lectures were not deleted.");
                            break;

                        case "DR":
                            System.out.print("Enter the date to delete reg lecture [mm/dd/yyyy]: ");
                            date = input.next();
                            day = date.split("/");
                            if(day[2].length() == 2)
                                day[2] = "20" + day[2];
                            newDate = LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[0]), Integer.parseInt(day[1]));

                            System.out.println(formatter.format(newDate));
                            System.out.println(myCal.getRegLectures(newDate));

                            if(!myCal.getRegLectures(newDate).equals(""))
                            {
                                System.out.print("Enter the name of the regular lecture to delete: ");
                                input.nextLine();
                                name = input.nextLine();

                                Curriculum e = myCal.findLecture(newDate, name);

                                boolean removed3 = myCal.removeRegularLecture(newDate, e);
                                if(removed3 == true)
                                {
                                    System.out.print("The lecture is deleted. Here are the current scheduled lecture: ");
                                    System.out.println(formatter.format(newDate));
                                    System.out.println(myCal.getLecture(newDate));
                                }
                                else
                                    System.out.println("The lecture was not deleted.");
                            }
                            else
                                System.out.print("No Regular lecture!");
                            break;
                    }

                    break;

                default:
                    if(!choice.equalsIgnoreCase("Q"))
                        System.out.println("Invalid, please try again");
                    break;
            }

            System.out.print("Select one of the following options: \n" +
                    "[V]iew  [C]reate   [L]ecture list   [D]elete   [Q]uit \n");
            choice = input.next();
        }


        System.out.println("Good Bye!");
        input.close();

        PrintWriter out = new PrintWriter(new File("lectures.txt"), "UTF-8");
        myCal.printOutput(out);
        out.close();

    }
}
