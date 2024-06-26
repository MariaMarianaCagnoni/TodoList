CREATE TABLE task
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    description   VARCHAR(10000) NOT NULL,
    date_and_time TIMESTAMP,
    is_completed  BOOLEAN        NOT NULL
);