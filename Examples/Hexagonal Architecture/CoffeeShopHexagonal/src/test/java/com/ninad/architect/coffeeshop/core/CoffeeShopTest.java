package com.ninad.architect.coffeeshop.core;

import com.ninad.architect.coffeeshop.ports.MenuService;
import com.ninad.architect.coffeeshop.ports.OrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeShopTest {

  static class StubOrderService implements OrderService {
    String lastItem;
    int lastQty;

    @Override
    public void placeOrder(String item, int quantity) {
      this.lastItem = item;
      this.lastQty = quantity;
    }
  }

  static class StubMenuService implements MenuService {
    @Override
    public String getMenu() {
      return "TestMenu: A,B";
    }
  }

  @Test
  void placeOrderDelegatesToOrderService() {
    var order = new StubOrderService();
    var menu = new StubMenuService();
    var cs = new CoffeeShop(order, menu);

    cs.placeOrder("Latte", 3);
    assertEquals("Latte", order.lastItem);
    assertEquals(3, order.lastQty);
  }

  @Test
  void getMenuReturnsFromMenuService() {
    var order = new StubOrderService();
    var menu = new StubMenuService();
    var cs = new CoffeeShop(order, menu);

    assertEquals("TestMenu: A,B", cs.getMenu());
  }
}
