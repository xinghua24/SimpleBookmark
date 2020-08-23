INSERT INTO `user`(`username`, `password`) VALUES ('user', 'password');

INSERT INTO `bookmarklist`(`id`, `name`, `user_username`) VALUES (1, 'default','user');

INSERT INTO `bookmark`(`name`, `url`, `bookmarklist_id`) VALUES ('Google', 'http://google.com', 1);
INSERT INTO `bookmark`(`name`, `url`, `bookmarklist_id`) VALUES ('Youtube', 'https://www.youtube.com/', 1);
INSERT INTO `bookmark`(`name`, `url`, `bookmarklist_id`) VALUES ('Amazon', 'http://amazon.com', 1);
INSERT INTO `bookmark`(`name`, `url`, `bookmarklist_id`) VALUES ('Netflix', 'http://netflix.com', 1);