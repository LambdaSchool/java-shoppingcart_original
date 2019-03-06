INSERT INTO user(userid, username, password, role, firstname, middlename, lastname, phonenumber, email)
VALUES (1, 'thumpthump', 'password', 'USER', 'Randy', null, 'Calderon', '901-333-2014', 'tm@gmail.com'),
       (2, 'jimmyj', 'password', 'USER', 'Jimmy', 'Alex', 'Sanders', '802-345-1930', 'jtry@gmail.com'),
       (3, 'metax', 'password', 'USER', 'Rob', null, 'Robinson', '740-232-3890', 'metax@gmail.com');

INSERT INTO supplier(supplierid,suppliername,productname,quantity)
VALUES (1, 'Kibbles Inc','Kibbles n Bits', 400),
       (2, 'Purina Inc', 'Purina One SmartBlend', 300),
       (3, 'Chapstick Inc', 'Chapstick Moisturizing Lip Balm 3ct', 1000),
       (4, 'Pop Secret Inc', 'Pop Secret Premium Popcorn 30ct', 700);

INSERT INTO product(productid, productname, description, quantity, price)
VALUES (1, 'Kibbles n Bits', 'Chicken Flavors Dry Dog 50lb.', 30, 24.99),
       (2, 'Purina One SmartBlend', 'Real Salmon & Tuna Adult Dry Dog food 27.5lb', 15, 32.99),
       (3, 'Chapstick Moisturizing Lip Balm 3ct', 'Help heat and protect your lips', 40, 2.99),
       (4, 'Pop Secret Premium Popcorn 30ct', 'Movie theater butter', 25, 12.99);

INSERT INTO orders(orderid, userid)
VALUES (1, 1);

INSERT INTO supplier_products(productid, supplierid)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);

INSERT INTO order_products(orderid, productname, quantity, productid)
VALUES (1, 'Chapstick Moisturizing Lip Balm 3ct', 2, 3),
       (1, 'Pop Secret Premium Popcorn 30ct', 3, 4);

INSERT INTO user_address(id, userid, street, city, zip, state, country, unit_number)
VALUES (1, 2, '6333 Brick Avenue', 'Burbank', 91606, 'CA',  'USA', null),
       (2, 3, '1020 Bermuda Road', 'Houston', 70129, 'TX', 'USA', null),
       (3, 1,'8327 Jersey Lane', 'Newport', 008859, 'NJ', 'USA', null);