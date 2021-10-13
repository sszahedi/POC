INSERT INTO users (first_name, last_name, address, phone_number, email, label)
    VALUES ('Leanne', 'Graham', 'Kulas Light, Apt. 556, Gwenborough, KY, 92998', 17707368031, 'sincere@april.biz', 'userOne');
INSERT INTO users (first_name, last_name, address, phone_number, email, label)
    VALUES ('Ervin', 'Howell', 'Victor Plains, Suite 879, Wisokyburgh, CT, 90566', 0106926593, 'shanna@melissa.tv', 'userTwo');
INSERT INTO users (first_name, last_name, address, phone_number, email, label)
    VALUES ('Clementine', 'Bauch', 'Douglas Extension, SUite 847, KcKenzieHaven, IL, 59590', 14631234447, 'nathan@yesenia.net', 'userThree');
INSERT INTO users (first_name, last_name, address, phone_number, email, label)
    VALUES ('Patricia', 'Lebsack', 'Hoeger Mall, Apt. 692, South Elvis, TX, 53919', 4931709623, 'julianne.oconner@kory.org', 'userFour');
INSERT INTO users (first_name, last_name, address, phone_number, email, label)
    VALUES ('Chelsey', 'Dietrich', 'Skiles Walks, Suite 351, Roscoeview, AL, 33263', 2549541289, 'lucio_hettinger@annie.ca', 'userFive');

INSERT INTO accounts (account_number, description, balance, label)
VALUES (5889424, 'Checking', 250, 'accountOne');
INSERT INTO accounts (account_number, description, balance, label)
VALUES (5698648, 'Savings', 1000, 'accountTwo');
INSERT INTO accounts (account_number, description, balance, label)
VALUES (8750668, 'Savings', 5000, 'accountThree');
INSERT INTO accounts (account_number, description, balance, label)
VALUES (8962786, 'Checking', 50000, 'accountFour');
INSERT INTO accounts (account_number, description, balance, label)
VALUES (8540960, 'Checking', 10000, 'accountFive');

INSERT INTO balances (account_number, account_balance, balance_timestamp, label)
VALUES (8962786, 10000, '2021-07-03 13:15:20.23', 'balanceOne');
INSERT INTO balances (account_number, account_balance, balance_timestamp, label)
VALUES (8962786, 10123, '2021-07-04 22:09:10.43', 'balanceTwo');
INSERT INTO balances (account_number, account_balance, balance_timestamp, label)
VALUES (8962786, 9858.57, '2021-07-16 09:15:20.23', 'balanceThree');
INSERT INTO balances (account_number, account_balance, balance_timestamp, label)
VALUES (8962786, 12356.74, '2021-07-22 18:06:20.53', 'balanceFour');
INSERT INTO balances (account_number, account_balance, balance_timestamp, label)
VALUES (8962786, 18566.12, '2021-07-27 07:35:10.33', 'balanceFive');
