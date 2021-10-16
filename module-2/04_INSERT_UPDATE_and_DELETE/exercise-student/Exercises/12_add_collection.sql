-- 12. Create a "Bill Murray Collection" in the collection table.
--For the movies that have Bill Murray in them, set their collection
 --ID to the "Bill Murray Collection". (1 row, 6 rows)

 INSERT INTO collection
 VALUES(85858585, 'Bill Murray Collection');

 UPDATE movie
 SET collection_id = 85858585
 WHERE movie_id = 399174;

 UPDATE movie
 SET collection_id = 85858585
 WHERE movie_id = 10315;

 UPDATE movie
 SET collection_id = 85858585
 WHERE movie_id = 120467;

 UPDATE movie
 SET collection_id = 85858585
 WHERE movie_id = 83666;

 UPDATE movie
  SET collection_id = 85858585
  WHERE movie_id = 137;

  UPDATE movie
  SET collection_id = 85858585
  WHERE movie_id = 10433;



