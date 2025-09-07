
INSERT INTO payment(payment_id, amount, status) VALUES (1, 500, 'SUCCESS');
INSERT INTO payment(payment_id, amount, status) VALUES (2, 1000, 'FAILED');

INSERT INTO orders(order_id, item_name, status, placed_by) VALUES (101, 'Laptop', 'PLACED', 'Alice');
INSERT INTO orders(order_id, item_name, status, placed_by) VALUES (102, 'Mobile', 'PLACED', 'Bob');
