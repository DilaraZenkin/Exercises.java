package com.techelevator.dao;

import com.techelevator.model.Actor;
import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> searchFor(String searchTerm);
    List<Movie> moviesStarring(Actor actor);
}
