-- Drop tables

DROP TABLE IF EXISTS composer, genre, collection, genre_piece, composer_piece, piece;

-- **********************
-- CREATE DATABASE TABLES
-- **********************

-- Create collection Table
CREATE TABLE collection (
	collection_id serial NOT NULL,
	collection_name VARCHAR (100),
	CONSTRAINT PK_collection PRIMARY KEY (collection_id)
);

-- Create piece Table
CREATE TABLE piece (
	piece_id serial NOT NULL,
    collection_id integer,
    piece_name VARCHAR (100) NOT NULL,
    published_year integer,
    CONSTRAINT PK_piece PRIMARY KEY (piece_id),
	CONSTRAINT FK_collection FOREIGN KEY (collection_id) REFERENCES collection (collection_id)
);

-- Create genre Table
CREATE TABLE genre (
	genre_id serial NOT NULL,
    genre_name VARCHAR (100) NOT NULL,
    CONSTRAINT PK_genre PRIMARY KEY (genre_id)
);

-- Create composer Table
CREATE TABLE composer (
	composer_id serial NOT NULL,
    composer_name VARCHAR (200) NOT NULL,
    birthday date NOT NULL,
    deathday date,
    home_page VARCHAR (300),
    CONSTRAINT PK_composer PRIMARY KEY (composer_id)
);

-- Create composer_piece table
CREATE TABLE composer_piece (
	composer_id integer NOT NULL,
    piece_id integer NOT NULL,
	CONSTRAINT FK_composer FOREIGN KEY (composer_id) REFERENCES composer (composer_id),
	CONSTRAINT FK_piece FOREIGN KEY (piece_id) REFERENCES piece (piece_id)
);

-- Create genre_piece table
CREATE TABLE genre_piece (
	genre_id integer NOT NULL,
    piece_id integer NOT NULL,
	CONSTRAINT FK_genre FOREIGN KEY (genre_id) REFERENCES genre (genre_id),
	CONSTRAINT FK_piece FOREIGN KEY (piece_id) REFERENCES piece (piece_id)
);

-- **********************
-- POPULATE TABLES
-- **********************

-- Populate collection table
INSERT INTO collection (collection_name)
VALUES 
	('Evanescence'), 
	('Solo Piano'),
	('Final Fantasy Music'),
	('Kingdom Hearts Music');
	
-- Populate piece table
INSERT INTO piece (collection_id, piece_name, published_year)
VALUES 
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'Moonlight Sonata', 1801),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'Fur Elise', 1810),
	((SELECT collection_id FROM collection WHERE collection_name = 'Final Fantasy Music'), 'Tifa Theme', 1997),
	((SELECT collection_id FROM collection WHERE collection_name = 'Final Fantasy Music'), 'A Place to Call Home', 2000),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'My Imortal', 2003),
	
	
	



