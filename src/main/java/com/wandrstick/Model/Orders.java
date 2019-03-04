package com.wandrstick.Model;

import javax.persistence.*;
/* Orders with product and quantity orders, plus shipping addresses, payment details, and shipped status.
 */

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private String productName;
    private int orderQuantity;
    private String shippingAddress;
    private String paymentDetailes;
    private String shippingStatus;

}
