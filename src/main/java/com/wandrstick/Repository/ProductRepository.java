package com.wandrstick.Repository;

import com.wandrstick.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Products, Long> {

}
