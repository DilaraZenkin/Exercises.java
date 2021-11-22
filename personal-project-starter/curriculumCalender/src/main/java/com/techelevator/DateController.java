package com.techelevator;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

public class DateController {
    private HashMap<LocalDate, ArrayList<Curriculum>> myCont;
    private LocalDate currentDate;


    public DateController(LocalDate cd)
    {
        myCont = new HashMap<LocalDate, ArrayList<Curriculum>>();
        currentDate = cd;
    }

    // Prints a calendar in month view with the given LocalDate
    //and highlights all day's that have an lecture
    //as well as the current day
    public void printCalendar(LocalDate c)
    {
        LocalDate beginning = LocalDate.of(c.getYear(), c.getMonth(), 1);
        String firstDayString = beginning.getDayOfWeek().toString();

        int firstDayInt = 0;
        switch(firstDayString){
            case "SUNDAY":
                firstDayInt = 1;
                break;
            case "MONDAY":
                firstDayInt = 2;
                break;
            case "TUESDAY":
                firstDayInt = 3;
                break;
            case "WEDNESDAY":
                firstDayInt = 4;
                break;
            case "THURSDAY":
                firstDayInt = 5;
                break;
            case "FRIDAY":
                firstDayInt = 6;
                break;
            case "SATURDAY":
                firstDayInt = 7;
                break;
        }

        System.out.println("             " + c.getMonth() + " " + c.getYear());
        System.out.println(" Su    Mo    Tu    We    Th    Fr    Sa");

        int weekday = 0;
        //Print proper spaces for first day
        for (int firstDaySpaces=1; firstDaySpaces<firstDayInt; firstDaySpaces++)
        {
            System.out.print("      ");
            weekday++;
        }

        LocalDate today = LocalDate.now();

        for (int day=1; day<=c.lengthOfMonth(); day++)
        {
            if ((day == today.getDayOfMonth() && c.getMonthValue() == today.getMonthValue() && c.getYear() == today.getYear())
                    || myCont.containsKey(beginning))
            {
                if (day<10)
                    System.out.print(" (" + day + ")");
                else
                    System.out.print("(" + day + ")");
                weekday++;
                if(weekday%7 == 0)
                    System.out.println();
                else
                    System.out.print("  ");
            }
            else
            {
                if (day<10)
                    System.out.print("  " + day);
                else
                    System.out.print(" " + day);
                weekday++;
                if(weekday%7 == 0)
                    System.out.println();
                else
                    System.out.print("   ");
            }

            beginning = beginning.plusDays(1);
        }

        System.out.println("\n");
    }


    public void addLecture(LocalDate d, Curriculum e)
    {
        if(myCont.containsKey(d))
        {
            ArrayList<Curriculum> curriculum = myCont.get(d);
            curriculum.add(e);
            myCont.put(d, curriculum);
        }
        else
        {
            ArrayList<Curriculum> curriculum = new ArrayList<Curriculum>();
            curriculum.add(e);
            myCont.put(d, curriculum);
        }
    }
    //Find an lecture from the given name and date
    public Curriculum findLecture(LocalDate d, String name)
    {
        Curriculum curriculum = null;
        if(!myCont.containsKey(d))
            return curriculum;

        ArrayList<Curriculum> events = myCont.get(d);
        for(Curriculum ev : events)
        {
            if(name.equals(ev.getName()))
                curriculum = ev;
        }
        return curriculum;
    }
    //Returns a String of all the lectures in the given LocalDate in a formatted order

    public String getLecture(LocalDate c)
    {
        String curriculumList = "";

        if(!myCont.containsKey(c))
            curriculumList = "No lectures listed!";
        else
        {
            sortLecturesInOrderByTime(myCont.get(c));
            ArrayList<Curriculum> curriculum = myCont.get(c);

            for(Curriculum e : curriculum)
            {
                curriculumList = curriculumList + "  " + e.getName() + " | " +
                        e.getTimeInterval().startPrint() + " - " +
                        e.getTimeInterval().endPrint() + "\n";
            }
        }

        return curriculumList;
    }

    public boolean removeOneTimeAddLectureSpecific(LocalDate d, Curriculum c)
    {
        boolean removed = false;
        if(myCont.containsKey(d))
        {
            ArrayList<Curriculum> curriculum = myCont.get(d);
            Curriculum cr = findLecture(d, c.getName());
            if(!cr.getIsRegular())
                curriculum.remove(c);
            myCont.put(d, curriculum);

            if(curriculum.isEmpty())
                myCont.remove(d);

            removed = true;
        }
        return removed;
    }


    public boolean removeOneTimeLectureAll(LocalDate d)
    {
        boolean removed = false;
        if(myCont.containsKey(d))
        {
            ArrayList<Curriculum> curriculum = myCont.get(d);

            java.util.Iterator<Curriculum> itr = curriculum.iterator();
            while(itr.hasNext())
            {
                Curriculum cr = itr.next();
                if(!cr.getIsRegular())
                    itr.remove();
            }

            myCont.put(d, curriculum);

            if(curriculum.isEmpty())
                myCont.remove(d);

            removed = true;
        }

        return removed;
    }


    public boolean removeRegularLecture(LocalDate d, Curriculum cr)
    {
        boolean removed = false;
        if(myCont.containsKey(d))
        {
            ArrayList<Curriculum> curriculum = myCont.get(d);

            if(cr.getIsRegular())
                curriculum.remove(cr);
            myCont.put(d, curriculum);

            if(curriculum.isEmpty())
                myCont.remove(d);

            removed = true;
        }

        return removed;
    }


    //Return the current day
    public LocalDate currentDay()
    {
        return currentDate;
    }


    //Move one day back from the current

    public LocalDate previousDay()
    {
        return currentDate = currentDate.minusDays(1);
    }


    // Move one day forward from the current
    public LocalDate nextDay()
    {
        return currentDate = currentDate.plusDays(1);
    }


    //Move one month back from the current
    public LocalDate previousMonth()
    {
        return currentDate = currentDate.minusMonths(1);
    }


    // Move one month forward from the current

    public LocalDate nextMonth()
    {
        return currentDate = currentDate.plusMonths(1);
    }







    //Get the ArrayList of events, loop through,
    //and check if any overlap with the given event
    public boolean timeOverlapCheck(LocalDate d, Curriculum c)
    {
        boolean overlap = false;
        if(myCont.containsKey(d))
        {
            ArrayList<Curriculum> curriculum = myCont.get(d);
            for(Curriculum cr : curriculum)
            {
                if(cr.getTimeInterval().overlap(c))
                    overlap = true;
            }
        }
        return overlap;
    }
    //Sorts the ArrayList of events in descending order by time using the
    // Comparator interface, and comparing the start times
    public void sortLecturesInOrderByTime(ArrayList<Curriculum> curriculum)
    {
        class sortEventsByTime implements Comparator<Curriculum>
        {
            public int compare(Curriculum c1, Curriculum c2)
            {
                int lecture1 = c1.getTimeInterval().getStart();
                int lecture2 = c2.getTimeInterval().getStart();
                return Integer.compare(lecture1, lecture2 );
            }
        }

        Collections.sort(curriculum, new sortEventsByTime());
    }





    //Returns a String of all the regular events in the given

    public String getRegLectures(LocalDate c)
    {
        String curriculumList = "";

        if(!myCont.containsKey(c))
            curriculumList = "No lectures listed!";
        else
        {
            sortLecturesInOrderByTime(myCont.get(c));
            ArrayList<Curriculum> lectures= myCont.get(c);

            for(Curriculum cr : lectures)
            {
                if(cr.getIsRegular())
                {
                    curriculumList = curriculumList + "  " + cr.getName() + " | " +
                            cr.getTimeInterval().startPrint() + " - " +
                            cr.getTimeInterval().endPrint() + "\n";
                }

            }
        }

        return curriculumList;
    }


    // Returns a String of all the events in the myCal HashMap

    public String getLectureListAll()
    {
        String curriculumList = new String();
        TreeMap<LocalDate, ArrayList<Curriculum>> sortedMyCal = new TreeMap<>();
        sortedMyCal.putAll(myCont);

        for(LocalDate day : sortedMyCal.keySet())
        {
            ArrayList<Curriculum> lectures = myCont.get(day);

            if (!curriculumList.contains(Integer.toString(day.getYear())))
                curriculumList = curriculumList + day.getYear() + "\n";

            curriculumList = curriculumList + "  " + day.getMonth() + "\n";

            curriculumList = curriculumList + "    " + day.getDayOfMonth() + " " + day.getDayOfWeek() + "\n";

            sortLecturesInOrderByTime(lectures);
            for(Curriculum cr : lectures)
            {
                curriculumList = curriculumList + "      " + cr.getName() + " | " +
                        cr.getTimeInterval().startPrint() + " - " +
                        cr.getTimeInterval().endPrint() + "\n";
            }
        }

        return curriculumList;
    }



    // Prints the output in a formatted order to the PrintWriter object
    //User must [Q]uit the program to obtain output

    public void printOutput(PrintWriter out)
    {
        String lectureList = new String();
        TreeMap<LocalDate, ArrayList<Curriculum>> sortedMyCal = new TreeMap<>();
        sortedMyCal.putAll(myCont);

        for(LocalDate day : sortedMyCal.keySet())
        {
            ArrayList<Curriculum> curriculum = myCont.get(day);

            if (!lectureList.contains(Integer.toString(day.getYear())))
            {
                lectureList = lectureList + day.getYear() + "\n";
                out.println(day.getYear());
            }

            lectureList = lectureList + "  " + day.getMonth() + "\n";
            out.println("  " + day.getMonth());

            lectureList = lectureList + "    " + day.getDayOfMonth() + " " + day.getDayOfWeek() + "\n";
            out.println("    " + day.getDayOfMonth() + " " + day.getDayOfWeek());

            sortLecturesInOrderByTime(curriculum);
            for(Curriculum e : curriculum)
            {
                lectureList = lectureList + "      " + e.getName() + " | " +
                        e.getTimeInterval().startPrint() + " - " +
                        e.getTimeInterval().endPrint() + "\n";
                out.println("      " + e.getName() + " | " +
                        e.getTimeInterval().startPrint() + " - " +
                        e.getTimeInterval().endPrint());
            }
        }
    }
}
