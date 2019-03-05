package com.wandrstick.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
/* Orders with product and quantity orders, plus shipping addresses, payment details, and shipped status.
 */

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String productName;
    private int orderQuantity;
    private String shippingAddress;
    private String paymentDetails;
    private String shippingStatus;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    @JsonIgnoreProperties("customer")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart",
            joinColumns = {
                    @JoinColumn(name = "orderId"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "productId"),
            }
                    )
    private Set<Products> products;


    public Orders() {
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
