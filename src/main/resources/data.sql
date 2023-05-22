INSERT INTO users (first_name, last_name, email, password, phone_number, user_role)
VALUES ('Emmanuel', 'Macron', 'emacron@gmail.com', '12345', '01 02 03 04 05', 0);
INSERT INTO users (first_name, last_name, email, password, phone_number, user_role)
VALUES ('François', 'Hollande', 'fholland@gmail.com', '54321', '05 04 03 02 01', 1);
INSERT INTO users (first_name, last_name, email, password, phone_number, user_role)
VALUES ('Nicolas', 'Sarkozy', 'nsarkozy@gmail.com', '00000', '01 01 01 01 01', 2);

INSERT INTO cities (name) VALUES ('Paris');
INSERT INTO cities (name) VALUES ('Marseille');
INSERT INTO cities (name) VALUES ('Lyon');
INSERT INTO cities (name) VALUES ('Toulouse');
INSERT INTO cities (name) VALUES ('Nice');
INSERT INTO cities (name) VALUES ('Nantes');
INSERT INTO cities (name) VALUES ('Montpellier');
INSERT INTO cities (name) VALUES ('Strasbourg');
INSERT INTO cities (name) VALUES ('Lille');

INSERT INTO rdvs (client_first_name, client_last_name, client_email, client_phone_number, date, time, city_id, rdv_status)
VALUES  ('Emmanuel', 'Macron', 'emacron@gmail.com', '01 02 03 04 05', '2023-05-01', '10:00', (SELECT id FROM cities WHERE name = 'Lyon'), 0)