CREATE DATABASE tracker_db;

-- CREATE STRUCTURE DATABASE FOR TRACKER
CREATE TABLE States (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL
);

CREATE TABLE Categories (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL
);

CREATE TABLE Items (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(256) NOT NULL,
  description TEXT,
  create_date TIMESTAMP DEFAULT now(),
  category_id INT          NOT NULL,
  state_id    INT          NOT NULL,
  FOREIGN KEY (category_id) REFERENCES Categories (id),
  FOREIGN KEY (state_id) REFERENCES States (id)
);

CREATE TABLE Comments (
  id              SERIAL PRIMARY KEY,
  content         TEXT         NOT NULL,
  create_username VARCHAR(128) NOT NULL,
  create_date     TIMESTAMP    NOT NULL DEFAULT now(),
  item_id         INT          NOT NULL,
  FOREIGN KEY (item_id) REFERENCES Items (id)
);

CREATE TABLE Attaches (
  id        SERIAL PRIMARY KEY,
  file_link VARCHAR(1000) NOT NULL, --(or file BLOB)
  item_id   INT           NOT NULL,
  FOREIGN KEY (item_id) REFERENCES Items (id)
);

CREATE TABLE Roles (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL
);

CREATE TABLE Rules (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL
);
--table for many-to-many
CREATE TABLE Role_Rules (
  id       SERIAL PRIMARY KEY,
  role_id  INT REFERENCES Roles (id),
  rules_id INT REFERENCES Rules (id),
  UNIQUE (role_id, rules_id)
);

CREATE TABLE Users (
  id         SERIAL PRIMARY KEY,
  email      VARCHAR(128) UNIQUE NOT NULL,
  password   VARCHAR(128)        NOT NULL,
  first_name VARCHAR(128)        NOT NULL,
  last_name  VARCHAR(128)        NOT NULL,
  role_id    INT                 NOT NULL,
  item_id    INT                 NOT NULL,
  FOREIGN KEY (role_id) REFERENCES Roles (id),
  FOREIGN KEY (item_id) REFERENCES Items (id)
);

-- ADD DEFAULT DATA
INSERT INTO States (name)
VALUES ('open');
INSERT INTO States (name)
VALUES ('working');
INSERT INTO States (name)
VALUES ('waiting');
INSERT INTO States (name)
VALUES ('close');

INSERT INTO Categories (name)
VALUES ('common');
INSERT INTO Categories (name)
VALUES ('item for access');

INSERT INTO Items (name, description, category_id, state_id)
VALUES ('поломка жесть', 'сломалась всё', '1', '2');
INSERT INTO Items (name, description, category_id, state_id)
VALUES ('доступ', 'дайте доступ на', '2', '3');
INSERT INTO Items (name, description, category_id, state_id)
VALUES ('выполненная заявка', 'выполнено', '1', '4');

INSERT INTO Comments (content, create_username, item_id)
VALUES ('test test test', 'ivanov', '1');
INSERT INTO Comments (content, create_username, item_id)
VALUES ('решено', 'петров', '3');

INSERT INTO Roles (name)
VALUES ('guest');
INSERT INTO Roles (name)
VALUES ('user');
INSERT INTO Roles (name)
VALUES ('moder');
INSERT INTO Roles (name)
VALUES ('admin');

INSERT INTO Rules (name)
VALUES ('NOTHING');
INSERT INTO Rules (name)
VALUES ('READ');
INSERT INTO Rules (name)
VALUES ('EDIT');
INSERT INTO Rules (name)
VALUES ('DELETE');

INSERT INTO Role_Rules (role_id, rules_id)
VALUES (1, 1);
INSERT INTO Role_Rules (role_id, rules_id)
VALUES (2, 2);
INSERT INTO Role_Rules (role_id, rules_id)
VALUES (2, 3);
INSERT INTO Role_Rules (role_id, rules_id)
VALUES (3, 2);
INSERT INTO Role_Rules (role_id, rules_id)
VALUES (3, 3);
INSERT INTO Role_Rules (role_id, rules_id)
VALUES (4, 2);
INSERT INTO Role_Rules (role_id, rules_id)
VALUES (4, 3);
INSERT INTO Role_Rules (role_id, rules_id)
VALUES (4, 4);

INSERT INTO Users (email, password, first_name, last_name, role_id, item_id)
VALUES ('ya@ya.ru', '123456', 'ivan', 'ivanov', '2', '1');
INSERT INTO Users (email, password, first_name, last_name, role_id, item_id)
VALUES ('on@google.com', '654321', 'Вася', 'Smitt', '3', '2');
INSERT INTO Users (email, password, first_name, last_name, role_id, item_id)
VALUES ('all@all.all', '000000', 'admin', 'admin', '4', '3');