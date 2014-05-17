INSERT INTO users (id, name) VALUES (1, 'Anton');
INSERT INTO users (id, name) VALUES (2, 'Shegol');
INSERT INTO users (id, name) VALUES (3, 'Ira');
INSERT INTO users (id, name) VALUES (4, 'Dasha');
INSERT INTO users (id, name) VALUES (5, 'Egor');
INSERT INTO users (id, name) VALUES (6, 'Stasik');
INSERT INTO users (id, name) VALUES (7, 'Ivan');
INSERT INTO friendships (user1, user2) VALUES (1, 2);
INSERT INTO friendships (user1, user2) VALUES (2, 1);
INSERT INTO friendships (user1, user2) VALUES (1, 5);
INSERT INTO friendships (user1, user2) VALUES (5, 1);
INSERT INTO friendships (user1, user2) VALUES (2, 6);
INSERT INTO friendships (user1, user2) VALUES (6, 2);
INSERT INTO friendships (user1, user2) VALUES (1, 6);
INSERT INTO friendships (user1, user2) VALUES (6, 1);
INSERT INTO goods (id, name, description, location) VALUES (1, 'Computer', 'Up-to-date', 'Germany');
INSERT INTO goods (id, name, description, location) VALUES (2, 'Mushrooms', 'Fresh', 'Russia');
INSERT INTO goods (id, name, description, location) VALUES (3, 'Klay', 'Sweet', 'Germany');
INSERT INTO goods (id, name, description, location) VALUES (4, 'Cap', 'From glass', 'Russia');
INSERT INTO goods (id, name, description, location) VALUES (5, 'Cat', 'Talking cat', 'Russia');
INSERT INTO trips (id, dest, departure_date, arrival_date, traveller, capacity) VALUES (1, 'Germany', TO_DATE ('30.10.2014', 'DD.MM.YYYY'), TO_DATE ('01.11.2014', 'DD.MM.YYYY'), 1, 3);
INSERT INTO trips (id, dest, departure_date, arrival_date, traveller, capacity) VALUES (2, 'Moscow', TO_DATE ('29.10.2014', 'DD.MM.YYYY'), TO_DATE ('30.10.2014', 'DD.MM.YYYY'), 1, 3);
INSERT INTO trips (id, dest, departure_date, arrival_date, traveller, capacity) VALUES (3, 'Kazany', TO_DATE ('28.10.2014', 'DD.MM.YYYY'), TO_DATE ('29.10.2014', 'DD.MM.YYYY'), 1, 3);
INSERT INTO trips (id, dest, departure_date, arrival_date, traveller, capacity) VALUES (4, 'France', TO_DATE ('21.12.2014', 'DD.MM.YYYY'), TO_DATE ('23.12.2014', 'DD.MM.YYYY'), 2, 1);
INSERT INTO trips (id, dest, departure_date, arrival_date, traveller, capacity) VALUES (5, 'France', TO_DATE ('18.12.2014', 'DD.MM.YYYY'), TO_DATE ('21.12.2014', 'DD.MM.YYYY'), 2, 1);
INSERT INTO trips (id, dest, departure_date, traveller, capacity) VALUES (6, 'Moon', TO_DATE ('31.10.2014', 'DD.MM.YYYY'), 5, 2);
INSERT INTO requests (trip, goods, customer, count) VALUES (1, 1, 2, 8);
INSERT INTO requests (trip, goods, customer, count) VALUES (1, 2, 3, 45);
INSERT INTO requests (trip, goods, customer, count) VALUES (1, 3, 4, 3);
INSERT INTO requests (trip, goods, customer, count) VALUES (1, 4, 5, 76);
INSERT INTO requests (trip, goods, customer, count) VALUES (1, 5, 6, 3);
INSERT INTO requests (trip, goods, customer, count) VALUES (1, 1, 7, 75);
INSERT INTO requests (trip, goods, customer, count) VALUES (2, 2, 2, 2);
INSERT INTO requests (trip, goods, customer, count) VALUES (2, 3, 7, 34);
INSERT INTO snetworks (user_id, network_type, page, PROVIDER_USER_ID) VALUES (1, 1, 'pgg', '123');
INSERT INTO snetworks (user_id, network_type, page, PROVIDER_USER_ID) VALUES (2, 1, 'asd', '234');
INSERT INTO snetworks (user_id, network_type, page, PROVIDER_USER_ID) VALUES (3, 1, 'qwe', '345');
INSERT INTO snetworks (user_id, network_type, page, PROVIDER_USER_ID) VALUES (4, 1, 'fft', '456');
INSERT INTO snetworks (user_id, network_type, page, PROVIDER_USER_ID) VALUES (5, 1, 'gas', '567');
INSERT INTO snetworks (user_id, network_type, page, PROVIDER_USER_ID) VALUES (6, 1, 'eye', '678');
INSERT INTO snetworks (user_id, network_type, page, PROVIDER_USER_ID) VALUES (7, 1, 'put', '789');