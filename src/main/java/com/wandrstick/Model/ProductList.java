package com.wandrstick.Model;

import javax.persistence.*;

/* Product List with name, description, price, quantity on hand.*/

@Entity
@Table(name="productList")
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;

    private String name;
    private String description;
    private float price;
    private long quantityOnHand;

    public ProductList() {
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
