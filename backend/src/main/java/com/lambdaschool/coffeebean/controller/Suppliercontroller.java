package com.lambdaschool.coffeebean.controller;

import com.lambdaschool.coffeebean.model.Supplier;
import com.lambdaschool.coffeebean.repository.Supplierrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
public class Suppliercontroller
{
    @Autowired
    Supplierrepository suppplierrepos;

    @GetMapping("")
    public List<Supplier> findAllOrders()
    {
        return suppplierrepos.findAll();
    }
}
