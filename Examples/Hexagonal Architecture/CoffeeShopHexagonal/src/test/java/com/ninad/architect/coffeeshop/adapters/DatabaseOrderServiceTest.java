package com.ninad.architect.coffeeshop.adapters;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseOrderServiceTest {

  @Test
  void placeOrderPrintsSavedMessage() {
    var svc = new DatabaseOrderService();
    var out = new ByteArrayOutputStream();
    var original = System.out;
    try {
      System.setOut(new PrintStream(out));
      svc.placeOrder("Latte", 2);
    } finally {
      System.setOut(original);
    }
    var outStr = out.toString();
    assertTrue(outStr.contains("Saved order"));
    assertTrue(outStr.contains("Latte"));
  }
}
