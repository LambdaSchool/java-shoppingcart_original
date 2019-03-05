package com.wandrstick.Model;


import javax.persistence.*;
import java.util.Set;

/* Products List with name, description, price, quantity on hand.*/

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String productName;
    private String description;
    private Float price;
    private Long quantityOnHand;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_products",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private Set<Orders> orders;


    public Products() {
    }

    public Long getProductId() {
        return product_id;
    }

    public void setProductId(Long product_id) {
        this.product_id = product_id;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Long quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
