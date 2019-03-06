package com.lambdaschool.coffeebean.controller;

import com.lambdaschool.coffeebean.model.Product;
import com.lambdaschool.coffeebean.repository.Productrepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Some value... by DKM", description = "Shop Controller by DKM")
@RestController
@RequestMapping(path = "/shop", produces = MediaType.APPLICATION_JSON_VALUE)
public class Shopcontroller
{
    @Autowired
    Productrepository productrepos;

    @GetMapping("")
    public List<Product> getAllProducts()
    {
        return productrepos.findAll();
    }
}
