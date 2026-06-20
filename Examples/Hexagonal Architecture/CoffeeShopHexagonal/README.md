# Coffee Shop Hexagonal Architecture Example (Java 21)

This project demonstrates the **Hexagonal Architecture** pattern applied to a Coffee Shop system using Java 21.

## Overview

**Hexagonal Architecture** (Ports & Adapters) isolates business logic (core) from external concerns (adapters).

## Structure

```
src/main/java/com/example/coffeeshop/
  core/
    CoffeeShop.java
  ports/
    OrderService.java
    MenuService.java
  adapters/
    DatabaseOrderService.java
    ApiMenuService.java
  Main.java
```

## Build & Run

Requires Java 21 and Maven.

Build:

```bash
mvn -q -DskipTests package
```

Run:

```bash
mvn -q exec:java -Dexec.mainClass="com.example.coffeeshop.Main"
```

