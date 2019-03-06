package com.lambdaschool.coffeebean.controller;

import com.lambdaschool.coffeebean.model.Product;
import com.lambdaschool.coffeebean.repository.Productrepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Some value... by DKM", description = "Product Controller by DKM")
@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class Productcontroller
{
    @Autowired
    Productrepository productrepos;

    @ApiOperation(value = "find all orders - DKM", response = Product.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully received customer - DKM"),
                    @ApiResponse(code = 401, message = "You are not authorized to the view the resource - DKM"),
                    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden - DKM"),
                    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found - DKM")
            })
    @GetMapping("")
    public List<Product> findAllOrders()
    {
        return productrepos.findAll();
    }


}