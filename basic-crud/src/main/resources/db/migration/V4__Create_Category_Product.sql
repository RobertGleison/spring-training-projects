CREATE TABLE product_category (
    ProductId INT REFERENCES products(Id),
    CategoryId INT REFERENCES categories(Id),
    PRIMARY KEY(ProductId,CategoryId)
);
