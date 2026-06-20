package com.example.coffeeshop.core;

import com.example.coffeeshop.ports.MenuService;
import com.example.coffeeshop.ports.OrderService;

public class CoffeeShop {
  private final OrderService orderService;
  private final MenuService menuService;

  public CoffeeShop(OrderService orderService, MenuService menuService) {
    this.orderService = orderService;
    this.menuService = menuService;
  }

  public void placeOrder(String item, int quantity) {
    // Core business logic can validate, apply rules, etc.
    orderService.placeOrder(item, quantity);
  }

  public String getMenu() {
    return menuService.getMenu();
  }
}
