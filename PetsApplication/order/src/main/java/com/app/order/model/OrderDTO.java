package com.app.order.model;

public class OrderDTO {

    private Integer orderId;
    private Integer petId;
    private String orderShipmentStatus;

    public OrderDTO(Integer orderId, Integer petId, String orderShipmentStatus) {
        this.orderId = orderId;
        this.petId = petId;
        this.orderShipmentStatus = orderShipmentStatus;
    }

    public OrderDTO() {

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
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", petId=" + petId +
                ", orderShipmentStatus='" + orderShipmentStatus + '\'' +
                '}';
    }
}
