/*
 * Main.java
 *
 * Demonstrates using the SearchFilter.Builder with method chaining.
 * Shows how optional fields can be set step-by-step in a readable way.
 */

package SearchFilter;

public class Main {

    public static void main(String[] args) {

        // =======================
        // Builder Pattern with method chaining
        // =======================

        // We create the SearchFilter object directly by chaining setter methods
        // after the Builder constructor, then call build() at the end.
        SearchFilter filter = new SearchFilter.Builder("Phones") // mandatory category
                .setBrand("Apple")       // optional brand filter
                .setMinPrice(500)        // optional minimum price
                .setMaxPrice(2000)       // optional maximum price
                .setInStockOnly(true)    // optional in-stock-only filter
                .build();                // finalize and get the SearchFilter object

        // =======================
        // Use the built object
        // =======================
        System.out.println("Category: " + filter.getCategory());
        System.out.println("Brand: " + filter.getBrand());
        System.out.println("Price Range: " + filter.getMinPrice() + " - " + filter.getMaxPrice());
        System.out.println("In stock only: " + filter.isInStockOnly());
    }
}
