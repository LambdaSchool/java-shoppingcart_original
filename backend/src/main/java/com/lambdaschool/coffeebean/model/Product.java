package com.lambdaschool.coffeebean.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;

    private String productname;

    private String description;

    private double price;

    private int quantity;

    private String image;

    // *** ManyToOne with order ***
    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonIgnoreProperties("productsinorder")
    private Order order;

    // *** ManyToMany with customer - cart - subowner ***
    @ManyToMany(mappedBy = "productsincart")
    @JsonIgnoreProperties("productsincart")
    private Set<Customer> potentialcustomers;

    // *** ManyToMany with customer - orderhistory - subowner ***
    @ManyToMany(mappedBy = "orderhistory")
    @JsonIgnoreProperties("orderhistory")
    private Set<Customer> productcustomers;

    // *** ManyToMany with supplier - subowner ***
    @ManyToMany(mappedBy = "productsfromsupplier")
    @JsonIgnoreProperties("productsfromsupplier")
    private Set<Supplier> suppliers;

    public Product()
    {
    }

    public long getProductid()
    {
        return productid;
    }

    public void setProductid(long productid)
    {
        this.productid = productid;
    }

    public String getProductname()
    {
        return productname;
    }

    public void setProductname(String productname)
    {
        this.productname = productname;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    public Set<Customer> getPotentialcustomers()
    {
        return potentialcustomers;
    }

    public void setPotentialcustomers(Set<Customer> potentialcustomers)
    {
        this.potentialcustomers = potentialcustomers;
    }

    public Set<Customer> getProductcustomers()
    {
        return productcustomers;
    }

    public void setProductcustomers(Set<Customer> productcustomers)
    {
        this.productcustomers = productcustomers;
    }

    public Set<Supplier> getSuppliers()
    {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers)
    {
        this.suppliers = suppliers;
    }
}
