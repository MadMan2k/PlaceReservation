INSERT INTO users (first_name, last_name, email, password, phone_number, user_role)
VALUES ('Emmanuel', 'Macron', 'emacron@gmail.com', '12345', '01 02 03 04 05', 0);
INSERT INTO users (first_name, last_name, email, password, phone_number, user_role)
VALUES ('François', 'Hollande', 'fholland@gmail.com', '54321', '05 04 03 02 01', 1);
INSERT INTO users (first_name, last_name, email, password, phone_number, user_role)
VALUES ('Nicolas', 'Sarkozy', 'nsarkozy@gmail.com', '00000', '01 01 01 01 01', 2);

INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('Epilation', 30, 20);
INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('Botox', 15, 200);
INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('Massage', 60, 75);
INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('Face cleaning', 30, 30);
INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('Body cleaning', 90, 50);
INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('Make up', 120, 60);
INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('Health cocktail', 45, 75);
INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('Mask', 30, 15);
INSERT INTO procedures (name, duration_in_minutes, price) VALUES ('RESERVATION', 60, 0);


INSERT INTO rdvs (client_first_name, client_last_name, client_email, client_phone_number, date, time, procedures_id, rdv_status)
VALUES  ('Emmanuel', 'Macron', 'emacron@gmail.com', '01 02 03 04 05', '2023-05-01', '10:00', (SELECT id FROM procedures WHERE name = 'Health cocktail'), 0)