use music-db;

DROP TABLE IF EXISTS artist;

CREATE TABLE artist
(
    id       int(11) NOT NULL AUTO_INCREMENT,
    first_name    varchar(255),
    second_name    varchar(255),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


DROP TABLE IF EXISTS discs;

CREATE TABLE discs
(
    id          int(11) NOT NULL AUTO_INCREMENT,
    artist_id   int(11),
    PRIMARY KEY (id),
    CONSTRAINT artist_id_fk FOREIGN KEY (artist_id) REFERENCES artist(id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

  INSERT INTO artist VALUES (1, 'Pablo', 'Molina');
  INSERT INTO artist VALUES (2, 'Pepe', 'Habichuela');

  INSERT INTO discs VALUES (1, 1);
  INSERT INTO discs VALUES (2, 2);

