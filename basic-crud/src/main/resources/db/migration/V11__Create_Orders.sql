CREATE TABLE orders (
    Id INT PRIMARY KEY,
    OrderMoment TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Status INT NOT NULL,
    User_id INT REFERENCES users(id),
    CONSTRAINT orders_user_id_fk FOREIGN KEY (User_id) REFERENCES users(id)
);