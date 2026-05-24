/*
 * PizzaMeal.java
 *
 * Represents a Pizza meal. Uses Builder pattern for flexible
 * meal customization.
 */

package FoodOrderSystem;

public class PizzaMeal implements Meal {

    // Required fields
    private final String customerName;
    private final String size;
    private final double totalPrice;

    // Optional fields
    private final boolean extraCheese;
    private final String drink;
    private final String sauce;
    private final String specialNotes;

    /**
     * Private constructor called by Builder
     */
    private PizzaMeal(Builder builder) {
        this.customerName = builder.customerName;
        this.size = builder.size;
        this.totalPrice = builder.totalPrice;
        this.extraCheese = builder.extraCheese;
        this.drink = builder.drink;
        this.sauce = builder.sauce;
        this.specialNotes = builder.specialNotes;
    }

    // =======================
    // Getters
    // =======================
    public String getCustomerName() { return customerName; }
    public String getSize() { return size; }
    public double getTotalPrice() { return totalPrice; }
    public boolean hasExtraCheese() { return extraCheese; }
    public String getDrink() { return drink; }
    public String getSauce() { return sauce; }
    public String getSpecialNotes() { return specialNotes; }

    @Override
    public void prepare() {
        System.out.println("Preparing Pizza Meal for " + customerName);
    }

    // =======================
    // Builder class for PizzaMeal
    // =======================
    public static class Builder {

        // Required fields
        private String customerName;
        private String size;
        private double totalPrice;

        // Optional fields
        private boolean extraCheese = false;
        private String drink = "";
        private String sauce = "";
        private String specialNotes = "";

        // Setters return Builder for chaining
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
        public PizzaMeal build() {

            if(customerName == null || size == null || totalPrice <= 0) {
                throw new IllegalStateException("Missing required fields for PizzaMeal");
            }

            return new PizzaMeal(this);
        }
    }
}
