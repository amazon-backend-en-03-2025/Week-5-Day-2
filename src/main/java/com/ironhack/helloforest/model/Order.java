package com.ironhack.helloforest.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private Long id;

    private String customerName;

    private String customerEmail;

    private List<OrderItem> orderItems;

    private BigDecimal totalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order(Long id,
                 String customerName,
                 String customerEmail,
                 List<OrderItem> orderItems,
                 BigDecimal totalAmount) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
    }
}
