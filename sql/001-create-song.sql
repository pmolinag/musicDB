use `music-db`;

DROP TABLE IF EXISTS `songs`;

CREATE TABLE `songs`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `name`     varchar(60),
    `duration` INT UNSIGNED,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
