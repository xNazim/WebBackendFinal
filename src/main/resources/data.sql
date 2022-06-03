INSERT INTO role (role_id, name) VALUES (1, 'ADMIN');
INSERT INTO role (role_id, name) VALUES (2, 'DOCTOR');

INSERT INTO users (first_name, last_name, username, password, enabled) VALUES ('Patrick', 'John', 'john', '$2a$12$T9raQozOMSCrTFniIMzBSOk4CFsBed.TXJeznCsCtEfQXBc0Y3DJO', '1');
INSERT INTO users (first_name, last_name, username, password, enabled) VALUES ('Alex', 'Bond', 'alex', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', '1');


INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2); 