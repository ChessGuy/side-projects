Drop TABLE IF EXISTS score;

CREATE TABLE score (
	score_id serial,
	initials varchar(3),
	score int,
	CONSTRAINT pk_score PRIMARY KEY (score_id)
	);

-- DEFAULT SCORES
INSERT INTO score (initials, score) 
VALUES 
	('___', 10000),
	('___', 9000),
	('___', 8000),
	('___', 7000),
	('___', 6000),
	('___', 5000),
	('___', 4000),
	('___', 3000),
	('___', 2000),
	('___', 1000)
;
	
SELECT * FROM score;

