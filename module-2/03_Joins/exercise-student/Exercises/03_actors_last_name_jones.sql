-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. Order the results by the actor names (A-Z). (48 rows)
SELECT  title, person_name
FROM movie_actor
JOIN person ON movie_actor.actor_id = person.person_id
JOIN movie USING(movie_id)
WHERE person_name LIKE '% Jones'
ORDER BY person_name ASC
;


