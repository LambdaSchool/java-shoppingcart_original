package com.wandrstick.Model;

import javax.persistence.*;
/* Cart with cart items that include products and quantity orders. */
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartid;

    private String products;
    private int quantityOrdered;
}
