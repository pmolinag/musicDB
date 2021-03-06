USE `music-db`;

DROP TABLE IF EXISTS `disc`;

CREATE TABLE `disc`
(
    `id`        INT(11)      NOT NULL AUTO_INCREMENT,
    `title`     VARCHAR(255) NOT NULL,
    `artist_id` INT(11),
    CONSTRAINT disc_pk PRIMARY KEY (`id`),
    CONSTRAINT artist_id_fk FOREIGN KEY (`artist_id`) REFERENCES artist (`id`),
    CONSTRAINT disc_title_un UNIQUE (`title`, `artist_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
