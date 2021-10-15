-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
--
SELECT DISTINCT g.genre_name
FROM genre g
JOIN movie_genre mg ON mg.genre_id = g.genre_id
JOIN movie m ON m.movie_id = mg.movie_id
JOIN movie_actor ma ON m.movie_id = ma.movie_id
JOIN person p ON p.person_id = ma.actor_id
WHERE p.person_name = 'Robert De Niro' AND m.release_date >= '2010-01-01'
;


--JOIN movie_genre mg ON m.movie_id = mg.movie_id
--JOIN genre g ON g.genre_id = mg.genre_id
--JOIN person p ON m.director_id = p.person_id
--JOIN movie_actor ma ON p.person_id = ma.actor_id
--WHERE p.person_name = 'Robert De Niro' AND m.release_date >= '2010-01-01'
--;

--FROM genre
--JOIN movie_genre USING(genre_id)
--JOIN movie USING(movie_id)
--JOIN movie_actor USING(movie_id)
--JOIN person ON movie_actor.actor_id = person.person_id
--WHERE person_name = 'Robert De Niro'
--ORDER BY release_date >= 2010;



