package com.lambdaschool.shoppingcart.controllers;

import com.lambdaschool.shoppingcart.models.*;
import com.lambdaschool.shoppingcart.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingController {

    @Autowired
    OrderRepo orderRepo;

    @GetMapping(value = "")
    public List<Order> listAllOrders(){
        return orderRepo.findAll();
    }


    @GetMapping(value = "/orders/id/{orderId}")
    public Optional<Order> getProductsByName(@PathVariable long orderId){
        return orderRepo.findById(orderId);
    }
}
