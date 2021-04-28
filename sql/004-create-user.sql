USE `music-db`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`
(
    `id`       INT(11) NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(60),
    `last_name` VARCHAR(60),
    `email`  VARCHAR(60),
    `username`  VARCHAR(60),
    `password`  VARCHAR(60),
    CONSTRAINT user_pk PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
