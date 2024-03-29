-- INSERT INTO users (first_name, last_name, email, password, phone_number, created_by, modified_by, is_exist, user_role)
-- VALUES ('Emmanuel', 'Macron', 'emacron@gmail.com', '12345', '01 02 03 04 05', 'SYSTEME', 'SYSTEME', true, 0);
-- INSERT INTO users (first_name, last_name, email, password, phone_number, created_by, modified_by, is_exist, user_role)
-- VALUES ('François', 'Hollande', 'fholland@gmail.com', '54321', '05 04 03 02 01', 'SYSTEME', 'SYSTEME', true, 1);
-- INSERT INTO users (first_name, last_name, email, password, phone_number, created_by, modified_by, is_exist, user_role)
-- VALUES ('Nicolas', 'Sarkozy', 'nsarkozy@gmail.com', '00000', '01 01 01 01 01', 'SYSTEME', 'SYSTEME', true, 2);

INSERT INTO users (first_name, last_name, email, password, phone_number, created_by, modified_by, is_exist, user_role)
VALUES ('Emmanuel', 'Macron', 'emacron@gmail.com', '12345', '01 02 03 04 05', 'SYSTEM', 'SYSTEM', true, 0);
INSERT INTO users (first_name, last_name, email, password, phone_number, created_by, modified_by, is_exist, user_role)
VALUES ('François', 'Hollande', 'fholland@gmail.com', '54321', '05 04 03 02 01', 'SYSTEM', 'SYSTEM', true, 1);
INSERT INTO users (first_name, last_name, email, password, phone_number, created_by, modified_by, is_exist, user_role)
VALUES ('Nicolas', 'Sarkozy', 'nsarkozy@gmail.com', '00000', '01 01 01 01 01', 'SYSTEM', 'SYSTEM', true, 2);

INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('Epilation', 30, 20, 'SYSTEM', 'SYSTEM');
INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('Botox', 15, 200, 'SYSTEM', 'SYSTEM');
INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('Massage', 60, 75, 'SYSTEM', 'SYSTEM');
INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('Face cleaning', 30, 30, 'SYSTEM', 'SYSTEM');
INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('Body cleaning', 90, 50, 'SYSTEM', 'SYSTEM');
INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('Make up', 120, 60, 'SYSTEM', 'SYSTEM');
INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('Health cocktail', 45, 75, 'SYSTEM', 'SYSTEM');
INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('Mask', 30, 15, 'SYSTEM', 'SYSTEM');
INSERT INTO procedures (name, duration_in_minutes, price, created_by, modified_by) VALUES ('RESERVATION', 60, 0, 'SYSTEM', 'SYSTEM');


INSERT INTO rdvs (client_first_name, client_last_name, client_email, client_phone_number, date, time, procedures_id, rdv_status, discount,  created_by, modified_by)
VALUES  ('Emmanuel', 'Macron', 'emacron@gmail.com', '01 02 03 04 05', '2023-05-01', '10:00', (SELECT id FROM procedures WHERE name = 'Health cocktail'), 0, 10.5, 'SYSTEM', 'SYSTEM')