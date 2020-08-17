package com.app.order.repository;

import com.app.order.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    public OrderEntity findOrderByOrderId(Integer orderId);
//    public OrderEntity findOrderByIdAndStatus(Integer id, String status); TODO test this piece of code later

}
