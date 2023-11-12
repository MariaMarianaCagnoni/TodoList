CREATE TABLE IF NOT EXISTS task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(10000) NOT NULL,
    date_and_time TIMESTAMP,
    completed BOOLEAN NOT NULL
);

INSERT INTO task (description, date_and_time, completed) VALUES
('Descrição 1', '2023-11-12 10:30:00', 1),
('Descrição 2', '2023-11-13 14:45:00', 0),
('Descrição 3', '2023-11-14 08:00:00', 0),
('Descrição 4', '2023-11-14 12:00:00', 1),
('Descrição 5', '2023-11-14 08:00:00', 1),
('Descrição 6', '2023-11-14 08:00:00', 0),
('Descrição 7', '2023-11-14 22:00:00', 0),
('Descrição 8', '2023-11-14 11:00:00', 1),
('Descrição 9', '2023-11-14 07:00:00', 0);