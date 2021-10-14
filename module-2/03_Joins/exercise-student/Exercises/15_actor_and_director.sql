-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT DISTINCT title, person_name
FROM movie
JOIN movie_actor USING(movie_id)
JOIN person ON movie.director_id = person.person_id;

