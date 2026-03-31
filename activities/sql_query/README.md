# 🧪 Activity 1: SQL Query Builder

## 🎯 Objective

Design a flexible and maintainable system using the **Builder Pattern** to construct dynamic SQL queries.

---

## 📌 Scenario

You are developing a backend system that interacts with a database.

Different parts of the application need to generate SQL `SELECT` queries dynamically, depending on user input or business logic.

Examples of variations include:

- Selecting specific columns  
- Adding filtering conditions (`WHERE`)  
- Sorting results (`ORDER BY`)  
- Limiting results (`LIMIT`)  
- Joining multiple tables  

---

## ⚠️ Problem Context

Building SQL queries manually (e.g., string concatenation) leads to:

- Poor readability  
- High risk of syntax errors  
- Difficult maintenance  
- Hard-to-extend query logic  

Additionally, using constructors for all combinations of query parameters results in:

- Complex and unreadable code  
- Limited flexibility  
- Tight coupling between query construction and usage  

---

## 🧠 Your Task

- Design a `Query` system using the **Builder Pattern**  
- Separate query construction from representation  
- Allow step-by-step building of SQL queries  
- Ensure the design is clean, flexible, and easy to extend  

---

## 📏 Requirements

- The query must include a **mandatory table name**  
- Support optional features such as:
  - Selecting specific columns  
  - Adding `WHERE` conditions  
  - Adding `ORDER BY` clause  
  - Applying `LIMIT`  
  - Supporting `JOIN` operations  
- Use **method chaining** for building queries  
- Validate required fields before building the final query  

---

## 🧩 Design Expectations

Your design should:

- Encapsulate query construction logic inside a **Builder class**  
- Produce a final query object using a `build()` method  
- Keep the final object **immutable**  
- Ensure readability and ease of use  

---

## ✅ Expected Outcome

- A clean and structured way to build SQL queries  
- Improved readability compared to raw string construction  
- Reduced duplication in query-building logic  
- A scalable solution that can handle future extensions  

---

## 🚀 Example Use Case (Conceptual)

A developer should be able to build queries in a readable way like:

- Define the table  
- Add optional clauses step-by-step  
- Generate the final query  

Focus on **design clarity**, not just functionality.

---

## 🧩 Challenge Extension (Optional)

- How would you prevent invalid SQL states (e.g., missing table name)?  
- How can your Builder support complex queries with multiple conditions?  
- What changes are needed to support other query types (INSERT, UPDATE)?  
- How would you adapt this design for different database systems?  

---

## 📌 Key Insight

This activity demonstrates how the **Builder Pattern** transforms a complex and error-prone process into a clean, structured, and developer-friendly design.

---
