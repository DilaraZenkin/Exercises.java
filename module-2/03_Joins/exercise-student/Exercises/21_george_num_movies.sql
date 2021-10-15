-- 21. For every person in the person table with the first name of "George",
--list the number of movies they've been in--include all Georges, even those that have not appeared in any movies.
--Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'
--SELECT COUNT(*) AS num_of_movies, p.person_name
--FROM movie m
--JOIN movie_actor ma ON m.movie_id = ma.movie_id
--JOIN person p ON ma.actor_id = p.person_id
--WHERE p.person_name LIKE 'George %'
--GROUP BY  p.person_name, p.person_id
--ORDER BY p.person_name
--;

SELECT person_name, COUNT(title) AS num_of_movies
FROM person p
LEFT JOIN movie_actor ma ON ma.actor_id = p.person_id
LEFT JOIN movie m USING(movie_id)
WHERE p.person_name LIKE 'George %'
GROUP BY  p.person_name, p.person_id
ORDER BY p.person_name
;



--JOIN person p ON m.director_id = p.person_id
--JOIN movie_actor ma ON ma.actor_id = p.person_id


