use `music-db`;

DROP TABLE IF EXISTS `discs`;

CREATE TABLE `discs`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `songs`    varchar(255),
    `artist`   varchar(255),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

--   INSERT INTO `discs` VALUES (1, null, null);
--   INSERT INTO `discs` VALUES (2, null, null);

-- TODO preguntar cual es la forma correcta

--   INSERT INTO `discs` VALUES (1, '[{"id":"1","name":"primera-cancion","duration":"5"}]', '{"id":"1","first_name":"Pablo","second_name":"Molina","discs":"null"}');
--   INSERT INTO `discs` VALUES (2, '[{"id":"2","name":"tercera-cancion","duration":"3"}]', '{"id":"2","first_name":"Pepe","second_name":"Segundo","discs":"null"}');

