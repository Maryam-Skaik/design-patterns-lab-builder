# 🏗️ Design Patterns Lab — Builder Pattern

![Java](https://img.shields.io/badge/Language-Java-blue)
![Pattern](https://img.shields.io/badge/Pattern-Builder-green)
![Level](https://img.shields.io/badge/Level-Intermediate-orange)
![Focus](https://img.shields.io/badge/Focus-Clean%20Code%20%26%20Design-purple)

---

## 🎥 Lecture Video

This repository accompanies the lecture video explaining the Builder Pattern through **real-world problems, design reasoning, and practical examples**.

▶️ Watch on YouTube: 

[Lecture Video](https://youtu.be/amjmaQ2Q91c)

---

## 📌 About This Repository

This repository provides a **deep, practical understanding of the Builder Pattern** through structured examples and guided activities.

Instead of focusing only on theory, the goal is to help you:
- Understand *why* the pattern exists
- Recognize *when* to use it
- Apply it in **real-world backend scenarios**
- Write **clean, maintainable, and scalable code**

---

## 🧠 Why Do We Need Builder?

In real systems, objects are rarely simple.

You often deal with:
- Many optional fields
- Conditional configurations
- Different representations of the same object

### ❌ The Problem

Using constructors directly leads to:
- Poor readability  
- High chance of mistakes (wrong parameter order)  
- Difficult maintenance  
- Explosion of constructor overloads  

This is known as the **Telescoping Constructor Problem**.

---

## ⚠️ Telescoping Constructor Problem (Deep Insight)

Imagine adding optional fields over time:

- Version 1 → only required fields  
- Version 2 → add 2 optional fields  
- Version 3 → add more options  

You end up with multiple constructors trying to cover all combinations.

### Result:
- Code becomes rigid  
- Hard to extend  
- Difficult for other developers to use correctly  

---

## ✅ Builder Pattern — Core Idea

The Builder Pattern solves this by:

- Constructing objects **step-by-step**
- Allowing **optional configuration**
- Producing a **final immutable object**

### Key Characteristics:

- Uses a **static inner Builder class**
- Applies **method chaining (fluent interface)**
- Separates:
  - Construction logic
  - Final object structure

---

## 🧩 Structure of Builder Pattern

### 1. Product
The main class you want to build.

### 2. Builder
Responsible for:
- Holding temporary values
- Providing setter-like methods
- Validating required fields
- Creating the final object

### 3. Build Method
- Performs validation
- Returns a fully constructed object

---

## 💡 Example 1: Search Filter (Real Backend Use Case)

### 🎯 Scenario
Filtering products in an e-commerce system.

### Why Builder Here?

Because filters are:
- Highly dynamic
- Mostly optional
- Combined in different ways

### What Makes This Example Important?

- Mimics real APIs (`/products?minPrice=...&brand=...`)
- Demonstrates **flexible query building**
- Shows how to avoid constructor complexity

### Key Design Decisions:
- `category` is mandatory → enforced in Builder constructor  
- Optional fields are added fluently  
- Object is **immutable after build()**

---

## 💡 Example 2: Notification System (Builder + Factory)

### 🎯 Scenario
Sending notifications via:
- Email
- SMS

### Design Challenge

Different objects require different fields:
- Email → subject, body
- SMS → phone, message

### Solution Approach

- **Factory Pattern** → decides *which type* to create  
- **Builder Pattern** → decides *how to construct it*  

### Why This Matters

This combination reflects **real backend architecture**, where:
- Object type is dynamic
- Construction logic is complex

---

## 🧪 Activity 1: SQL Query Builder

### 🎯 Goal
Design a flexible system to dynamically build SQL queries.

### Why This is Important

Hardcoded queries are:
- Inflexible
- Hard to modify
- Error-prone

Builder allows:
- Incremental query construction
- Cleaner logic separation
- Better readability

### What You Should Focus On

- Enforcing required fields (table name)
- Supporting chaining operations
- Keeping query generation clean and extendable

---

## 🍔 Activity 2: Food Order System

### 🎯 Goal
Design a system that supports multiple meal types with shared and optional features.

### Design Challenges

- Different meal types
- Shared attributes
- Optional add-ons

### Expected Design Thinking

- Use **Factory** to select meal type
- Use **Builder** to configure the meal

### What You Learn Here

- Combining patterns effectively
- Designing scalable object creation
- Avoiding duplication across similar classes

---

## ⚖️ When to Use Builder Pattern

Use Builder when:

- Object has **many optional parameters**
- Object creation is **complex or multi-step**
- You want **immutable objects**
- You need **readable and expressive code**

---

## 🚫 When NOT to Use It

Avoid Builder when:

- Object is simple (2–3 fields only)
- No optional parameters exist
- Construction logic is trivial

---

## 🆚 Builder vs Other Approaches

| Approach | Problem |
|--------|--------|
| Constructors | Hard to read, not scalable |
| Setters | Mutable objects, unsafe states |
| Builder | Clean, safe, scalable ✅ |

---

## 🧠 Best Practices

- Always validate required fields inside `build()`
- Keep the final object **immutable**
- Use meaningful method names
- Avoid exposing internal construction logic
- Combine with other patterns when needed

---

## 🎯 Learning Outcomes

After completing this repository, you should be able to:

- Identify real-world problems solved by Builder
- Replace telescoping constructors effectively
- Design clean and maintainable object creation logic
- Combine Builder with Factory in practical scenarios

---

## 🚀 How to Use

1. Clone the repository
2. Explore each example folder
3. Understand the design before reading code
4. Complete the activities independently
5. Refactor your solutions for better design

---

## 🤝 Contribution

Students are encouraged to:
- Fork the repository
- Implement missing parts
- Improve existing designs
- Submit Pull Requests for review

---

## 📌 Final Insight

The Builder Pattern is not just about avoiding constructor overloads.

It is about:
- Writing **clear code**
- Designing **flexible systems**
- Building **objects the right way**

---
