CREATE TABLE `user` (
  `username` varchar(25) PRIMARY KEY NOT NULL,
  `password` varchar(255) NOT NULL
);

CREATE TABLE `bookmarklist` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `user_username` varchar(25) NOT NULL
);

CREATE TABLE `bookmark` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `bookmarklist_id` int
);

ALTER TABLE `bookmarklist` ADD FOREIGN KEY (`user_username`) REFERENCES `user` (`username`);

ALTER TABLE `bookmark` ADD FOREIGN KEY (`bookmarklist_id`) REFERENCES `bookmarklist` (`id`);