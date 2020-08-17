package com.app.order.service;

import com.app.order.model.OrderDTO;
import com.app.order.model.OrderEntity;
import com.app.order.model.PetDTO;
import com.app.order.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO createOrder(OrderEntity orderEntity) {
        OrderEntity savedOrder = null;
        PetDTO petDTOResponseEntity = restTemplate.getForObject("http://localhost:8080/pet?id=" + orderEntity.getPetId(), PetDTO.class);
        if(orderEntity.getPetId().equals(petDTOResponseEntity.getPetId())) {
            savedOrder = orderRepository.save(orderEntity);
        }
        return convertToOrderDTO(savedOrder);
    }

    public List<OrderDTO> fetchAllOrders() {
        List<OrderEntity> allOrders = orderRepository.findAll();
        return allOrders.stream()
                .map(this::convertToOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO findOrderById(Integer id) {
        OrderEntity orderById = orderRepository.findOrderByOrderId(id);
        return convertToOrderDTO(orderById);
    }

    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }

    public OrderDTO convertToOrderDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDTO.class);
    }
}
