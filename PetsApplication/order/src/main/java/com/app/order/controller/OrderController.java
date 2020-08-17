package com.app.order.controller;

import com.app.order.model.OrderDTO;
import com.app.order.model.OrderEntity;
import com.app.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderEntity orderEntity) {
        OrderDTO orderDTO = orderService.createOrder(orderEntity);
        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<OrderDTO> getOrderById(@RequestParam Integer id) {
        OrderDTO orderDTO = orderService.findOrderById(id);
        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orderDTOList = orderService.fetchAllOrders();
        return new ResponseEntity<List<OrderDTO>>(orderDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/order")
    public ResponseEntity<String> deleteOrder(@RequestParam Integer id) {
        orderService.deleteOrderById(id);
        return new ResponseEntity<String>("successfully deleted the order with order id : "+id, HttpStatus.OK);
    }

}
