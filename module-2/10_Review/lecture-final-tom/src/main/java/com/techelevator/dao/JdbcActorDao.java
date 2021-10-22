package com.techelevator.dao;

import com.techelevator.model.Actor;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcActorDao extends JdbcMovieDB implements ActorDao {

    @Override
    public List<Actor> searchFor(String searchTerm) {
        String sql = "SELECT DISTINCT person_name, birthday " +
                     "FROM person INNER JOIN movie_actor ON person.person_id = movie_actor.actor_id " +
                     "WHERE person_name ILIKE ?";

        SqlRowSet searchResultsRowSet = jdbcTemplate.queryForRowSet(sql, "%" + searchTerm + "%");
        List<Actor> resultsList = new ArrayList<>();

        while (searchResultsRowSet.next()) {
            String thisActorName = searchResultsRowSet.getString("person_name");

            LocalDate thisActorBirthday = null;
            if (searchResultsRowSet.getDate("birthday") != null) {
                thisActorBirthday = searchResultsRowSet.getDate("birthday").toLocalDate();
            }

            Actor thisActor = new Actor(thisActorName, thisActorBirthday);
            resultsList.add(thisActor);
        }
        return resultsList;
    }
}
