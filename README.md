# 🏗️ Design Patterns Lab — Lecture 3: Builder Pattern

![Topic](https://img.shields.io/badge/Topic-Builder%20Pattern-blue)
![Week](https://img.shields.io/badge/Week-3-green)
![Language](https://img.shields.io/badge/Language-Java-orange)
![Focus](https://img.shields.io/badge/Focus-Creational%20Patterns-purple)

---

## 🎥 Lecture Video

This repository accompanies the lecture video explaining the **Builder Pattern** through:

- real backend problems  
- step-by-step object construction  
- UML relationships  
- and practical system design  

▶️ Watch on YouTube:

[Lecture Video](#)

---

## 📌 Overview

In the previous lecture, we studied the **Factory Pattern**, which helps us decide:

> 👉 **Which object should be created?**

In this lecture, we move forward to a different but related problem:

> 👉 **How do we build complex objects step by step?**

The **Builder Pattern** is a **creational design pattern** that helps us construct objects in a clean, readable, and flexible way — especially when the object contains many optional parameters.

---

## 🧠 Learning Goals

By the end of this lecture, students will be able to:

1. Understand why constructors fail with many optional parameters  
2. Recognize the **telescoping constructor problem**  
3. Apply the Builder Pattern to build complex objects  
4. Understand and explain **immutability** and why it is important  
5. Identify UML relationships in Builder-based designs:
   - **Composition** (Builder → Product)  
   - **Encapsulation** (private constructor)  
   - **Dependency** (Builder builds object)  
6. Understand the difference between:
   - Builder Pattern  
   - Factory Pattern  
   - Builder + Factory together  
7. Apply both patterns in real backend scenarios  

---

## ⚠️ Why Builder Pattern Matters

### Common Problems in Real Systems

In backend systems, we often create objects like:

- filters  
- queries  
- API requests  
- configuration objects  
- reports  
- orders  

These objects usually contain:

- required fields  
- many optional fields  

Using constructors in such cases leads to:

- long and unreadable parameter lists  
- confusion about parameter order  
- many overloaded constructors  
- difficult maintenance  
- high chance of bugs  

---

### 🚨 Example Problem

```java
SearchFilter filter = new SearchFilter(
    "Electronics", 100.0, 500.0, "Samsung", true
);
```

### 🚨 Problems

- What does `100.0` mean?  
- What does `true` represent?  
- What if we don’t need all parameters?  
- What if we add a new field later?  

---

## ✅ Benefits of Using Builder Pattern

- **Readability** → Clear and self-explanatory object creation  
- **Flexibility** → Only set what you need  
- **No Constructor Explosion** → Avoid multiple overloaded constructors  
- **Maintainability** → Easy to add new fields  
- **Validation** → Centralized in `build()`  
- **Immutability** → Safe and predictable objects  

> 💡 **Key Insight:**  
> Builder does not remove complexity — it organizes it in a clean and readable way.

---

## 🧩 Key Concepts

- **Product** → The final object being created  
- **Builder** → Responsible for constructing the object step by step  
- **Fluent Interface** → Method chaining (`return this`)  
- **build() Method** → Final step that creates the object  
- **Immutable Object** → Object cannot change after creation  

---

## 🔒 Immutability (Very Important)

### What is Immutability?

An immutable object is an object whose state **cannot change after it is created**.

---

### Why is it important?

- Prevents unexpected changes  
- Safer in multi-threaded environments  
- Easier to debug  
- Easier to reason about  
- Widely used in backend systems  

---

### When should we use it?

Use immutability when:

- the object represents **data**  
- the object should not change after creation  
- consistency is important  

#### Examples:

- filters  
- queries  
- request objects  
- configuration objects  

---

### Why Builder supports immutability

- Builder collects all values first  
- Object is created once using `build()`  
- Fields are set only once  
- No setters after creation  

---

## 🧩 UML — Builder Structure

### Builder Pattern Relationships

- **Composition** → Builder creates the object  
- **Encapsulation** → Constructor is private  
- **Dependency** → Object depends on Builder for creation  


---

## 📚 Examples

All examples are provided in the [`/examples`](./examples) folder.

---

### 🔹 Example 1 — Builder Only

#### Scenario

A backend system that builds a **search filter** for products.

#### Problem

- Many optional parameters (price, brand, stock, etc.)  
- Constructor becomes complex  

#### Solution

Use Builder to construct the object step by step.

#### What this example demonstrates

- Fluent API design  
- Optional vs required parameters  
- Validation inside `build()`  
- Immutable object creation  
- Clear UML relationships  

---

### 🔹 Example 2 — Builder + Factory

#### Scenario

A notification system that supports multiple types:

- Email  
- SMS  

#### Problem

- Multiple object types → need Factory  
- Each object has many fields → need Builder  

#### Solution

Use both patterns together:

| Pattern | Responsibility |
|--------|---------------|
| Factory | Choose notification type |
| Builder | Build the notification |

#### What this example demonstrates

- Separation of responsibilities  
- How patterns work together  
- Real backend system design  
- Clean architecture  

---

## ⚖️ Builder vs Factory vs Combined

| Feature | Builder | Factory | Combined |
|--------|--------|--------|----------|
| Purpose | Build object step-by-step | Choose object type | Do both |
| Focus | Construction | Creation decision | Flexible systems |
| Use Case | Many optional fields | Multiple types | Complex systems |
| Result | One object | One of many types | Flexible architecture |

---

## 🧪 Activities

### 1️⃣ SQL Query Builder

#### Scenario

We must build a system that generates SQL queries dynamically.

#### Goal

Use Builder Pattern to construct SQL queries step by step.

📁 See: [`activities/activity-1-sql-builder`](./activities/activity-1-sql-builder)

---

### 2️⃣ Food Order System (Builder + Factory)

#### Scenario

A restaurant system with different meal types:

- Burger  
- Pizza  
- Salad  

Each meal has:

- common fields  
- optional extras  

#### Goal

Use Factory to select meal type and Builder to construct it.

📁 See: [`activities/activity-2-food-order`](./activities/activity-2-food-order)

---

## 🚀 How to Use This Repository

1. Fork the repository  
2. Clone it locally  
3. Explore [`/examples`](./examples) to understand implementations  
4. Complete tasks inside [`/activities`](./activities)  
5. Submit your solution via Pull Request  

---

## 💡 Tips for Students

Ask yourself:

> “Is this object too complex to build with a constructor?”

- If **YES** → consider Builder  

---

Ask yourself:

> “Do I have multiple object types?”

- If **YES** → consider Factory  

---

If **both**:

- Use **Builder + Factory together**  

---

Always:

- Think about responsibility  
- Keep design clean  
- Use UML before coding  

---

## 📎 Final Note

The Builder Pattern is not just about writing a class.

It is about designing **clear, flexible, and maintainable systems**.

---

Whenever you see:

```java
new Something(a, b, c, d, e)
```


Stop and ask:

> “Is this becoming hard to read or maintain?”

If the answer is yes…

👉 **Builder Pattern is your solution.**
