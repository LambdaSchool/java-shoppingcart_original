package com.lambdaschool.shoppingcart.repo;


import com.lambdaschool.shoppingcart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}