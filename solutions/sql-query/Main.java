/*
 * Main.java
 *
 * Demonstrates using the Query.Builder with method chaining.
 * Shows how SQL queries can be constructed step-by-step
 * in a clean and readable way.
 */

package QueryBuilder;

public class Main {

    public static void main(String[] args) {

        // =======================
        // Builder Pattern with method chaining
        // =======================

        // Create Query object step-by-step
        Query query = new Query.Builder("Products") // mandatory table name
                .selectColumn("id")                 // optional selected column
                .selectColumn("name")
                .selectColumn("price")
                .where("price > 500")              // optional WHERE condition
                .where("stock > 0")
                .join("INNER JOIN Categories ON Products.category_id = Categories.id")
                .orderBy("price DESC")             // optional ORDER BY
                .limit(10)                         // optional LIMIT
                .build();                          // finalize query object

        // =======================
        // Use the built object
        // =======================

        System.out.println("Generated SQL Query:");
        System.out.println(query.generateSQL());
    }
}
