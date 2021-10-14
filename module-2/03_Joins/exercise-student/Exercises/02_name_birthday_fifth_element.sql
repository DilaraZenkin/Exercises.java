-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
SELECT person_name, birthday
FROM movie_actor
JOIN movie USING(movie_id)
JOIN person ON movie_actor.actor_id = person.person_id
WHERE title = 'The Fifth Element' ;

