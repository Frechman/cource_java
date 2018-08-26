CREATE TABLE Product (
  id           INT,
  name         VARCHAR,
  type_id      INT,
  expired_date DATE,
  price        INT
);
CREATE TABLE Type (
  id   INT,
  name VARCHAR
);

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
WHERE expired_date
          BETWEEN current_timestamp + INTERVAL '1 mons'
          AND current_timestamp + INTERVAL '2 mons';

-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT *
FROM Product
WHERE MAX(price);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT count(*)
FROM Product
WHERE type_id = 2;
--OR
SELECT count(*)
FROM Product AS P
       JOIN Type AS T ON P.type_id = T.id
WHERE T.name = 'СЫР';

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT P.*
FROM Product AS P
       JOIN Type AS T ON P.type_id = T.id
WHERE T.name IN ('СЫР', 'МОЛОКО');
--OR
SELECT *
FROM Product AS P
       JOIN Type AS T ON P.type_id = T.id
WHERE T.name = 'СЫР'
   OR 'МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT P.type_id
FROM Product AS P
WHERE (SELECT count(*) FROM Product GROUP BY type_id) < 10;
--OR
SELECT T.name
FROM Product AS P
       JOIN (SELECT * FROM Type GROUP BY name HAVING count(name) < 10) AS T ON P.type_id = T.id;

--     8. Вывести все продукты и их тип.
SELECT P.name, T.name
FROM Product AS P
       JOIN Type AS T ON P.type_id = T.id;
