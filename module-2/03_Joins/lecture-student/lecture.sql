-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation
FROM city
WHERE city_name= 'Columbus'
;

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city.city_name, state.state_name
FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation
;

SELECT city.city_name, state.state_name
FROM state INNER JOIN city ON  state.state_abbreviation = city.state_abbreviation
;

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation
FROM park
INNER JOIN park_state ON park.park_id = park_state.park_id
;

SELECT park.park_name, state.state_abbreviation
FROM park
INNER JOIN park_state ON park.park_id = park_state.park_id
INNER JOIN state ON park_state.state_abbreviation = state.state_abbreviation
;



-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name
FROM park
JOIN park_state USING(park_id)
JOIN state USING(state_abbreviation);

-- Modify the previous query to include the name of the state's capital city.
SELECT park.park_name, state.state_abbreviation, city.city_name AS capital
FROM park
INNER JOIN park_state ON park.park_id = park_state.park_id
INNER JOIN state ON park_state.state_abbreviation = state.state_abbreviation
INNER JOIN city ON state.capital = city.city_id
;

-- Modify the previous query to include the area of each park.
SELECT park.park_name, state.state_abbreviation, city.city_name AS capital
FROM park
INNER JOIN park_state ON park.park_id = park_state.park_id
INNER JOIN state ON park_state.state_abbreviation = state.state_abbreviation
INNER JOIN city ON state.capital = city.city_id
;

SELECT *
FROM park
INNER JOIN park_state USING (park_id)
INNER JOIN state uSING(state_abbreviation)
;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT *
FROM city INNER JOIN state USING(state_abbreviation);

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.


-- Modify the previous query to sort the results by the number of cities in descending order.



-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT state_abbreviation, MIN(date_established)
FROM park
INNER JOIN park_state USING(park_id)
GROUP BY state_abbreviation
ORDER BY state_abbreviation
;

-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.



-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)


-- Modify the previous query to include a column that indicates whether the place is a city or state.



-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in DbVisualizer and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies
SELECT person_name
FROM person
WHERE person_name = 'Tom Hanks'
;
SELECT title, release_date, person_name
FROM movie
JOIN person ON movie.director_id = person.person_id

WHERE person_name = 'Tom Hanks'
;
SELECT title, release_date, person_name
FROM movie
JOIN person ON  person.person_id = movie.director_id


WHERE person_name = 'Tom Hanks'
;

SELECT *
FROM movie;
;

SELECT *
FROM movie;
;
SELECT person_name, birthday, release_date
FROM movie_actor
JOIN person ON movie_actor.actor_id = person.person_id
JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE release_date >= '1985-01-01' AND release_date <= '1985-12-31' AND birthday>='1950-01-01' AND birthday <='1959-12-31'
;

SELECT title, tagline, genre_name
FROM movie
JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
JOIN movie_genre ON movie_genre.movie_id = movie.movie_id
JOIN genre ON genre.genre_id = movie_genre.genre_id
WHERE genre_name = 'Family' AND person_name = 'Samuel L. Jackson';

