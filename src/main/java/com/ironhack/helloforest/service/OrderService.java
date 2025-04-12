package com.ironhack.helloforest.service;

import com.ironhack.helloforest.exception.OrderNotFoundException;
import com.ironhack.helloforest.model.Order;
import com.ironhack.helloforest.model.OrderItem;
import jakarta.annotation.PostConstruct;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orderStorage;
    private static Long currentOrderId = 1L;

    @PostConstruct
    private void initStorage() {
        Faker faker = new Faker();

        orderStorage = new ArrayList<>(
                List.of(
                        new Order(currentOrderId++,
                                faker.funnyName().name(),
                                faker.internet().emailAddress(),
                                List.of(
                                        new OrderItem(1L),
                                        new OrderItem(2L),
                                        new OrderItem(3L)
                                ),
                                new BigDecimal("10")),
                        new Order(currentOrderId++,
                                faker.funnyName().name(),
                                faker.internet().emailAddress(),
                                List.of(
                                        new OrderItem(1L),
                                        new OrderItem(2L)
                                ),
                                new BigDecimal("60"))

                )
        );
    }

    public List<Order> getOrders() {
        return orderStorage;
    }

    public Order getOrderById(Long id) {
        for (Order retrievedOrder : orderStorage){
            if (retrievedOrder.getId() == id){
                return retrievedOrder;
            }
        }
        throw new OrderNotFoundException("Order with id " + id + " not found");
    }

    public Order createOrder(Order order){
        order.setId(currentOrderId++);
        orderStorage.add(order);
        return order;
    }

    public Order updateOrder(Long id, Order order) {
        for (Order retrievedOrder : orderStorage){
            if (retrievedOrder.getId() == id){
                retrievedOrder.setCustomerName(order.getCustomerName());
                retrievedOrder.setCustomerEmail(order.getCustomerEmail());
                retrievedOrder.setOrderItems(order.getOrderItems());
                retrievedOrder.setTotalAmount(order.getTotalAmount());
                return retrievedOrder;
            }
        }
        return null;
    }

    public Order updateOrderEmail(Long id, String email){
        for (Order retrievedOrder : orderStorage){
            if (retrievedOrder.getId() == id){
                retrievedOrder.setCustomerEmail(email);
                return retrievedOrder;
            }
        }
        return null;
    }

    public void deleteOrder(Long id) {
        for (Order retrievedOrder : orderStorage){
            if (retrievedOrder.getId() == id){
                orderStorage.remove(retrievedOrder);
                break;
            }
        }
    }

}
