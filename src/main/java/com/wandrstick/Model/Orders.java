package com.wandrstick.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wandrstick.Model.Audit.UserDateAudit;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;
/* Orders with product and quantity orders, plus shipping addresses, payment details, and shipped status.
 */

@Entity
@JsonIgnoreProperties({"orders"})
@Table(name = "orders")
public class Orders extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @NotBlank
    @Min(1)
    @Max(50)
    private Long order_quantity;

    private boolean pending;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    @JsonIgnoreProperties("orders")
    private Set<Products> products;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("users")
    @JoinTable(name = "user_orders",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
