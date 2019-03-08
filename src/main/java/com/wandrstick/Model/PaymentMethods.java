package com.wandrstick.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payment_methods")
public class PaymentMethods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long method_id;

    @Column(nullable = false)
    private String payment_method;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_payment_methods",
            joinColumns = {@JoinColumn(name = "method_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<User> users;

    public PaymentMethods() {
    }

    public Long getMethod_id() {
        return method_id;
    }

    public void setMethod_id(Long method_id) {
        this.method_id = method_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
