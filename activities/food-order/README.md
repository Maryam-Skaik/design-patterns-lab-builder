# 🍔 Activity 2: Food Order System

## 🎯 Objective

Design a flexible and maintainable system using the **Builder Pattern** (combined with a Factory Pattern) to create different types of meals with optional customizations.

---

## 📌 Scenario

You are building a backend system for a restaurant that offers multiple meal types:

- **Burger** 🍔  
- **Pizza** 🍕  
- **Salad** 🥗  

Each meal has:

- Common required fields:
  - Customer name  
  - Meal size  
  - Total price  

- Optional customizations:
  - Extra cheese  
  - Drinks  
  - Sauce  
  - Fries  
  - Special notes  

---

## ⚠️ Problem Context

Handling meal creation directly in multiple parts of the system can lead to:

- Repeated code for each meal type  
- Tight coupling between meal creation and usage  
- Difficulty adding new meal types or options  

Additionally, using multiple constructors to cover all combinations results in:

- Complex, unreadable code  
- High maintenance overhead  

---

## 🧠 Your Task

- Implement a **MealFactory** to centralize meal creation  
- Use the **Builder Pattern** for each meal type to allow step-by-step customization  
- Ensure that required fields are enforced  
- Support optional fields using fluent interfaces (method chaining)  
- Keep the final meal objects **immutable**  

---

## 📏 Requirements

- Factory returns builders for each meal type:
  - `BurgerMeal.Builder`  
  - `PizzaMeal.Builder`  
  - `SaladMeal.Builder`  
- Each builder allows adding optional customizations  
- Mandatory fields must be set before building the meal  
- Design must be extendable for future meal types or options  

---

## ✅ Expected Outcome

- Centralized, clean meal creation logic  
- Step-by-step construction for optional fields  
- Immutable final meal objects  
- Scalable and maintainable design suitable for real-world backend systems  

---

## 🧩 Challenge Extension (Optional)

- How would you handle new meal types being added frequently?  
- How can the design accommodate complex pricing rules or combo meals?  
- How would you validate optional fields without breaking the builder chain?  
- Could you integrate this design with a real-time ordering system or API?  

---

## 📌 Key Insight

This activity shows how combining **Builder** and **Factory Patterns** allows you to:

- Manage complex object creation cleanly  
- Support optional parameters flexibly  
- Keep your backend system scalable and maintainable  

---
