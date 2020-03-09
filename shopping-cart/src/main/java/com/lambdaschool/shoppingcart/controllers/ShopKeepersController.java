package com.lambdaschool.shoppingcart.controllers;


import com.lambdaschool.shoppingcart.models.Order;
import com.lambdaschool.shoppingcart.models.Product;
import com.lambdaschool.shoppingcart.models.Supplier;
import com.lambdaschool.shoppingcart.repo.OrderRepo;
import com.lambdaschool.shoppingcart.repo.ProductRepo;
import com.lambdaschool.shoppingcart.repo.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopKeepersController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SupplierRepo supplierRepo;

    @GetMapping("/shopkeeper/orders")
    public List<Order> getAllOrders(){
        List<Order> tempList = orderRepo.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }

    @PostMapping("/shopkeeper/product")
    public Product addProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    @PutMapping("/shopkeeper/product/{productid}")
    public Product updateProductById(@RequestBody Product newProduct, @PathVariable long productid) throws URISyntaxException {
        Optional<Product> productToUpdate = productRepo.findById(productid);
        if (productToUpdate.isPresent()) {
            newProduct.setProductId(productid);
            productRepo.save(newProduct);
            return newProduct;
        }
        return null;
    }


    @PutMapping("/shopkeeper/supplier/{supplierid}")
    public Supplier updateSupplierById(@RequestBody Supplier newSupplier, @PathVariable long supplierid) throws URISyntaxException {
        Optional<Supplier> updateSupplier = supplierRepo.findById(supplierid);
        if (updateSupplier.isPresent()) {
            newSupplier.setSupplierId(supplierid);
            supplierRepo.save(newSupplier);
            return newSupplier;
        }
        return null;
    }

}
