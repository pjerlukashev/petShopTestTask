DELETE FROM cars;
DELETE FROM persons;
ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO persons (name, email) VALUES
  ('pjer', 'user@yandex.ru'),
  ('alexey', 'admin@gmail.com'),
  ('nikolay', 'admin@gmail.com');


INSERT INTO cars (person_id, model, speed)
VALUES (1, 'Mazda', 150),
 (1, 'bmw', 220),
 (2, 'porsche', 250),
 (2, 'landrover', 200),
(2, 'fiat', 150),
(3, 'ferrari', 280),
(3, 'mercedes', 260);

