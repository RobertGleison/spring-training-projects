CREATE TABLE users (
    Id INT,
    Name VARCHAR(255) PRIMARY KEY NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Phone VARCHAR(255),
    Password VARCHAR(255)
    );