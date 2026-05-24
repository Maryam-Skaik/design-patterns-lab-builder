/*
 * BurgerMeal.java
 *
 * Represents a Burger meal. Uses Builder pattern to construct
 * complex objects with multiple optional customizations.
 */

package FoodOrderSystem;

public class BurgerMeal implements Meal {

    // Required fields
    private final String customerName;
    private final String size;
    private final double totalPrice;

    // Optional fields
    private final boolean extraCheese;
    private final boolean fries;
    private final String drink;
    private final String sauce;
    private final String specialNotes;

    /**
     * Private constructor called by Builder
     */
    private BurgerMeal(Builder builder) {
        this.customerName = builder.customerName;
        this.size = builder.size;
        this.totalPrice = builder.totalPrice;
        this.extraCheese = builder.extraCheese;
        this.fries = builder.fries;
        this.drink = builder.drink;
        this.sauce = builder.sauce;
        this.specialNotes = builder.specialNotes;
    }

    // =======================
    // Getters (Immutable object)
    // =======================
    public String getCustomerName() { return customerName; }
    public String getSize() { return size; }
    public double getTotalPrice() { return totalPrice; }
    public boolean hasExtraCheese() { return extraCheese; }
    public boolean hasFries() { return fries; }
    public String getDrink() { return drink; }
    public String getSauce() { return sauce; }
    public String getSpecialNotes() { return specialNotes; }

    @Override
    public void prepare() {
        System.out.println("Preparing Burger Meal for " + customerName);
    }

    // =======================
    // Builder class for BurgerMeal
    // =======================
    public static class Builder {

        // Required fields
        private String customerName;
        private String size;
        private double totalPrice;

        // Optional fields
        private boolean extraCheese = false;
        private boolean fries = false;
        private String drink = "";
        private String sauce = "";
        private String specialNotes = "";

        // Setter methods return Builder for chaining
        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setExtraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public Builder setFries(boolean fries) {
            this.fries = fries;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder setSpecialNotes(String specialNotes) {
            this.specialNotes = specialNotes;
            return this;
        }

        // Build method validates required fields
        public BurgerMeal build() {

            if(customerName == null || size == null || totalPrice <= 0) {
                throw new IllegalStateException("Missing required fields for BurgerMeal");
            }

            return new BurgerMeal(this);
        }
    }
}
