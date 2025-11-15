package com.chubb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.chubb.request.Order1;
import com.chubb.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public String getOrder() {
        return "hello";
    }

    @PostMapping
    public Order1 saveOrder(@Valid @RequestBody Order1 order) {
        return service.insertOrder(order);
    }
}
