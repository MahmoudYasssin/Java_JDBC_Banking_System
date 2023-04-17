DROP DATABASE IF EXISTS jdbc_university_db;
CREATE DATABASE jdbc_university_db;
USE jdbc_university_db;
CREATE TABLE student(
   id INT(15) PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(15),
   GPA REAl,
   department VARCHAR(15),
   status VARCHAR(15)
);