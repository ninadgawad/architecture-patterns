package com.ninad.architect.coffeeshop.core;

import com.ninad.architect.coffeeshop.ports.MenuService;
import com.ninad.architect.coffeeshop.ports.OrderService;

public class CoffeeShop {
  private final OrderService orderService;
  private final MenuService menuService;

  public CoffeeShop(OrderService orderService, MenuService menuService) {
    this.orderService = orderService;
    this.menuService = menuService;
  }

  public void placeOrder(String item, int quantity) {
    orderService.placeOrder(item, quantity);
  }

  public String getMenu() {
    return menuService.getMenu();
  }
}
