package com.lambdaschool.coffeebean.controller;

import com.lambdaschool.coffeebean.model.Order;
import com.lambdaschool.coffeebean.repository.Orderrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class Ordercontroller
{
    @Autowired
    Orderrepository orderrepos;

    @GetMapping("")
    public List<Order> findAllOrders()
    {
        return orderrepos.findAll();
    }
}