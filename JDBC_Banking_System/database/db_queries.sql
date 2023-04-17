DROP DATABASE IF EXISTS jdbc_banking_db;

CREATE DATABASE jdbc_banking_db;

USE jdbc_banking_db;

CREATE TABLE client(
   password VARCHAR(15) PRIMARY KEY,
   name VARCHAR(15) ,
   address VARCHAR(20),
   phone VARCHAR(15),
   money REAL
);