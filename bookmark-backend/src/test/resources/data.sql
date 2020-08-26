
INSERT INTO `user`(`username`, `password`) VALUES ('user', '{bcrypt}$2y$12$G.VtlG.83.RlN9gxBYWqduSSzCk92WrTTvNsUH.Lw06jt9CaWOrKS');

INSERT INTO `bookmarklist`(`id`, `name`, `user_username`) VALUES (1, 'default','user');

INSERT INTO `bookmark`(`name`, `url`, `bookmarklist_id`) VALUES ('Google', 'http://google.com', 1);
INSERT INTO `bookmark`(`name`, `url`, `bookmarklist_id`) VALUES ('Youtube', 'https://www.youtube.com/', 1);
INSERT INTO `bookmark`(`name`, `url`, `bookmarklist_id`) VALUES ('Amazon', 'http://amazon.com', 1);
INSERT INTO `bookmark`(`name`, `url`, `bookmarklist_id`) VALUES ('Netflix', 'http://netflix.com', 1);