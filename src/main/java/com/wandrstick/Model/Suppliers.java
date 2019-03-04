package com.wandrstick.Model;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierId;

    private String supplierName;

}
