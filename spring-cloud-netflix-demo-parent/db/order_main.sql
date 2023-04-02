CREATE TABLE order_main(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20),
    fee DECIMAL(8, 2),
    currency VARCHAR(20),
    create_time DATETIME,
    update_time DATETIME,
    deleted TINYINT,
    version INTEGER
);