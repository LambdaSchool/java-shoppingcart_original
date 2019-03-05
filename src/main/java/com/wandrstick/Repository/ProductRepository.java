package com.wandrstick.Repository;

import com.wandrstick.Model.Products;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query(value="SELECT * FROM products", nativeQuery = true)
    List<Object[]> findAllProduct();
}
