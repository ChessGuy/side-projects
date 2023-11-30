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
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'River Flows in You', 2011),
	((SELECT collection_id FROM collection WHERE collection_name = 'Kingdom Hearts Music'), 'Dearly Beloved', 2002),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'Piano Sonata No. 11 in A Major, K.', 1783),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'Piano Sonata No. 18 in D Major, K. ', 1789),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'Indigo', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Evanescence'), 'Your Star', 2006),
	((SELECT collection_id FROM collection WHERE collection_name = 'Kingdom Hearts Music'), 'Lazy Afternoons', 2005),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'Kai Forest', 2022),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'Room at the Bottom', 2010),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'Moonlit Shore', 2011),
	((SELECT collection_id FROM collection WHERE collection_name = 'Solo Piano'), 'The Secret Letter', 2003),
	((SELECT collection_id FROM collection WHERE collection_name = 'Final Fantasy Music'), 'Lightning Theme', 2009);
	
-- Populate genre table
INSERT INTO genre (genre_name)
VALUES 
	('Alt Rock'), 
	('Classical'),
	('Soundtrack'),
	('New Age');

-- Populate composer table
INSERT INTO composer (composer_name, birthday, deathday, home_page)
VALUES 
	('Amy Lee', '1981-12-13', NULL, 'https://amyleeofficial.com/'), 
	('Ludwig Van Beethoven', '1770-12-17', '1827-3-26', NULL), 
	('George Winston', '1949-2-11', '2023-6-4', 'https://www.georgewinston.com/'), 
	('Nobuo Uematsu', '1959-3-21', NULL, NULL), 
	('Yiruma', '1978-2-15', NULL, 'http://yiruma.com/'),
	('Wolfgang Amedeus Mozart', '1756-1-27', '1791-12-5', NULL), 
	('Yoko Shimomura', '1967-10-19', NULL, 'https://yokoshimomura.com/'), 
	('Brian Crain', '1961-8-28', NULL, 'https://www.briancrain.com/'), 
	('Masashi Hamauzu', '1971-9-10', NULL, 'http://www.masashihamauzu.com/');

-- Populate genre_piece table
INSERT INTO genre_piece (genre_id, piece_id)
VALUES 
	(1, 1),
	(2, 2),
	(2, 3),
	(3, 4),
	(3, 5),
	(4, 6),
	(3, 7),
	(2, 8),
	(2, 9),
	(4, 10),
	(1, 11),
	(3, 12),
	(4, 13),
	(4, 14),
	(4, 15),
	(4, 16),
	(3, 17);

-- Populate composer_piece table
INSERT INTO composer_piece (composer_id, piece_id)
VALUES 
	(1, 1),
	(2, 2),
	(2, 3),
	(4, 4),
	(4, 5),
	(5, 6),
	(7, 7),
	(6, 8),
	(6, 9),
	(5, 10),
	(1, 11),
	(7, 12),
	(3, 13),
	(3, 14),
	(8, 15),
	(8, 16),
	(9, 17);

-- **********************
-- SAMPLE SQL QUERIES
-- **********************

SELECT *
FROM piece
JOIN genre_piece ON piece.piece_id = genre_piece.piece_id;



