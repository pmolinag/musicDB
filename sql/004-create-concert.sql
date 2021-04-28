USE `music-db`;

DROP TABLE IF EXISTS `concert`;
DROP TABLE IF EXISTS `concert_song`;

CREATE TABLE `concert` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `date` date NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `date_UNIQUE` (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `concert_song` (
                                `concert_id` int NOT NULL,
                                `song_id` int NOT NULL,
                                PRIMARY KEY (`concert_id`,`song_id`),
                                KEY `fk_song_idx` (`song_id`),
                                CONSTRAINT `fk_concert` FOREIGN KEY (`concert_id`) REFERENCES `concert` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                CONSTRAINT `fk_song` FOREIGN KEY (`song_id`) REFERENCES `song` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci