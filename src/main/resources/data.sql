INSERT INTO roles (role_id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (role_id, name) VALUES (2, 'DOCTOR');

INSERT INTO users (first_name, last_name, username, password, enabled) VALUES ('Admin', 'Adminovich', 'admin', '$2a$12$VsZT.hoqqNvrJ0ylr1JuP.Y7UEW4QkDKyWot.FTRCzA9Tc4k9B4dy', '1');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);