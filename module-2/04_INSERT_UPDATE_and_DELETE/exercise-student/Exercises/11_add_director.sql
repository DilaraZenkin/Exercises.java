-- 11. Hollywood is remaking the classic movie "The Blob" and
--doesn't have a director yet. Add yourself to the person table,
--and assign yourself as the director of "The Blob"
--(the movie is already in the movie table). (1 record each)

INSERT INTO person(person_id, person_name,birthday, deathday, biography, profile_path, home_page)
VALUES(199191, 'Dilara', null, null,null,null,null);
UPDATE movie
SET director_id = 199191
WHERE title = 'The Blob';

