use `music-db`;

DROP TABLE IF EXISTS `artist`;

CREATE TABLE `artist`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `first_name`  varchar(255),
    `second_name` varchar(255),
    CONSTRAINT artist_pk PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
