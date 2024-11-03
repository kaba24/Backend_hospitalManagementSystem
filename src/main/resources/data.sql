-- data.sql
CREATE TABLE patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    gender VARCHAR(50)
);

INSERT INTO patients (name, age, gender) VALUES ('John Doe', 30, 'Male');
INSERT INTO patients (name, age, gender) VALUES ('Jane Smith', 25, 'Female');