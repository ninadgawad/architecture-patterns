package com.example.coffeeshop.adapters;

import com.example.coffeeshop.ports.OrderService;

public class DatabaseOrderService implements OrderService {
  @Override
  public void placeOrder(String item, int quantity) {
    // Simulate persisting an order
    System.out.println("[DatabaseOrderService] Saved order: " + item + " x" + quantity);
  }
}
