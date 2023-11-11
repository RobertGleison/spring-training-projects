CREATE TABLE order_product (
    OrderId INT REFERENCES orders(Id),
    ProductId INT REFERENCES products(Id),
    Quantity INT NOT NULL,
    Price FLOAT8 NOT NULL,
    PRIMARY KEY(OrderId,ProductId)
);
