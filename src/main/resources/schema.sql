DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS balances;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number BIGINT NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE accounts (
    account_number INT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    balance BIGINT NOT NULL
);

CREATE TABLE balances (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number INT NOT NULL,
    account_balance DECIMAL(18,2) NOT NULL,
    balance_timestamp TIMESTAMP NOT NULL
);