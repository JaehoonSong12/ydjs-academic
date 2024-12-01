/**
 * CustomUtils.java
 * 
 * Contains utility and exercise methods for modularized execution.
 * Demonstrates Java coding conventions and reusable methods.
 * 
 * @author Jaehoon
 * @version 1.0.0
 * @since 24/11/28
 */
public class CustomUtils {

    // Exercise 1: Print a simple message
    public static void exercise01() {
        System.out.println("This is Exercise 1");
    }

    // Exercise 2: Add two numbers
    public static void exercise02() {
        int a = 5, b = 10;
        System.out.println("The sum of " + a + " and " + b + " is " + (a + b));
    }

    // Exercise 3: Check if a number is even or odd
    public static void exercise03() {
        int number = 7;
        System.out.println(number + " is " + (number % 2 == 0 ? "even" : "odd"));
    }

    // Exercise 4: Add two numbers and print the result
    public static void exercise04() {
        int number1 = 10, number2 = 20;
        System.out.println("The sum of " + number1 + " and " + number2 + " is " + (number1 + number2));
    }

    // Exercise 5: Print multiplication table
    public static void exercise05(int number) {
        System.out.println("Multiplication Table for " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    // Exercise 6: Reverse a string
    public static void exercise06(String original) {
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }

    // Utility: Double a number
    public static int exampleMethod(int input) {
        return input * 2;
    }

    // Utility: Display a formatted message
    public static void displayMessage(String message) {
        System.out.println("Message: " + message);
    }
}
