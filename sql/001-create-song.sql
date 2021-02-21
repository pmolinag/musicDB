use `music-db`;

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `name`     varchar(60),
    `duration` INT UNSIGNED,
    CONSTRAINT song_pk PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
