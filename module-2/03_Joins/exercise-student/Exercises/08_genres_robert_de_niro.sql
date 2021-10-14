-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
--SELECT genre_name
--FROM genre
--JOIN movie_genre USING(genre_id)
--JOIN movie USING(movie_id)
--JOIN movie_actor USING(movie_id)
--JOIN person ON movie_actor.actor_id = person.person_id
--WHERE person_name = 'Robert De Niro'
--ORDER BY release_date >= 2010;



