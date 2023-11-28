-- Drop tables

DROP TABLE IF EXISTS composer, genre, collection, genre_piece, composer_piece, piece;

-- **********************
-- CREATE DATABASE TABLES
-- **********************

-- Create Collection Table
CREATE TABLE collection (
	collection_id serial NOT NULL,
	collection_name VARCHAR (100),
	CONSTRAINT PK_collection PRIMARY KEY (collection_id)
);

-- Create Piece Table
CREATE TABLE piece (
	piece_id serial NOT NULL,
    collection_id integer,
    piece_name VARCHAR (100) NOT NULL,
    published_year integer,
    CONSTRAINT PK_piece PRIMARY KEY (piece_id),
	CONSTRAINT FK_collection FOREIGN KEY (collection_id) REFERENCES collection (collection_id)
);

-- Create Genre Table
CREATE TABLE genre (
	genre_id serial NOT NULL,
    genre_name VARCHAR (100) NOT NULL,
    CONSTRAINT PK_genre PRIMARY KEY (genre_id)
);

-- Create Composer Table
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



