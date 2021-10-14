-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population FROM state
ORDER BY population DESC
;

SELECT state_name, population FROM state
ORDER BY state_name ASC
;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region
FROM state
ORDER BY census_region DESC, state_name ASC
;


-- The biggest park by area
SELECT *
FROM park
ORDER BY area DESC
;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT *
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT *
FROM park
ORDER BY date_established ASC
;

SELECT CURRENT_DATE - date_establish, park_name
FROM park
ORDER BY date_established ASC;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviatION.
SELECT city_name || ', ' || state_abbreviation AS city_and_state
FROM city;

-- The all parks by name and date established.
SELECT park_name || ', Est: ' || date_established AS park_est FROM park;


-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT  census_region || ': ' || state_name AS region_and_state
FROM state
WHERE census_region IN ('West', 'Midwest') --ILIKE (%west)
ORDER BY census_region
;


-- AGGREGATE FUNCTIONS
--SUM, COUNT, MIN, MAX, AVG

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT * FROM state;
SELECT AVG(population) AS avarege_population FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_state_pop_west_south  FROM state WHERE census_region IN('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(city_name) FROM city WHERE population >1000000;

-- The number of state nicknames.
SELECT COUNT(state_nickname) AS nickname_count, COUNT(*) AS state_name_count FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest FROM PARK;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(city_name) FROM city
GROUP BY state_abbreviation
;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) 
FROM park
GROUP BY has_camping
;
-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population)
FROM city
--WHERE
GROUP BY state_abbreviation
ORDER BY state_abbreviation
--LIMIT 10
;
-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS SMALLEST_CITY_POP
FROM city
GROUP BY state_abbreviation
ORDER BY SMALLEST_CITY_POP DESC
;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
FROM city
OFFSET 0
LIMIT 10
;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks
SELECT  *
FROM park,
(
SELECT MIN(area) AS smallest, MAX(area) AS largest FROM park
) AS subtable
WHERE area = subtable.smallest OR area= subtable.largest 
;

-- List the capital cities for the states in the Northeast census region.

SELECT city_name || ' is not in Texas!'
FROM city
WHERE city_id IN (SELECT city_id
FROM city
WHERE state_abbreviation = 'TX')
;
SELECT population, city_name || ', ' || state_abbreviation AS name_and_state 
FROM city 
WHERE state_abbreviation IN ('PA', 'WV', 'KY', 'IN', 'MI')
ORDER BY state_abbreviation ASC, city_name ASC
;
SELECT state_name || '(' || state_nickname || ')' AS state_and_nickname
FROM state
ORDER BY state_nickname ASC
LIMIT 51;
SELECT city_name, population, area, population/area AS population_density
FROM city
WHERE  population/area>5000
ORDER BY population/area DESC
;
SELECT *
FROM state;

SELECT state_name, sales_tax
FROM state
GROUP BY state_name, sales_tax
ORDER BY sales_tax DESC
LIMIT 5;

SELECT *
FROM park;

SELECT park_name, date_established
       FROM park
       ORDER BY date_established DESC;
      
       ;
       
       SELECT has_camping, AVG(area) AS average_park_area
FROM park
WHERE has_camping = 'true'
GROUP BY has_camping
;

SELECT COUNT(city_name) AS num_cities, state_abbreviation
FROM CITY
GROUP BY state_abbreviation;

SELECT COUNT(city_name) AS num_cities, state_abbreviation
FROM city
WHERE state_abbreviation != 'DC'
GROUP BY state_abbreviation;

SELECT census_region, COUNT(census_region) AS num_states
FROM state
WHERE census_region IS NOT NULL
GROUP BY census_region
;

SELECT state_abbreviation, MAX(population) AS city_population
FROM city
GROUP BY population
ORDER BY population DESC;

SELECT *
FROM city;

SELECT state_abbreviation, MAX(population) AS city_population
FROM city
GROUP BY state_abbreviation, population
ORDER BY population DESC;

SELECT census_region, AVG(population) AS average_population, MIN(population) AS min_population, MAX(population) AS max_population
FROM state
WHERE census_region IS NOT NULL
GROUP BY census_region, POPULATION
ORDER BY population ASC;
SELECT state_abbreviation, MAX(population) AS city_population
FROM city
GROUP BY state_abbreviation, population
ORDER BY population DESC;

SELECT MAX(population)
FROM city;

SELECT *
FROM city;

SELECT  *
FROM park,
(
SELECT MIN(area) AS smallest, MAX(area) AS largest FROM park
) AS subtable
WHERE area = subtable.smallest OR area= subtable.largest 
;

SELECT state_abbreviation, MAX(population) AS city_population
FROM city
GROUP BY state_abbreviation, population;

SELECT * 
FROM city;
SELECT AVG(population) AS average_population, MIN(population) AS min_population, MAX(population) AS max_population, census_region
FROM state
WHERE census_region IS NOT NULL
GROUP BY population, census_region
;
SELECT city_name, state_abbreviation, COUNT(*) 

FROM city

GROUP BY city_name, state_abbreviation
;