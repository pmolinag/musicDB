USE `music-db`;

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song`
(
    `id`       INT(11) NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(60),
    `duration` INT UNSIGNED,
    `disc_id`  INT(11),
    CONSTRAINT song_pk PRIMARY KEY (`id`),
    CONSTRAINT disc_id_fk FOREIGN KEY (`disc_id`) REFERENCES disc (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
