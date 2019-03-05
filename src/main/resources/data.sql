INSERT INTO customer (customer_id, first_name, middle_name, last_name, email, password, billing_address,shipping_address, phone_number, payment_method)
        VALUES  (1,"Csaba", "MiddleName" ,"Balogh", "csababalogh84@gmail.com", "password123", "8014 Mango Ave Apt c30", "8014 Mango Ave Apt c30", "909-213-8702", "credit"),
                (2,"Eszter", "" ,"MiddleName", "eszter@gmail.com", "password123", "8014 Mango Ave Apt c30", "1074 Budapest Also erdosor utca 20.", "3612228435", "credit");

  INSERT INTO orders(order_id, product_name, order_quantity,shipping_address,payment_details,shipping_status,customer_id)
        VALUE(1, "lipstick", 2, "8014 Mango Ave Aptc30", "credit", "processing", 1),
              (2, "lipstick", 2, "9132 Sunset rd,Malibu Hill", "debit", "processing", 1),
              (3, "lipstick", 2, "90210 Beverly Hills", "credit", "processing", 2),
              (4, "lipstick", 2, "8014 Mango Ave Aptc30", "credit", "processing", 2),
              (5, "lipstick", 2, "8014 Mango Ave Aptc30", "credit", "processing", 1);

INSERT INTO products(product_id, description, price, product_name, quantity_on_hand)
        VALUE (1, "extra hydrating super healthy", 45.00, "organic goodies", 103),
        (2, "extra hydrating super healthy", 45.00, "organic goodies", 103),
        (3, "brutal chainsaw", 119.00, "organic chainsaw", 10),
        (4, "sharp axe", 90.00, "cutting edgge technology", 82),
        (5, "apple pen", 150.00, "apple_pen", 13);

INSERT INTO cart(order_id, product_id)
      VALUE(1,1),
            (2,1),
            (3,2),
            (4,2),
            (5,1);
      ;

