/*
 * SearchFilter.java
 * 
 * This class demonstrates the **Builder Pattern** applied to an e-commerce
 * filtering system. It allows constructing a SearchFilter object in a
 * flexible, readable, and safe way.
 * 
 * Scenario:
 * -----------
 * We are building a product search feature for an online store. Users can
 * filter products by category, price range, brand, and stock availability.
 * 
 * Problem:
 * ----------
 * If we use traditional constructors for all possible combinations of
 * optional fields (brand, minPrice, maxPrice, inStockOnly), we face:
 * - Multiple constructors → hard to read
 * - Error-prone parameter order
 * - Difficulty extending for new filters
 * 
 * Solution:
 * ----------
 * Use the Builder Pattern to construct SearchFilter objects step by step.
 * This separates construction logic from the final object and allows:
 * - Fluent API via method chaining
 * - Immutable objects after building
 * - Mandatory field enforcement (category)
 * - Easy extension for future optional fields
 */

package SearchFilter;

/**
 * SearchFilter class represents the filter criteria for searching products
 * in an online catalog.
 */
public class SearchFilter {

    // Mandatory field
    private final String category;

    // Optional fields
    private final double minPrice;
    private final double maxPrice;
    private final String brand;
    private final boolean inStockOnly;

    /**
     * Private constructor called by Builder.
     * Only Builder can create SearchFilter instances.
     */
    private SearchFilter(Builder builder) {
        this.category = builder.category;
        this.minPrice = builder.minPrice;
        this.maxPrice = builder.maxPrice;
        this.brand = builder.brand;
        this.inStockOnly = builder.inStockOnly;
    }

    // =======================
    // Getters (no setters for immutability)
    // =======================
    public String getCategory() {
        return category;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isInStockOnly() {
        return inStockOnly;
    }

    // =======================
    // Builder Class
    // =======================
    public static class Builder {

        // Mandatory field
        private final String category;

        // Optional fields with default values
        private double minPrice = 0;
        private double maxPrice = Double.MAX_VALUE;
        private String brand = "";
        private boolean inStockOnly = false;

        /**
         * Builder constructor enforces mandatory fields.
         *
         * @param category The product category (required)
         */
        public Builder(String category) {
            if (category == null || category.isEmpty()) {
                throw new IllegalArgumentException("Category is required");
            }
            this.category = category;
        }

        /**
         * Sets the minimum price filter.
         *
         * @param minPrice Minimum price
         * @return Builder instance for chaining
         */
        public Builder setMinPrice(double minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        /**
         * Sets the maximum price filter.
         *
         * @param maxPrice Maximum price
         * @return Builder instance for chaining
         */
        public Builder setMaxPrice(double maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        /**
         * Sets the brand filter.
         *
         * @param brand Brand name
         * @return Builder instance for chaining
         */
        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        /**
         * Sets the in-stock-only filter.
         *
         * @param inStockOnly True to filter only in-stock items
         * @return Builder instance for chaining
         */
        public Builder setInStockOnly(boolean inStockOnly) {
            this.inStockOnly = inStockOnly;
            return this;
        }

        /**
         * Builds and returns the final SearchFilter object.
         * Validates mandatory fields before creation.
         *
         * @return Constructed SearchFilter object
         */
        public SearchFilter build() {
            return new SearchFilter(this);
        }
    }
}
