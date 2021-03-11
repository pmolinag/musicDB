USE `music-db`;

DROP TABLE IF EXISTS `artist`;

CREATE TABLE `artist`
(
    `id`            INT(11)      NOT NULL AUTO_INCREMENT,
    `first_name`    VARCHAR(255) NOT NULL,
    `second_name`   VARCHAR(255) NOT NULL,
    `alias`         VARCHAR(255),
    `contact_email` VARCHAR(255) NOT NULL,
    `birth_date`    DATE         NOT NULL,
    `gender`        TINYINT(3),
    CONSTRAINT `artist_pk` PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
