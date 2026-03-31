/*
 * Main.java
 *
 * Demonstrates how to use the SearchFilter.Builder to construct
 * SearchFilter objects in a clean, readable, and flexible way.
 */

package SearchFilter;

public class Main {

    public static void main(String[] args) {

        // =======================
        // Step-by-step Builder usage
        // =======================

        // 1. Create a builder with the mandatory field
        SearchFilter.Builder builder = new SearchFilter.Builder("Phones");

        // 2. Add optional filters using method chaining
        builder.setBrand("Apple")
               .setMinPrice(500)
               .setMaxPrice(2000)
               .setInStockOnly(true);

        // 3. Build the final SearchFilter object
        SearchFilter filter = builder.build();

        // 4. Use the filter object
        System.out.println("Category: " + filter.getCategory());
        System.out.println("Brand: " + filter.getBrand());
        System.out.println("Price Range: " + filter.getMinPrice() + " - " + filter.getMaxPrice());
        System.out.println("In stock only: " + filter.isInStockOnly());
    }
}
