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
	('___', 9500),
	('___', 9000),
	('___', 8500),
	('___', 8000),
	('___', 7500),
	('___', 7000),
	('___', 6500),
	('___', 6000),
	('___', 5500),
	('___', 5000)
;
	
SELECT * FROM score;

