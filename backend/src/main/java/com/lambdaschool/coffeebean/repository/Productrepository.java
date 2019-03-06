package com.lambdaschool.coffeebean.repository;

import com.lambdaschool.coffeebean.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepository extends JpaRepository<Product, Long>
{
}
