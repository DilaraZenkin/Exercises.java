package com.techelevator;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.JdbcActorDao;
import com.techelevator.dao.JdbcMovieDao;
import com.techelevator.dao.MovieDao;
import com.techelevator.model.Actor;
import com.techelevator.model.Movie;

import java.util.List;
import java.util.Scanner;

public class MovieApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        MovieDao movieDAO = new JdbcMovieDao();
        ActorDao actorDAO = new JdbcActorDao();

//        System.out.print("Enter name of movie >>> ");
//        String searchTerm = keyboard.nextLine();
//
//        List<Movie> results = dao.searchFor(searchTerm);
//        for (Movie m : results) {
//            System.out.println(m);
//        }

        System.out.print("Enter actor name >>> ");
        String actorSearchTerm = keyboard.nextLine();

        List<Actor> actors = actorDAO.searchFor(actorSearchTerm);
        for (Actor actor : actors) {
            System.out.println("===========");
            System.out.println(actor + " was in the following movies: ");
            List<Movie> results = movieDAO.moviesStarring(actor);
            for (Movie m : results) {
                System.out.println(m);
            }
            System.out.println("===========\n");
        }
    }
}
