package com.techelevator.dao;

import com.techelevator.model.Actor;
import com.techelevator.model.Movie;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao extends JdbcMovieDB implements MovieDao {

    @Override
    public List<Movie> searchFor(String searchTerm) {
        String sql = "SELECT title, tagline, release_date " +
                     "FROM movie " +
                     "WHERE title ILIKE ?";

        SqlRowSet searchResultsRowSet = jdbcTemplate.queryForRowSet(sql, "%" + searchTerm + "%");
        List<Movie> resultsList = new ArrayList<>();

        while (searchResultsRowSet.next()) {
            String thisMovieTitle = searchResultsRowSet.getString("title");
            String thisMovieTagline = searchResultsRowSet.getString("tagline");
            LocalDate thisMovieReleaseDate = searchResultsRowSet.getDate("release_date").toLocalDate();

            Movie thisMovie = new Movie(thisMovieTitle, thisMovieTagline, thisMovieReleaseDate);
            resultsList.add(thisMovie);
        }
        return resultsList;
    }

    @Override
    public List<Movie> moviesStarring(Actor actor) {
        String sql = "SELECT title, tagline, release_date " +
                     "FROM movie " +
                     "JOIN movie_actor USING(movie_id) " +
                     "JOIN person ON person.person_id = movie_actor.actor_id " +
                     "WHERE person_name = ?";

        SqlRowSet moviesRowSet = jdbcTemplate.queryForRowSet(sql, actor.getName());
        List<Movie> results = new ArrayList<>();
        while (moviesRowSet.next()) {
            Movie m = new Movie();
            m.setTitle(moviesRowSet.getString("title"));
            m.setTagline(moviesRowSet.getString("tagline"));
            m.setReleaseDate(moviesRowSet.getDate("release_date").toLocalDate());
            results.add(m);
        }
        return results;
    }
}
