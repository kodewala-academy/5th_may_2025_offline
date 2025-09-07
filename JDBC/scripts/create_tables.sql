CREATE DATABASE IF NOT EXISTS batch5thmay;

USE batch5thmay;

CREATE TABLE payment (
    payment_id INT,
    amount INT,
    status VARCHAR(100)
);

CREATE TABLE orders (
    order_id INT,
    item_name VARCHAR(200),
    status VARCHAR(100),
    placed_by VARCHAR(100)
);