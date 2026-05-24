/*
 * MealFactory.java
 *
 * Factory Pattern implementation to centralize the creation
 * of Meal Builders.
 *
 * Returns the Builder for Burger, Pizza, or Salad meals.
 */

package FoodOrderSystem;

public class MealFactory {

    /**
     * Returns a Builder object for the requested meal type.
     *
     * @param type "BURGER", "PIZZA", or "SALAD"
     * @return Builder object
     */
    public static Object getBuilder(String type) {

        switch(type) {

            case "BURGER":
                return new BurgerMeal.Builder();

            case "PIZZA":
                return new PizzaMeal.Builder();

            case "SALAD":
                return new SaladMeal.Builder();

            default:
                throw new IllegalArgumentException("Unknown meal type: " + type);
        }
    }
}
