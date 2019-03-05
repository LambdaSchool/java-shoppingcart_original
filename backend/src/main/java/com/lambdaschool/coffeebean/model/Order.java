package com.lambdaschool.coffeebean.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
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

    private List<Product> itemsinorder;

    //*** ManyToOne with customer ***
    @ManyToOne
    @JoinColumn(name = "customerid")
    @JsonIgnoreProperties("orders")
    private Customer customer;

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

    public List<Product> getItemsinorder()
    {
        return itemsinorder;
    }

    public void setItemsinorder(List<Product> itemsinorder)
    {
        this.itemsinorder = itemsinorder;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
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
