package com.lambdaschool.coffeebean.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
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


    //MySQL uses yyyy-mm-dd format for storing a date value
    // Not sure how to do date yet
    private java.sql.Date expiration;

    private String image;

    // *** ManyToMany with order - orderproducts - subowner***
    @ManyToMany(mappedBy = "orderproducts", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"orderproducts", "user"})
    private Set<Order> productorders;

    // *** ManyToMany with user - cart - subowner ***
//    @JsonIgnore
    @ManyToMany(mappedBy = "productsincart", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"productsincart", "orderhistory", "totalorderhistory"})
    private Set<User> potentialusers;

    // *** ManyToMany with user - orderhistory - subowner ***
//    @JsonIgnore
    @ManyToMany(mappedBy = "totalorderhistory", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"productsincart", "orderhistory", "totalorderhistory"})
    private Set<User> productusers;

    // *** ManyToMany with supplier - subowner ***
//    @JsonIgnore
    @ManyToMany(mappedBy = "productsfromsupplier", fetch = FetchType.EAGER)
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

    public Date getExpiration()
    {
        return expiration;
    }

    public void setExpiration(Date expiration)
    {
        this.expiration = expiration;
    }

    public Set<Order> getProductorders()
    {
        return productorders;
    }

    public void setProductorders(Set<Order> productorders)
    {
        this.productorders = productorders;
    }

    public Set<User> getPotentialusers()
    {
        return potentialusers;
    }

    public void setPotentialusers(Set<User> potentialusers)
    {
        this.potentialusers = potentialusers;
    }

    public Set<User> getProductusers()
    {
        return productusers;
    }

    public void setProductusers(Set<User> productusers)
    {
        this.productusers = productusers;
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
