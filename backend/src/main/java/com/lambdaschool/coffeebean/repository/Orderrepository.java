package com.lambdaschool.coffeebean.repository;

import com.lambdaschool.coffeebean.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orderrepository extends JpaRepository<Order, Long>
{
}
