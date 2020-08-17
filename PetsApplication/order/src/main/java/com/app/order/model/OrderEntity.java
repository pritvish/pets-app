package com.app.order.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderEntity {

    @Id
    private Integer orderId;
    private Integer petId;
    private String orderShipmentStatus;

    public OrderEntity(Integer orderId, Integer petId, String orderShipmentStatus) {
        this.orderId = orderId;
        this.petId = petId;
        this.orderShipmentStatus = orderShipmentStatus;
    }

    public OrderEntity() {

    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getOrderShipmentStatus() {
        return orderShipmentStatus;
    }

    public void setOrderShipmentStatus(String orderShipmentStatus) {
        this.orderShipmentStatus = orderShipmentStatus;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", petId=" + petId +
                ", orderShipmentStatus='" + orderShipmentStatus + '\'' +
                '}';
    }
}
