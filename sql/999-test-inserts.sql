USE `music-db`;

INSERT INTO artist
VALUES (1, 'Pablo', 'Molina', 'Pablito', 'pablo@gmail.com', '1996-09-12', 0);
INSERT INTO artist
VALUES (2, 'Jose Antonio', 'Carmona', 'Pepe Habichuela', 'pepito@gmail.com', '1940-02-15', 0);

INSERT INTO disc
VALUES (1, 'test disc', 1);
INSERT INTO disc
VALUES (2, 'test disc', 2);

INSERT INTO song
VALUES (1, "SUAVE", 500, NULL);
INSERT INTO song
VALUES (2, "PAINT IT BLACK", 200, NULL);

INSERT INTO concert
VALUES (1, '2021-10-24');
INSERT INTO concert
VALUES (2, '2021-10-25');

INSERT INTO concert_song
VALUES (1, 1);
INSERT INTO concert_song
VALUES (1, 2);
