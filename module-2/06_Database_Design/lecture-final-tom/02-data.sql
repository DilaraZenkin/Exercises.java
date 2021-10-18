-- data.sql
-- DML: Data Manipulation Language

INSERT INTO customer VALUES (DEFAULT, 'Elizabeth', 'Jackson', '123 - 4th Avenue, Fonthill, ON, L3J 4S4', 2062846783);

INSERT INTO artist VALUES (3, 'Carol Channing'), (15, 'Dennis Frings');

INSERT INTO painting VALUES (DEFAULT, 'Laugh With Teeth', 3);
INSERT INTO painting VALUES (DEFAULT, 'South toward Emerald Sea', 15);
INSERT INTO painting VALUES (DEFAULT, 'At the Movies', 3);

INSERT INTO purchase VALUES ('7000.00', '2000-09-17', 1, 1);
INSERT INTO purchase VALUES ('1800.00', '2000-05-11', 1, 2);
INSERT INTO purchase VALUES ('5550.00', '2002-02-14', 1, 3);
INSERT INTO purchase VALUES ('2200.00', '2003-07-15', 1, 2);
