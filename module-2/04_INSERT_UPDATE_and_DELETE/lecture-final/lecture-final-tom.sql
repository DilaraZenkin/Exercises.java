-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 0.78 square miles and does not offer camping.)
SELECT * FROM park;
INSERT INTO park (park_name, date_established, area, has_camping)
VALUES ('Disneyland', '1955-07-17', 0.78, false);

-- Add Hawkins, IN (with a population of 30,000 and an area of 14.71 square miles) and Cicely, AK (with a popuation of 839 and an area of 4.39 square miles) to the city table.
SELECT * FROM city;
INSERT INTO city VALUES (DEFAULT, 'Hawkins', 'IN', 60000, 14.71);

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
SELECT * FROM park_state;

INSERT INTO park_state (park_id, state_abbreviation) 
SELECT park_id, 'CA' AS state_abbreviation FROM park WHERE park_name = 'Disneyland';

SELECT park_id, 'CA' AS state_abbreviation FROM park WHERE park_name = 'Disneyland';


-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
SELECT * FROM state ORDER BY state_abbreviation;

UPDATE state
SET state_nickname = 'The Happiest Place on Earth.'
WHERE state_abbreviation = 'CA';

-- Increase the population of California by 1,000,000.
UPDATE state
SET population = population - 1000000
WHERE state_abbreviation = 'CA';

-- Change the capital of California to Anaheim.
UPDATE state
SET capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';

SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA';

SELECT * FROM state WHERE state_abbreviation = 'CA';
SELECT city_name, state_name FROM state JOIN city ON state.capital = city.city_id;

-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.
UPDATE state
SET population = population + 1000000,
    state_nickname = 'The Golden State',
    capital = (SELECT city_id FROM city WHERE city_name = 'Sacramento' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';



-- DELETE

-- Delete Hawkins, IN from the city table.
SELECT * FROM city WHERE city_name = 'Hawkins';
DELETE FROM city WHERE city_id = (SELECT city_id FROM city WHERE city_name = 'Hawkins');

-- Delete all cities with a population of less than 1,000 people from the city table.

DELETE FROM city WHERE population < 1000;


-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
SELECT * FROM city;
INSERT INTO city VALUES (DEFAULT, 'Gotham', 'XX', 330000000, 1000);

-- Try deleting California from the state table.
DELETE FROM state WHERE state_abbreviation = 'CA';

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.
SELECT * FROM park;
DELETE FROM park WHERE park_name = 'Disneyland';
SELECT * FROM park_state;
DELETE FROM park_state WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Disneyland');

-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
SELECT * FROM city;
INSERT INTO city (city_name, state_abbreviation) VALUES ('Smallville', 'CA');


-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city (city_name, state_abbreviation, area) VALUES ('Smallville', 'KS', 10);

-- Retrieve the new record to confirm it has been given a default, non-null value for population.
SELECT * FROM city; --WHERE city_name = 'Smallville';


-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).
SELECT * FROM state;
UPDATE state SET state_nickname = 'The Golden State' WHERE state_abbreviation = 'CA';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).
UPDATE state
SET census_region = 'Southeast'
WHERE state_abbreviation = 'FL';
SELECT DISTINCT census_region FROM state;


-- TRANSACTIONS
-- Start transaction
--   do some stuff (Inserts / Updates / Deletes, etc)
--   ...
-- COMMIT / ROLLBACK

-- Delete the record for Smallville, KS within a transaction.
SELECT * FROM city WHERE city_name = 'Smallville';
START TRANSACTION;
DELETE FROM city WHERE city_name = 'Smallville';
ROLLBACK;
COMMIT;

-- Delete all of the records from the park_state table, 
-- but then "undo" the deletion by rolling back the transaction.
SELECT * FROM park_state;
START TRANSACTION;
DELETE FROM park_state;



-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.
SELECT * FROM city;
START TRANSACTION;
UPDATE city SET state_abbreviation = 'TX';
SELECT * FROM city;
ROLLBACK;
SELECT * FROM city;

-- Demonstrate two different SQL connections trying to access the 
-- same table where one is inside of a transaction but hasn't committed yet.

SELECT city_name, state_name FROM state JOIN city ON state.capital = city.city_id;

START TRANSACTION;
UPDATE state SET capital = (SELECT city_id FROM city WHERE city_name = 'Pittsburgh');
COMMIT;

