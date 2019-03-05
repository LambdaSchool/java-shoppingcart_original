package com.wandrstick.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/* Customer with billing and shipping addresses, phone numbers, payment method. */

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    @JsonIgnoreProperties("customers")
    private Set<PaymentMethods> paymentMethods;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    @JsonIgnoreProperties("customers")
    private Set<Orders> orders;

    public Customer() {
    }

    public Set<PaymentMethods> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Set<PaymentMethods> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
