/**
 * Eugene01.java
 * 
 * This program is a template for a student homework assignment. It demonstrates
 * Java coding conventions, structure, and proper documentation using Javadoc.
 * 
 * @author Jaehoon Song
 * @version 1.0.0
 * @since 24/11/28
 */
public class Eugene01 {

    /**
     * Main method serves as the entry point for the program.
     * 
     * @param args command-line arguments passed as an array of {@code String}.
     */
    public static void main(String[] args) {
        // Example: Print a welcome message to the console
        System.out.println("Welcome to Eugene01!");

        // Call exercise methods from CustomUtils
        CustomUtils.exercise01();
        CustomUtils.exercise02();
        CustomUtils.exercise03();
        CustomUtils.exercise04();
        CustomUtils.exercise05(5); // Pass a number for the multiplication table
        CustomUtils.exercise06("Eugene");

        // Call utility methods from CustomUtils
        int doubled = CustomUtils.exampleMethod(7);
        System.out.println("Doubled value: " + doubled);

        CustomUtils.displayMessage("This is a test message!");
        
        // Add method calls or logic here
        Exercise01.main(args);
        Exercise02.main(args);
        Exercise03.main(args);
        Exercise04.main(args);
        Exercise05.main(args);
        Exercise06.main(args);
    }

    /**
     * Example of a utility method.
     * 
     * This method performs a specific task. Replace the description below with
     * an actual implementation description.
     * 
     * @param input An integer input for the task.
     * @return The result of the task as an integer.
     */
    public static int exampleMethod(int input) {
        // Replace this with the actual logic
        return input * 2; // Example logic: doubling the input
    }

    /**
     * Helper method to display a formatted message.
     * 
     * This is an example of how to document a utility function.
     * 
     * @param message A {@code String} containing the message to display.
     */
    public static void displayMessage(String message) {
        System.out.println("Message: " + message);
    }
    


















}