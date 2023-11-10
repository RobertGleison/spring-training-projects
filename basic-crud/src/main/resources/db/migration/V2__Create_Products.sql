DROP TABLE IF EXISTS products;

CREATE TABLE products (
    Id INT PRIMARY KEY,
    Price FLOAT8 NOT NULL,
    Description TEXT,
    Name VARCHAR(255)
    )