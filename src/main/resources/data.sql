INSERT INTO Customer(customer_id, email_address, first_name,last_name, middle_name, password, username)
            VALUES(1,"csababalogh84@gmail.com","Csaba","Balogh","", "password123","jasoncorp"),
                  (2,"eszterbalogh@gmail.com","Eszter","Balogh","", "password123","secret123"),
                  (3,"bilon@gmail.com","Ilona","Balogh","", "password123","ilonka"),
                  (4,"peter@gmail.com","Peter","Balogh","", "password123","peterba"),
                  (5,"bodza@gmail.com","Bodza","Balogh","", "password123","bodzolino");

INSERT INTO customer_orders(order_id, customer_id)
            VALUES(1,1),
                  (2,2),
                  (3,3),
                  (4,4),
                  (5,5);

INSERT INTO customer_payment_methods(method_id, customer_id)
            VALUES (1,1),
                    (2,1),
                    (1,2),
                    (3,3),
                    (4,4);

INSERT INTO order_products(product_id, order_id)
            VALUES(1,2),
                  (2,1),
                  (3,4),
                  (4,7),
                  (5,3),
                  (6,5),
                  (7,6);

INSERT INTO address(address_id, city,street,zip,street_number,unit_number,customer_id)
            VALUES (1, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 1),
                    (2, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 2),
                    (3, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 3),
                    (4, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 4),
                    (5, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 5);

INSERT INTO products(product_id, description, price, product_name,quantity_on_hand)
            VALUES (1, "great axe, that cuts everything", 45.00, "great axe", 15),
                    (2, "luxury car", 67000.00, "mercedes benz amg", 3),
                    (3, "electric chainsaw", 225.00, "motoros_furesz", 45),
                    (4, "crossover car", 45000.00, "Land Rover", 5),
                    (5, "Samurai sword", 1200.00, "Hagasaky Nakahi", 1),
                    (6, "Even greater axe, that really cuts everything", 55.00, "greater axe", 10),
                    (7, "AR Helmet", 200.00, "Random Brand", 3);


INSERT INTO Orders(order_id, order_quantity)
            VALUES (1,3),
                    (2,1),
                    (3,4),
                    (4,5),
                    (5,9);

INSERT INTO order_products(product_id, order_id)
            VALUES(1,1),
                  (2,2),
                  (3,3),
                  (4,1),
                  (5,1),
                  (6,4),
                  (7,5);
INSERT INTO payment_methods(method_id, payment_method)
            VALUES(1, "credit"),
                  (2, "debit"),
                  (3, "paypal"),
                  (4, "stripe");

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
