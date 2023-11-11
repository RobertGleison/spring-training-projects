ALTER TABLE payments
ADD COLUMN order_id INT REFERENCES orders(id);