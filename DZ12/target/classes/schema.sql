CREATE TABLE tasks
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(20) NOT NULL,
    description VARCHAR(100) NOT NULL,
    status VARCHAR(15),
    date_of_creation TIMESTAMP
);