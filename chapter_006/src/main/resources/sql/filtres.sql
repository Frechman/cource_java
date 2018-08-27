CREATE DATABASE product_db;

CREATE TABLE Product (
  id           SERIAL PRIMARY KEY,
  name         VARCHAR,
  type_id      INT,
  expired_date DATE,
  price        INT
);
CREATE TABLE Type (
  id   SERIAL PRIMARY KEY,
  name VARCHAR
);
-- data for tests
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (1, '1', 1, '2018-01-01', 10);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (2, '123', 2, '2018-01-01', 20);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (3, '1234', 2, '2018-09-01', 30);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (4, '1234', 2, '2018-01-01', 40);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (5, '1', 3, '2018-09-01', 50);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (16, '1423', 3, '2018-09-30', 60);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (71, 'мороженное', 3, '2018-09-11', 70);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (8, '1', 2, '2018-01-01', 80);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (191, 'мороженноеЫВА', 2, '2018-01-01', 90);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (10, 'ЫВА МОРОЖЕННОЕ ЫВА', 1, '2018-01-01', 100);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (11, '1', 1, '2018-01-01', 110);
INSERT INTO Product (id, name, type_id, expired_date, price)
VALUES (12, '1', 1, '2018-01-01', 110);

INSERT INTO Type (id, name)
VALUES (1, 'СЫР');
INSERT INTO Type (id, name)
VALUES (2, 'МОЛОКО');
INSERT INTO Type (id, name)
VALUES (3, 'МОРОЖЕННОЕ');

SELECT *
FROM Product;
-- Tasks:
-- 1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT P.*
FROM Product AS P
       INNER JOIN Type AS T ON P.type_id = T.id
WHERE T.name = 'СЫР';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT *
FROM Product
WHERE name LIKE '%мороженное%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT *
FROM Product
WHERE extract(MONS FROM expired_date :: date)
          BETWEEN extract(MONS FROM current_timestamp :: date) + 1
          AND extract(MONS FROM current_timestamp :: date) + 2;

-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT *
FROM Product
WHERE price = (SELECT MAX(price) FROM Product);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT count(*)
FROM Product
WHERE type_id = 2;
--OR
SELECT count(1)
FROM Product AS P
       JOIN Type AS T ON P.type_id = T.id
WHERE T.name = 'СЫР';

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT *
FROM Product AS P
       JOIN Type AS T ON P.type_id = T.id
WHERE T.name IN ('СЫР', 'МОЛОКО');
--OR
SELECT *
FROM Product AS P
       JOIN Type AS T ON P.type_id = T.id
WHERE T.name = 'СЫР'
   OR T.name = 'МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT P.type_id
FROM Product AS P
GROUP BY type_id
HAVING count(*) < 10;

--     8. Вывести все продукты и их тип.
SELECT P.name, T.name
FROM Product AS P
       JOIN Type AS T ON P.type_id = T.id;
