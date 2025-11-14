package com.chubb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.chubb.request.Order;

import jakarta.validation.Valid;

@RestController
public class OrderController {
  @GetMapping("/order")
  String getOrder() {
    return "hello";
  }

  @PostMapping("/order")
  public Order saveOrder(@RequestBody @Valid Order order) {
    return order;
  }
}
