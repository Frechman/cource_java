-- ADD DEFAULT DATA
INSERT INTO States (name)
VALUES ('open');
INSERT INTO States (name)
VALUES ('working');
INSERT INTO States (name)
VALUES ('waiting');
INSERT INTO States (name)
VALUES ('close');
--
INSERT INTO Categories (name)
VALUES ('common');
INSERT INTO Categories (name)
VALUES ('item for access');
--
INSERT INTO Items (name, description, category_id, state_id)
VALUES ('поломка жесть', 'сломалась всё', '1', '2');
INSERT INTO Items (name, description, category_id, state_id)
VALUES ('доступ', 'дайте доступ на', '2', '3');
INSERT INTO Items (name, description, category_id, state_id)
VALUES ('выполненная заявка', 'выполнено', '1', '4');
--
INSERT INTO Comments (content, create_username, item_id)
VALUES ('test test test', 'ivanov', '1');
INSERT INTO Comments (content, create_username, item_id)
VALUES ('решено', 'петров', '3');
--
INSERT INTO Roles (name)
VALUES ('guest');
INSERT INTO Roles (name)
VALUES ('user');
INSERT INTO Roles (name)
VALUES ('moder');
INSERT INTO Roles (name)
VALUES ('admin');
--
INSERT INTO Rules (name)
VALUES ('NOTHING');
INSERT INTO Rules (name)
VALUES ('READ');
INSERT INTO Rules (name)
VALUES ('EDIT');
INSERT INTO Rules (name)
VALUES ('DELETE');
--
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
--
INSERT INTO Users (email, password, first_name, last_name, role_id, item_id)
VALUES ('ya@ya.ru', '123456', 'ivan', 'ivanov', '2', '1');
INSERT INTO Users (email, password, first_name, last_name, role_id, item_id)
VALUES ('on@google.com', '654321', 'Вася', 'Smitt', '3', '2');
INSERT INTO Users (email, password, first_name, last_name, role_id, item_id)
VALUES ('all@all.all', '000000', 'admin', 'admin', '4', '3');