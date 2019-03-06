package com.wandrstick.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/* Customer with billing and shipping addresses, phone numbers, payment method. */

@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "emailAddress"
        })
})
@JsonIgnoreProperties({"paymentMethods","addresses","orders"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @NotBlank
    @Size(max = 40)
    private String firstName;

    private String middleName;

    @NotBlank
    @Size(max = 40)
    private String lastName;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String emailAddress;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    private String username;

    @NotBlank
    @Size(min = 6, max = 50)
    private String password;

    private String role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties({"customer"})
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private Set<PaymentMethods> paymentMethods;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    @JsonIgnoreProperties("customers")
    private Set<Orders> orders;

    public Customer(@NotBlank @Size(max = 40) String firstName, String middleName, @NotBlank @Size(max = 40) String lastName, @NotBlank @Size(max = 40) @Email String emailAddress, @NotBlank @Size(max = 40) String username, @NotBlank @Size(min = 6, max = 50) String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    public Customer() {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
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
}
