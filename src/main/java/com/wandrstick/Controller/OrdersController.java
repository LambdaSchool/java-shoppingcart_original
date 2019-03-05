package com.wandrstick.Controller;

import com.wandrstick.Model.Orders;
import com.wandrstick.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders/", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {
   @Autowired
    OrdersRepository ordersrepo;

   @GetMapping("/orders")
    public List<Orders> listAllOrders() {
       return ordersrepo.findAll();
   }

}
