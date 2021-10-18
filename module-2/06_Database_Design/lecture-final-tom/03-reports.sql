-- Gill Art Gallery Report:
SELECT 
c.customer_last_name || ', ' || c.customer_first_name AS customer, 
a.artist_id || ' - ' || a.artist_name AS artist, 
pa.title, DATE(p.purchase_date), p.price
FROM customer c
INNER JOIN purchase p USING(customer_id)
INNER JOIN painting pa USING(painting_id)
INNER JOIN artist a USING(artist_id);

-- Ad Hoc query: How much money has each artist made in sales?
SELECT a.artist_id, a.artist_name, SUM(p.price) AS total
FROM artist a
INNER JOIN painting pa USING(artist_id)
INNER JOIN purchase p USING(painting_id)
GROUP BY a.artist_id
ORDER BY total DESC
;

