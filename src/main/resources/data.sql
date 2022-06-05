INSERT INTO roles (role_id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (role_id, name) VALUES (2, 'DOCTOR');

INSERT INTO users (first_name, last_name, username, password, enabled) VALUES ('Admin', 'Adminovich', 'admin', '$2a$12$VsZT.hoqqNvrJ0ylr1JuP.Y7UEW4QkDKyWot.FTRCzA9Tc4k9B4dy', '1');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);


insert into laboratory (id, lab_name, address, phone) values (1, 'Lab1', '83 Chinook Crossing', '077775558');
insert into laboratory (id, lab_name, address, phone) values (2, 'Lab2', '5960 Schmedeman Lane', '0708454545');
insert into laboratory (id, lab_name, address, phone) values (3, 'Lab3', '856 Corry Court', '0555454455');
insert into laboratory (id, lab_name, address, phone) values (4, 'Lab4', '131 Sauthoff Way', '0999458595');
insert into laboratory (id, lab_name, address, phone) values (5, 'Lab5', '27 Straubel Parkway', '0502456545');

insert into doctors (id, first_name, last_name, specialty, address, mobile_number) values (1, 'Emmie', 'Baldick', 'Therapist', '79 Garrison Way', '0777777');
insert into doctors (id, first_name, last_name, specialty, address, mobile_number) values (2, 'Corinne', 'Limpkin', 'Pediatrician', '593 Debs', '080788888');
insert into doctors (id, first_name, last_name, specialty, address, mobile_number) values (3, 'Abe', 'Bourdel', 'Neurologist', '98 Center', '05505555');
insert into doctors (id, first_name, last_name, specialty, address, mobile_number) values (4, 'Meir', 'Labrum', 'Dermotologist', '5 MapleWood', '07777777');
insert into doctors (id, first_name, last_name, specialty, address, mobile_number) values (5, 'Elaina', 'Hardin', 'Psychiatrist', '53 Independence ', '07777777');