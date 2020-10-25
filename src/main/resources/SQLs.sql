CREATE TABLE Film(
	id INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Director(
	id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Film_director(
	film_id INT(11) NOT NULL,
    director_id int(11) not null,
    PRIMARY KEY (film_id, director_id),
    CONSTRAINT fk_film_id FOREIGN KEY (film_id) REFERENCES Film(id),
    CONSTRAINT fk_director_id FOREIGN KEY (director_id) REFERENCES director(id)
);

CREATE TABLE FilmDetail(
	id INT(11) NOT NULL AUTO_INCREMENT,
    storyline VARCHAR(255),
	genre VARCHAR(255),
    film_id INT(11),
    PRIMARY KEY (id),
    CONSTRAINT fk_film_filmdetail_id FOREIGN KEY (film_id) REFERENCES Film(id)
);

SELECT * FROM Film;
SELECT * FROM FilmDetail;
SELECT * FROM Director;
SELECT * FROM Film_director;