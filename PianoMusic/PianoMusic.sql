-- Drop tables

DROP TABLE IF EXISTS composer, genre, collection, genre_piece, composer_piece, piece;

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





-- CREATE TABLE IF NOT EXISTS public."composer "
-- (
--     composer_id serial NOT NULL,
--     composer_name character varying NOT NULL,
--     birthday date NOT NULL,
--     deathday date,
--     home_page character varying,
--     PRIMARY KEY (composer_id)
-- );


-- CREATE TABLE IF NOT EXISTS public.collection
-- (
--     collection_id serial NOT NULL,
--     collection_name character varying NOT NULL,
--     PRIMARY KEY (collection_id)
-- );

-- CREATE TABLE IF NOT EXISTS public.genre
-- (
--     genre_id serial NOT NULL,
--     genre_name character varying NOT NULL,
--     PRIMARY KEY (genre_id)
-- );

-- CREATE TABLE IF NOT EXISTS public.composer_piece
-- (
--     composer_id integer NOT NULL,
--     piece_id integer NOT NULL
-- );

-- CREATE TABLE IF NOT EXISTS public.genre_piece
-- (
--     genre_id integer NOT NULL,
--     piece_id integer NOT NULL
-- );

-- ALTER TABLE IF EXISTS public.piece
--     ADD CONSTRAINT "collection_id FK" FOREIGN KEY (collection_id)
--     REFERENCES public.collection (collection_id) MATCH SIMPLE
--     ON UPDATE NO ACTION
--     ON DELETE NO ACTION
--     NOT VALID;


-- ALTER TABLE IF EXISTS public.composer_piece
--     ADD CONSTRAINT "piece_id FK" FOREIGN KEY (piece_id)
--     REFERENCES public.piece (piece_id) MATCH SIMPLE
--     ON UPDATE NO ACTION
--     ON DELETE NO ACTION
--     NOT VALID;


-- ALTER TABLE IF EXISTS public.composer_piece
--     ADD CONSTRAINT "composer_id FK" FOREIGN KEY (composer_id)
--     REFERENCES public."composer " (composer_id) MATCH SIMPLE
--     ON UPDATE NO ACTION
--     ON DELETE NO ACTION
--     NOT VALID;


-- ALTER TABLE IF EXISTS public.genre_piece
--     ADD CONSTRAINT genre_id FOREIGN KEY (genre_id)
--     REFERENCES public.genre (genre_id) MATCH SIMPLE
--     ON UPDATE NO ACTION
--     ON DELETE NO ACTION
--     NOT VALID;


-- ALTER TABLE IF EXISTS public.genre_piece
--     ADD CONSTRAINT piece_id FOREIGN KEY (piece_id)
--     REFERENCES public.piece (piece_id) MATCH SIMPLE
--     ON UPDATE NO ACTION
--     ON DELETE NO ACTION
--     NOT VALID;

-- END;