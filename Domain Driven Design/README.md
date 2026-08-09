# Domain Driven Design: A Gentle Introduction 

If you've ever stood in a busy coffee shop and watched the choreography — the barista calling out drinks, the cashier managing orders, the kitchen handling food separately — you've already witnessed Domain Driven Design (DDD) in action. You just didn't know it yet.

DDD, introduced by Eric Evans in his 2003 book, is an approach to software design that puts the **business domain** at the center of every technical decision. Instead of starting with databases or frameworks, you start by deeply understanding the problem space — and you let that understanding shape your code.

## Ubiquitous Language

The first and most important concept in DDD is **Ubiquitous Language** — a shared vocabulary between developers and domain experts that everyone uses consistently in conversations, documentation, and code.

In our coffee shop, terms like *Order*, *Barista*, *Menu Item*, *Customization* (extra shot, oat milk), and *Pickup Queue* mean the same thing whether you're talking to the shop owner or reading the source code. If the staff says "tall" means 12oz, then `Size.TALL` in code also means 12oz — no translation layer, no ambiguity.

## Entities and Value Objects

**Entities** are objects with a distinct identity that persists over time. An `Order` is an entity: Order #247 is unique even if another order has the exact same items. It has a lifecycle — placed, in-progress, ready, picked up.

**Value Objects** have no identity; they're defined entirely by their attributes. A `Price` of $5.50 is a value object — one $5.50 is interchangeable with any other $5.50. Similarly, a `DrinkCustomization` (e.g., "oat milk, extra hot, no foam") is a value object. Two identical customizations are the same thing; there's no reason to track them individually.

## Aggregates and Aggregate Roots

An **Aggregate** is a cluster of entities and value objects treated as a single unit for data changes. The **Aggregate Root** is the entry point — all modifications go through it.

An `Order` is our aggregate root. It contains `LineItems` (a latte, a muffin), each with `Customizations`. You never modify a `LineItem` directly from outside — you always go through the `Order`: `order.addItem(latte)`, `order.removeItem(muffin)`. This protects business rules like "you can't modify an order after the barista starts making it."

## Bounded Contexts

This is where DDD truly shines. A **Bounded Context** is a boundary within which a particular model applies. The same real-world thing can mean different things in different contexts.

Consider the word "Order" across our coffee shop's systems. In the **Ordering Context** (the register), an Order is about menu items, prices, and payment. In the **Preparation Context** (behind the counter), an Order is a sequence of drink recipes and preparation steps — price is irrelevant. In the **Inventory Context**, there are no orders at all; the system cares about ingredient stock levels and reorder thresholds.

Each bounded context owns its own model, its own ubiquitous language, and its own data. This separation prevents a single bloated `Order` class from trying to serve every purpose.

## Context Mapping

Bounded contexts don't live in isolation — they communicate. A **Context Map** describes the relationships between them. Common patterns include:

- **Customer-Supplier**: The Ordering context (supplier) publishes order events that the Preparation context (customer) consumes. The supplier shapes the contract.
- **Anti-Corruption Layer**: If our shop integrates with a third-party delivery platform, we build a translation layer so their messy external model doesn't leak into our clean domain model.
- **Shared Kernel**: The Ordering and Loyalty contexts might share a small `CustomerId` definition rather than each inventing their own.

## Domain Events

A **Domain Event** captures something meaningful that happened in the domain. Events are named in past tense using ubiquitous language: `OrderPlaced`, `DrinkPrepared`, `OrderPickedUp`.

When a barista finishes a latte, the Preparation context publishes `DrinkPrepared`. The Notification context listens and calls out the customer's name. The Analytics context listens and updates average preparation time. Events decouple contexts cleanly.

## Domain Services

Some operations don't naturally belong to any single entity. A **Domain Service** handles these. In our coffee shop, calculating the final price of an order might require checking loyalty discounts, applying seasonal promotions, and adding tax. This logic spans multiple concepts, so a `PricingService` encapsulates it rather than forcing it into the `Order` entity.

## Repositories and Factories

A **Repository** provides the illusion of an in-memory collection of aggregates. `OrderRepository.findById(247)` retrieves Order #247 regardless of whether it lives in Postgres, MongoDB, or a sticky note. The domain layer never knows about database details.

A **Factory** encapsulates complex creation logic. Building a "Holiday Special" order with pre-set customizations, a bundled pastry, and a seasonal cup sleeve is complex enough to warrant an `OrderFactory` rather than a sprawling constructor.

## Layered Architecture

DDD typically organizes code into layers: **Domain** (entities, value objects, services — pure business logic with zero framework dependencies), **Application** (orchestrates use cases like `PlaceOrderUseCase`), **Infrastructure** (databases, messaging, external APIs), and **Interface** (REST controllers, UI). Dependencies always point inward — infrastructure depends on the domain, never the reverse.

## When to Use DDD

DDD is powerful but not free. It introduces complexity that pays off in domains with rich business rules, multiple stakeholders, and evolving requirements — exactly the kind of systems where "just use CRUD" falls apart within six months. For a simple static website or a straightforward data pipeline, DDD is overkill.

For our coffee shop, once you move beyond a single register into multi-location operations with loyalty programs, mobile ordering, inventory management, and delivery integrations, DDD gives you the conceptual tools to keep that complexity organized and maintainable.

The real insight of DDD isn't any single pattern — it's the discipline of listening to your domain experts, speaking their language, and letting the business shape the software rather than the other way around.
