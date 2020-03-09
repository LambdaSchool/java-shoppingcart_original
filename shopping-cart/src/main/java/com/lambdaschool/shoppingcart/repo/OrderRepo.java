package com.lambdaschool.shoppingcart.repo;


import com.lambdaschool.shoppingcart.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}