package com.chubb.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.chubb.request.Order1;
import com.chubb.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository repo;

    @Autowired
    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order1 insertOrder(Order1 order) {
        Order1 saved = repo.save(order);
        System.out.println("Order Saved with id: " + saved.getId());
        return saved;
    }
}
