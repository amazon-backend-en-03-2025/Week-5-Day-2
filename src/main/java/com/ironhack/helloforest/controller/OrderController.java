package com.ironhack.helloforest.controller;

import com.ironhack.helloforest.model.Order;
import com.ironhack.helloforest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }


    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") Long orderId, @RequestBody Order order) {
        return orderService.updateOrder(orderId, order);
    }

    @PatchMapping("/{id}/email")
    public Order updateOrderEmail(@PathVariable("id") Long orderId,
                                  @RequestBody String email) {

        return  orderService.updateOrderEmail(orderId, email);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
