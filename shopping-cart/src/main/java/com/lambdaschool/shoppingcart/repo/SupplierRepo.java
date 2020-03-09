package com.lambdaschool.shoppingcart.repo;

import com.lambdaschool.shoppingcart.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
}