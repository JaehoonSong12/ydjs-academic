package jayden.usaco;

import java.util.List;


/// This is your 2nd hw! 
/// for testing, run `./script/java04-test.sh`.





/**
 * Exercise02 contains methods that practice:
 * 1. Implementing decision-making using `if-else` statements and conditions.
 * 2. Performing arithmetic calculations and logical comparisons.
 * 3. Using formatted string outputs to display results based on inputs.
 * 
 * The methods in this class include:
 * - `skillLevel`:  Determines a skill level (Beginner, Moderate, Advanced) based on a 
 *                  given numeric value.
 * - `bookStore`:   Calculates the remaining money or indicates insufficient funds after 
 *                  purchasing items from a bookstore.
 * - `dinnerPlans`: Suggests transportation options (Walk or Uber) based on distance and 
 *                  hunger level.
 * - `weekendTrip`: Determines the best travel method (walking, biking, driving) or if the 
 *                  trip takes too much time.
 * - `textFriends`: Calculates snack distribution and transportation based on distance, 
 *                  time, and group size.
 */
public class Exercise02 {
    public static void main(String[] args) {
        // Test cases for skillLevel
        System.out.println(skillLevel(13)); // Beginner
        System.out.println(skillLevel(50)); // Moderate
        System.out.println(skillLevel(78)); // Advanced

        // Test cases for bookStore
        System.out.println(bookStore("Shirt", 350.48, 8)); // 226.48
        System.out.println(bookStore("Lanyard", 200.0, 70)); // Not enough money!
        System.out.println(bookStore("Sweatshirt", 100.0, 1));

        // Test cases for dinnerPlans
        System.out.println(dinnerPlans(4, "Slightly Hungry")); // Walk
        System.out.println(dinnerPlans(6, "Very Hungry")); // Uber

        // Test cases for weekendTrip
        System.out.println(weekendTrip(7.0, 46.66, 1.0)); // driving
        System.out.println(weekendTrip(10.0, 5.0, 8.0)); // Going to this destination would take too much time.

        // Test cases for textFriends
        System.out.println(textFriends(25.0, 65.0, 2.5, 17, 3)); // If each of us gets 5 snack(s), there will be 2 left. I will be driving, who else is doing the same?
        System.out.println(textFriends(1.5, 2.5, 3.0, 13, 7)); // If each of us gets 1 snack(s), there will be 6 left. I will be walking, who else is doing the same?
    }

    /**
     * Determines the skill level of a class based on the pass rate of a diagnostic exam.
     * Skill levels are categorized as:
     * - "Beginner" if 25% or fewer students pass.
     * - "Moderate" if more than 25% and up to 75% of students pass.
     * - "Advanced" if more than 75% of students pass.
     *
     * @param passRate Percentage of students who passed the diagnostic exam (must be an integer).
     * @return A string representing the skill level of the class: "Beginner", "Moderate", 
     *         or "Advanced".
     */
    public static String skillLevel(int passRate) {
        String level = "Beginner, Moderate, Advanced";

        if (passRate <= 25) {
            System.out.println("worked");
        } 
        if (passRate <= 75) {
            System.out.println("worked");
        } 
        if (passRate <= 100) {
            System.out.println("worked");
        } 
        return null;
    }

    /**
     * Calculates the amount of money left after purchasing items from the bookstore.
     * The prices of items are as follows:
     * - "Shirt": $15.50
     * - "Lanyard": $4.25
     * - "Sweatshirt": $25.00
     * - "Mug": $10.50
     * If the wallet amount is insufficient to purchase the items, returns "Not enough money!".
     *
     * @param item         The name of the item to purchase (must be "Shirt", "Lanyard", 
     *                     "Sweatshirt", or "Mug").
     * @param walletAmount The amount of money available in the wallet (must be a positive float).
     * @param quantity     The number of items to purchase (must be a non-negative integer).
     * @return The amount of money left as a float, rounded to 2 decimal places, or "Not enough 
     *         money!" if the wallet amount is insufficient.
     */
    public static String bookStore(String item, double walletAmount, int quantity) {
        /**
         * < Your Implementation Here >
         */
        return null;
    }

    /**
     * Determines the mode of transport for dinner plans based on distance and hunger level.
     * The hunger levels and their corresponding thresholds are as follows:
     * - "Very Hungry": Walk if distance <= 1, otherwise take an Uber.
     * - "Hungry": Walk if distance <= 3, otherwise take an Uber.
     * - "Slightly Hungry": Walk if distance <= 5, otherwise take an Uber.
     * - "Not Hungry": Walk if distance <= 7, otherwise take an Uber.
     *
     * @param distance   The distance to the restaurant in miles (must be a non-negative 
     *                   integer).
     * @param hungerLevel The hunger level, which must be one of: "Very Hungry", "Hungry", 
     *                    "Slightly Hungry", or "Not Hungry".
     * @return A string representing the mode of transport: "Walk" or "Uber".
     */
    public static String dinnerPlans(int distance, String hungerLevel) {
        /**
         * < Your Implementation Here >
         */
        return null;
    }

    /**
     * Determines the mode of transport for a weekend trip based on distance, speed, and 
     * available free time.
     * If the travel time exceeds 20% of the free time, the trip is deemed too time-consuming.
     * The modes of transport are determined by speed as follows:
     * - Speed <= 15 mph: "walking"
     * - 15 < Speed <= 20 mph: "biking"
     * - Speed > 20 mph: "driving"
     *
     * @param distance  The distance to the destination in miles (must be a positive float).
     * @param speed     The travel speed in miles per hour (must be a positive float).
     * @param freeTime  The available free time in hours (must be a positive float).
     * @return A string representing the mode of transport: "walking", "biking", or "driving"; 
     *         or a message indicating the trip is too time-consuming.
     */
    public static String weekendTrip(double distance, double speed, double freeTime) {
        /**
         * < Your Implementation Here >
         */
        return null;
    }

    /**
     * Determines whether a trip is feasible and calculates snack distribution among friends.
     * If the trip takes more than 20% of the available free time, returns a message indicating 
     * the trip is infeasible.
     * Otherwise, calculates how many snacks each friend receives and how many are left over, 
     * and includes the mode of transport.
     *
     * @param distance   The distance to the destination in miles (must be a positive float).
     * @param speed      The travel speed in miles per hour (must be a positive float).
     * @param freeTime   The available free time in hours (must be a positive float).
     * @param numSnacks  The total number of snacks (must be a non-negative integer).
     * @param numFriends The number of friends (must be a positive integer).
     * @return A string detailing snack distribution and transport mode, or a message 
     *         indicating the trip is infeasible.
     */
    public static String textFriends(double distance, double speed, double freeTime, int numSnacks, int numFriends) {
        /**
         * < Your Implementation Here >
         */
        return null;
    }
}