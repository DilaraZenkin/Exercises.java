package com.techelevator.model;

import java.time.LocalDate;

// Domain Object
//   (representation, in Java, of the data you care about in the database table)
public class Movie {
    private String title;
    private String tagline;
    private LocalDate releaseDate;

    public Movie() { }

    public Movie(String title, String tagline, LocalDate releaseDate) {
        this.title = title;
        this.tagline = tagline;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return releaseDate + "\t" + title + (tagline == null || tagline.isEmpty() ? "" : " -- " + tagline);
    }
}
