package com.wandrstick.Repository;

import com.wandrstick.Model.Orders;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
//    Optional<Orders> findByorder_id(Long orderId);

//    Page<Orders> findByCreatedBy(Long userId, Pageable pageable);
//
//    long countByCreatedBy(Long userId);
//
//    List<Orders> findByIdIn(List<Long> pollIds);
//
//    List<Order> findByIdIn(List<Long> pollIds, Sort sort);
}
