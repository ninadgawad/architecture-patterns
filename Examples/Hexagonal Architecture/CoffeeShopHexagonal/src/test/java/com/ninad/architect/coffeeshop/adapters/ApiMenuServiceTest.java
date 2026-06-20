package com.ninad.architect.coffeeshop.adapters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiMenuServiceTest {

  @Test
  void getMenuReturnsExpectedString() {
    var svc = new ApiMenuService();
    var menu = svc.getMenu();
    assertTrue(menu.contains("Latte"));
    assertTrue(menu.contains("Espresso"));
  }
}
