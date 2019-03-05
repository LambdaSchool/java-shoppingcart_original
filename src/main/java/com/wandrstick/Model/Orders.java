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
    private Long order_id;

    private Long order_quantity;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    @JsonIgnoreProperties("orders")
    private Set<Products> products;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_orders",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private Set<Customer> customers;

    public Orders() {
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(Long order_quantity) {
        this.order_quantity = order_quantity;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
