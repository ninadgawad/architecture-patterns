package com.ninad.architect.coffeeshop.adapters;

import com.ninad.architect.coffeeshop.ports.OrderService;

public class DatabaseOrderService implements OrderService {
  @Override
  public void placeOrder(String item, int quantity) {
    System.out.println("[DatabaseOrderService] Saved order: " + item + " x" + quantity);
  }
}
