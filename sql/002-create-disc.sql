use `music-db`;

DROP TABLE IF EXISTS `discs`;

CREATE TABLE `discs`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `songs`     varchar(60),
    `artist`    varchar(60),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
