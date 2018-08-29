CREATE DATABASE car_catalog;

CREATE TABLE Car_body (
  id         SERIAL PRIMARY KEY,
  name_model VARCHAR(128)
);

CREATE TABLE Engine (
  id         SERIAL PRIMARY KEY,
  name_model VARCHAR(128)
);

CREATE TABLE Transmission (
  id         SERIAL PRIMARY KEY,
  name_model VARCHAR(128)
);

CREATE TABLE Car (
  id              SERIAL PRIMARY KEY,
  name_model      VARCHAR(128),
  car_body_id     INT NOT NUll,
  engine_id       INT NOT NULL,
  transmission_id INT NOT NULL,
  FOREIGN KEY (car_body_id) REFERENCES Car_body (id),
  FOREIGN KEY (engine_id) REFERENCES Engine (id),
  FOREIGN KEY (transmission_id) REFERENCES Transmission (id)
);

INSERT INTO Car_body (name_model)
VALUES ('USA');
INSERT INTO Car_body (name_model)
VALUES ('USSR');
INSERT INTO Car_body (name_model)
VALUES ('GERMAN');
INSERT INTO Car_body (name_model)
VALUES ('EUROPA');

INSERT INTO Engine (name_model)
VALUES ('Sport 2.0');
INSERT INTO Engine (name_model)
VALUES ('Sport');
INSERT INTO Engine (name_model)
VALUES ('LF17');
INSERT INTO Engine (name_model)
VALUES ('PEY5');
INSERT INTO Engine (name_model)
VALUES ('ZAZ-965M');

INSERT INTO Transmission (name_model)
VALUES ('Auto');
INSERT INTO Transmission (name_model)
VALUES ('Mechanic');
INSERT INTO Transmission (name_model)
VALUES ('NONE');

INSERT INTO Car (name_model, car_body_id, engine_id, transmission_id)
VALUES ('mazda', 4, 1, 2);
INSERT INTO Car (name_model, car_body_id, engine_id, transmission_id)
VALUES ('zaporojec', 2, 5, 1);
INSERT INTO Car (name_model, car_body_id, engine_id, transmission_id)
VALUES ('zazic', 1, 3, 2);
INSERT INTO Car (name_model, car_body_id, engine_id, transmission_id)
VALUES ('fly_machine', 2, 1, 1);

-- Task 1. Вывести список всех машин и все привязанные к ним детали.
SELECT C.name_model  AS car_model,
       CB.name_model AS body_model,
       E.name_model  AS engine_model,
       T.name_model  AS tramsmission_model
FROM Car AS C
       JOIN Car_body AS CB ON C.car_body_id = CB.id
       JOIN Engine E on C.engine_id = E.id
       JOIN Transmission T on C.transmission_id = T.id;

-- Task 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
SELECT *
FROM Car AS C
       RIGHT OUTER JOIN Car_body CB ON C.car_body_id = CB.id
WHERE C.id IS NULL;

SELECT *
FROM Engine AS E
       LEFT OUTER JOIN Car ON E.id = Car.engine_id
WHERE Car.engine_id IS NULL;

SELECT *
FROM Car
       RIGHT OUTER JOIN Transmission AS T On Car.transmission_id = T.id
WHERE Car.id IS NULL