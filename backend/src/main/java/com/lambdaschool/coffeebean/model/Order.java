package com.lambdaschool.coffeebean.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;

    private String shippingaddress;

    private String paymentdetails;

    private boolean shippedstatus;

    //*** ManyToOne with user ***
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("orders")
    private User user;

    // *** OneToMany with product ***
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonIgnoreProperties("order")
    private Set<Product> productsinorder;

    public Order()
    {
    }

    public long getOrderid()
    {
        return orderid;
    }

    public void setOrderid(long orderid)
    {
        this.orderid = orderid;
    }

    public String getShippingaddress()
    {
        return shippingaddress;
    }

    public void setShippingaddress(String shippingaddress)
    {
        this.shippingaddress = shippingaddress;
    }

    public String getPaymentdetails()
    {
        return paymentdetails;
    }

    public void setPaymentdetails(String paymentdetails)
    {
        this.paymentdetails = paymentdetails;
    }

    public boolean isShippedstatus()
    {
        return shippedstatus;
    }

    public void setShippedstatus(boolean shippedstatus)
    {
        this.shippedstatus = shippedstatus;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Set<Product> getProductsinorder()
    {
        return productsinorder;
    }

    public void setProductsinorder(Set<Product> productsinorder)
    {
        this.productsinorder = productsinorder;
    }
}
