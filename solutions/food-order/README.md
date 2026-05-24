# 🍔 Activity 2: Food Order System - Solution

## 🎯 Objective

This solution demonstrates combining the **Builder Pattern** and **Factory Pattern** to design a flexible and maintainable Food Order System in Java.

The system supports creating different meal types with optional customizations using clean and readable method chaining.

---

## 🧠 Solution Explanation

### Step 1: Identified Main Components

* `Meal`
* `BurgerMeal`
* `PizzaMeal`
* `SaladMeal`
* `MealFactory`
* `Main`

---

### Step 2: Applied Design Patterns

#### ✅ Builder Pattern

Used to construct meal objects step-by-step while supporting optional customizations such as:

* Extra cheese
* Drinks
* Sauce
* Fries
* Special notes

Each meal type has its own `Builder` class.

---

#### ✅ Factory Pattern

Used to centralize the creation of builders.

`MealFactory` returns:

* `BurgerMeal.Builder`
* `PizzaMeal.Builder`
* `SaladMeal.Builder`

This reduces coupling between client code and concrete meal classes.

---

### Step 3: UML Diagram Representation

```text id="6k92ha"
+----------------------+
|        Meal          |
+----------------------+
| +prepare(): void     |
+----------------------+
           ▲
           |
 ---------------------------------------------------------
 |                        |                              |
 |                        |                              |
+----------------+  +----------------+  +----------------+
|   BurgerMeal   |  |   PizzaMeal    |  |   SaladMeal    |
+----------------+  +----------------+  +----------------+
| - customerName |  | - customerName |  | - customerName |
| - size         |  | - size         |  | - size         |
| - totalPrice   |  | - totalPrice   |  | - totalPrice   |
| - extraCheese  |  | - extraCheese  |  | - drink        |
| - fries        |  | - drink        |  | - sauce        |
| - drink        |  | - sauce        |  | - specialNotes |
| - sauce        |  | - specialNotes |  +----------------+
| - specialNotes |  +----------------+
+----------------+

        Each Meal Class
                |
                ▼
        +----------------+
        |    Builder     |
        +----------------+
        | +build()       |
        | +set...()      |
        +----------------+

+-----------------------------------+
|          MealFactory              |
+-----------------------------------+
| +getBuilder(type): Object         |
+-----------------------------------+
```

---

### Step 4: Java Implementation Highlights

* `Meal` interface defines common behavior for all meals.
* Each meal class is immutable after object creation.
* Builders validate required fields before building objects.
* Method chaining improves readability and flexibility.
* `MealFactory` centralizes builder creation logic.

---

### Example Meal Construction

```java id="y6g2pz"
BurgerMeal burger = ((BurgerMeal.Builder)
        MealFactory.getBuilder("BURGER"))
        .setCustomerName("Maryam")
        .setSize("Large")
        .setTotalPrice(12.5)
        .setExtraCheese(true)
        .setFries(true)
        .setDrink("Cola")
        .setSauce("BBQ")
        .build();
```

---

### Example Output

```text id="3w8rks"
Preparing Burger Meal for Maryam
Preparing Pizza Meal for Ahmad
Preparing Salad Meal for Sara
```

---

## ✅ Key Concepts Demonstrated

* Builder Pattern
* Factory Pattern
* Method Chaining (Fluent Interface)
* Encapsulation
* Immutable Objects
* Separation of Concerns
* Scalable Backend Design
* Object-Oriented Programming Principles

---

## 🚀 Advantages of This Design

* Centralizes meal creation logic
* Simplifies complex object construction
* Reduces duplicated code
* Easy to add new meal types
* Supports optional parameters cleanly
* Improves readability and maintainability

---

## 📌 Key Insight

Combining **Builder** and **Factory Patterns** creates a clean and scalable architecture for systems that require:

* Complex object creation
* Multiple optional parameters
* Centralized construction logic
* Easy future extensibility
