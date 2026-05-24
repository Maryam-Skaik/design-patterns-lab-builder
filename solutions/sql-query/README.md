# 🧪 Activity 1: SQL Query Builder - Solution

## 🎯 Objective

This solution demonstrates designing a flexible SQL query generation system using the **Builder Pattern** in Java.

The design focuses on creating dynamic SQL `SELECT` queries in a clean, readable, and maintainable way.

---

## 🧠 Solution Explanation

### Step 1: Identified Main Components

* `Query`
* `Query.Builder`
* `Main`

---

### Step 2: Defined Builder Pattern Structure

* `Query` represents the final immutable SQL query object.
* `Builder` handles step-by-step query construction.
* `Main` demonstrates how developers can build queries using method chaining.

---

### Step 3: UML Diagram Representation

```text
+---------------------------------------------------+
|                     Query                         |
+---------------------------------------------------+
| - tableName: String                               |
| - columns: List<String>                           |
| - whereConditions: List<String>                   |
| - joins: List<String>                             |
| - orderBy: String                                 |
| - limit: int                                      |
+---------------------------------------------------+
| +generateSQL(): String                            |
| +getTableName(): String                           |
| +getColumns(): List<String>                       |
| +getWhereConditions(): List<String>               |
| +getJoins(): List<String>                         |
| +getOrderBy(): String                             |
| +getLimit(): int                                  |
+---------------------------------------------------+
                    ▲
                    |
                    |
+---------------------------------------------------+
|                  Builder                          |
+---------------------------------------------------+
| - tableName: String                               |
| - columns: List<String>                           |
| - whereConditions: List<String>                   |
| - joins: List<String>                             |
| - orderBy: String                                 |
| - limit: int                                      |
+---------------------------------------------------+
| +selectColumn(column): Builder                    |
| +where(condition): Builder                        |
| +join(join): Builder                              |
| +orderBy(orderBy): Builder                        |
| +limit(limit): Builder                            |
| +build(): Query                                   |
+---------------------------------------------------+
```

---

### Step 4: Java Implementation Highlights

* `Query` object is immutable after creation.
* `Builder` enforces the mandatory table name.
* Method chaining improves readability and developer experience.
* SQL query generation logic is encapsulated inside `generateSQL()`.
* Optional query parts can be added step-by-step:

  * `SELECT`
  * `WHERE`
  * `JOIN`
  * `ORDER BY`
  * `LIMIT`

---

### Example Query Construction

```java
Query query = new Query.Builder("Products")
        .selectColumn("id")
        .selectColumn("name")
        .selectColumn("price")
        .where("price > 500")
        .where("stock > 0")
        .join("INNER JOIN Categories ON Products.category_id = Categories.id")
        .orderBy("price DESC")
        .limit(10)
        .build();
```

---

### Generated SQL Output

```sql
SELECT id, name, price
FROM Products
INNER JOIN Categories ON Products.category_id = Categories.id
WHERE price > 500 AND stock > 0
ORDER BY price DESC
LIMIT 10
```

---

## ✅ Key Concepts Demonstrated

* Builder Pattern
* Method Chaining (Fluent Interface)
* Encapsulation
* Immutable Objects
* Dynamic SQL Query Construction
* Separation of Construction Logic from Representation
* Clean and Maintainable Design

---

## 🚀 Advantages of This Design

* Improves readability compared to manual string concatenation
* Reduces SQL construction errors
* Easy to extend with future SQL features
* Keeps query-building logic centralized and organized
* Produces developer-friendly and scalable code
