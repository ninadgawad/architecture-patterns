package com.ninad.architect.coffeeshop.adapters;

import com.ninad.architect.coffeeshop.ports.MenuService;

public class ApiMenuService implements MenuService {
  @Override
  public String getMenu() {
    return "Fetched menu from API: Latte, Espresso, Cappuccino";
  }
}
