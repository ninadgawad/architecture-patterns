package com.example.coffeeshop.adapters;

import com.example.coffeeshop.ports.MenuService;

public class ApiMenuService implements MenuService {
  @Override
  public String getMenu() {
    // Simulate fetching menu from an external API
    return "Fetched menu from API: Latte, Espresso, Cappuccino";
  }
}
