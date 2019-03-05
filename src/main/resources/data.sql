INSERT INTO Customer(customer_id, email_address, first_name,last_name, middle_name, password, username)
            VALUES(1,"csababalogh84@gmail.com","Csaba","Balogh","", "password123","jasoncorp"),
                  (2,"eszterbalogh@gmail.com","Eszter","Balogh","", "password123","secret123"),
                  (3,"bilon@gmail.com","Ilona","Balogh","", "password123","ilonka"),
                  (4,"peter@gmail.com","Peter","Balogh","", "password123","peterba"),
                  (5,"bodza@gmail.com","Bodza","Balogh","", "password123","bodzolino");

INSERT INTO address(address_id, city,street,zip,street_number,unit_number,customer_id)
            VALUES (1, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 1),
                    (2, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 2),
                    (3, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 3),
                    (4, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 4),
                    (5, "Budapest", "Also Erdosor utca", "1074", "20","I/14", 5)

INSERT INTO 