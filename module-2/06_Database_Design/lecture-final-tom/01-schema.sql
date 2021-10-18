-- schema.sql
-- DDL: Data Definition Language

-- Idempotent / Deterministic
DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS painting;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  customer_id serial,
  customer_first_name varchar(50) NOT NULL,
  customer_last_name varchar(50) NOT NULL,
  address varchar(100) NOT NULL,
  phone int NULL,
  CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

CREATE TABLE artist (
  artist_id serial PRIMARY KEY,
  artist_name varchar(250) NOT NULL
);

CREATE TABLE painting (
  painting_id serial,
  title varchar(250) NOT NULL,
  artist_id int NULL, 

  CONSTRAINT pk_painting PRIMARY KEY (painting_id),
  CONSTRAINT fk_painting_artist FOREIGN KEY (artist_id) REFERENCES artist (artist_id)
);

-- Association Table
CREATE TABLE purchase (
  price money NOT NULL,
  purchase_date timestamp NOT NULL,
  customer_id int NOT NULL,
  painting_id int NOT NULL,

  CONSTRAINT pk_purchase PRIMARY KEY (customer_id, painting_id, purchase_date), -- compound key, natural key 
  CONSTRAINT fk_purchase_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
  CONSTRAINT fk_purchase_painting FOREIGN KEY (painting_id) REFERENCES painting (painting_id)
);
