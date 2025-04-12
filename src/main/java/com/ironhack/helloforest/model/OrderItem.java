package com.ironhack.helloforest.model;

import java.math.BigDecimal;

public class OrderItem {

    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public OrderItem(Long id) {
        this.id = id;
    }
}
