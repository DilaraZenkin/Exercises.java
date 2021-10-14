-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
SELECT DISTINCT person_name, birthday
FROM movie_actor
JOIN person ON movie_actor.actor_id = person.person_id
JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE release_date >= '1985-01-01' AND release_date <= '1985-12-31' AND birthday>='1950-01-01' AND birthday <='1959-12-31';
;