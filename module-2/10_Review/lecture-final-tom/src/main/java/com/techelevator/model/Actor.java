package com.techelevator.model;

import java.time.LocalDate;

public class Actor {

    private String name;
    private LocalDate birthday;


    public int getAge() {
        return birthday == null ? -1 : LocalDate.now().getYear() - birthday.getYear();
    }

    @Override
    public String toString() {
        if (birthday == null) {
            return name;
        }
        return name + " (born on " + birthday + ": ~" + getAge() + " years old)";
    }

    public Actor() { }

    public Actor(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
