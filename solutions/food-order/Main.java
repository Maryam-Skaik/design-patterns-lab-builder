/*
 * Main.java
 *
 * Demonstrates how to combine Factory + Builder patterns
 * to create different meal types in a clean and maintainable way.
 */

package FoodOrderSystem;

public class Main {

    public static void main(String[] args) {

        // =======================
        // Burger Meal
        // =======================

        BurgerMeal burger = ((BurgerMeal.Builder)
                MealFactory.getBuilder("BURGER"))
                .setCustomerName("Maryam")
                .setSize("Large")
                .setTotalPrice(12.5)
                .setExtraCheese(true)
                .setFries(true)
                .setDrink("Cola")
                .setSauce("BBQ")
                .build();

        burger.prepare();

        // =======================
        // Pizza Meal
        // =======================

        PizzaMeal pizza = ((PizzaMeal.Builder)
                MealFactory.getBuilder("PIZZA"))
                .setCustomerName("Ahmad")
                .setSize("Medium")
                .setTotalPrice(18.0)
                .setExtraCheese(true)
                .setDrink("Orange Juice")
                .setSpecialNotes("Less spicy")
                .build();

        pizza.prepare();

        // =======================
        // Salad Meal
        // =======================

        SaladMeal salad = ((SaladMeal.Builder)
                MealFactory.getBuilder("SALAD"))
                .setCustomerName("Sara")
                .setSize("Small")
                .setTotalPrice(9.5)
                .setSauce("Ranch")
                .setSpecialNotes("No onions")
                .build();

        salad.prepare();
    }
}
