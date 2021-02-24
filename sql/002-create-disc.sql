use `music-db`;

DROP TABLE IF EXISTS `disc`;

CREATE TABLE `disc`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `artist_id` int(11),
    CONSTRAINT disc_pk PRIMARY KEY (`id`),
    CONSTRAINT artist_id_fk FOREIGN KEY (`artist_id`) REFERENCES artist (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
