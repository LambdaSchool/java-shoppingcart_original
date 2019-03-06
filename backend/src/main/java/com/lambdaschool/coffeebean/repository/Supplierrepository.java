package com.lambdaschool.coffeebean.repository;

import com.lambdaschool.coffeebean.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Supplierrepository extends JpaRepository<Supplier, Long>
{
}
