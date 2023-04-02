CREATE TABLE `user`(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20),
    `password` VARCHAR(30),
    gender TINYINT,
    last_login_time DATETIME
);