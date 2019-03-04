package com.wandrstick.Model;

import javax.persistence.*;

/* Shoppers with billing and shipping addresses, phone numbers, payment method.
*/
@Entity
@Table(name = "shoppers")
public class Shoppers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopperId;

    private String billingAddress;
    private String shippingAddress;
    private String phoneNumber;
    private String paymentMethod;

    public Shoppers() {
    }

    public long getShopperId() {
        return shopperId;
    }

    public void setShopperId(long shopperId) {
        this.shopperId = shopperId;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
