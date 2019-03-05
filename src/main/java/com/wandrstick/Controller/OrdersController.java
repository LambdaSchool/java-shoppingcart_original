package com.wandrstick.Controller;

import com.wandrstick.Model.Orders;
import com.wandrstick.Repository.OrdersRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Wandr Stick Application", description = "SMALL WEBSHOP FOR ORGANIC GOODS")


@RestController
@RequestMapping(path = "/orders/", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {
   @Autowired
    OrdersRepository ordersrepo;

   @ApiOperation(value = "List all orders", response = List.class)
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "Successfully retrieved list"),
           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
   })
   @GetMapping("/orders")
    public List<Orders> listAllOrders() {
       return ordersrepo.findAll();
   }

   @ApiOperation(value = "Customer based off of customer id", response = Orders.class)
   @GetMapping("/{id}")
    public Orders findOrderById(
            @ApiParam(value = "This is the order that you seek", required = true) @PathVariable long id) {
        var foundOrd = ordersrepo.findById(id);
        if (foundOrd.isPresent()) {
            return foundOrd.get();
        }
        else {
            return null;
        }
   }

}
