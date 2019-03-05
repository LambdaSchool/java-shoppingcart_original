package com.wandrstick.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

/* Products List with name, description, price, quantity on hand.*/

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String description;
    private Float price;
    private Long quantityOnHand;

    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private Set<Orders> orders;

    public Products() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(long quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
