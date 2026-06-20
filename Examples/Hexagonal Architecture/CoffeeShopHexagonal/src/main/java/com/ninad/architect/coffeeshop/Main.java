package com.ninad.architect.coffeeshop;

import com.ninad.architect.coffeeshop.adapters.ApiMenuService;
import com.ninad.architect.coffeeshop.adapters.DatabaseOrderService;
import com.ninad.architect.coffeeshop.core.CoffeeShop;

public class Main {
  public static void main(String[] args) {
    var orderAdapter = new DatabaseOrderService();
    var menuAdapter = new ApiMenuService();

    var coffeeShop = new CoffeeShop(orderAdapter, menuAdapter);

    coffeeShop.placeOrder("Latte", 2);
    System.out.println(coffeeShop.getMenu());
  }
}
