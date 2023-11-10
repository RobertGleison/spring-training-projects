DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category (
    ProductId INT REFERENCES products(Id),
    CategoryId INT REFERENCES catergories(Id),
    PRIMARY KEY(ProductId,CategoryId)
);