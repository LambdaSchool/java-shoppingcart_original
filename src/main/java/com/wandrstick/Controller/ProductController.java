package com.wandrstick.Controller;

import com.wandrstick.Model.Products;
import com.wandrstick.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productrepos;

    /* returns all the products with no filtering */
    @RequestMapping("/products")
    public List<Products> getAllProducts() {
        return productrepos.findAll();
    }
}
