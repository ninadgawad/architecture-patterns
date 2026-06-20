package com.example.coffeeshop;

import com.example.coffeeshop.adapters.ApiMenuService;
import com.example.coffeeshop.adapters.DatabaseOrderService;
import com.example.coffeeshop.core.CoffeeShop;

public class Main {
  public static void main(String[] args) {
    var orderAdapter = new DatabaseOrderService();
    var menuAdapter = new ApiMenuService();

    var coffeeShop = new CoffeeShop(orderAdapter, menuAdapter);

    // Use adapters via core
    coffeeShop.placeOrder("Latte", 2);
    System.out.println(coffeeShop.getMenu());
  }
}
