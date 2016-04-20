INSERT INTO user (email, password_hash, role) VALUES ('admin@localhost', '$2a$10$WUmZqgjhdcXKlo9YXif8Iu8NmpLznTceZehg6DPYkB4xc5cFNVGnO', 'ADMIN');

INSERT INTO user_details (name, surname, phone, city) VALUES ('name', 'surname', 'phone', 'city');
-- INSERT INTO user (email, password_hash, role, user_detail_id) VALUES ('user@localhost', '$2a$10$WUmZqgjhdcXKlo9YXif8Iu8NmpLznTceZehg6DPYkB4xc5cFNVGnO', 'USER',
-- (select id from user_details where surname = 'surname') );