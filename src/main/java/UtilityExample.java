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
        
        // Add method calls or logic here
        Exercise01.main(args);
        Exercise02.main(args);
        Exercise03.main(args);
        Exercise04.main(args);
        Exercise05.main(args);
        Exercise06.main(args);

        class Exercise01 {
            public static void main(String[] args) {
                System.out.println("This is Excercise 1");
            }
        }
        class Exercise02 {
            public static void main(String[] args) {
                int a = 5, b = 10;
                System.out.println("The sum of " + a + " and " + b + " is " + (a + b));
            }
            }
        class Exercise03 {
                int number = 7;
                System.out.println(number + " is " + (number % 2 == 0 ? "even" : "odd"));
             }
}
            }
        class Exercise04 {
                int number2 = 10;
                int number3 = 20;
                System.out.println(number2 + number3);
        }
        class Exercise05 {
            public static void main(String[] args) {
                int number = 5; // Change this number for a different table
                System.out.println("Multiplication Table for " + number);
                for (int i = 1; i <= 10; i++) {
                    System.out.println(number + " x " + i + " = " + (number * i));
                }
            }
        }
        class Exercise06 {
            public static void main(String[] args) {
                String original = "Eugene";
                String reversed = "";
        
                for (int i = original.length() - 1; i >= 0; i--) {
                    reversed += original.charAt(i);
                }
        
                System.out.println("Original: " + original);
                System.out.println("Reversed: " + reversed);
            }
        }
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

     public class UtilityExample {
        public static void main(String[] args) {
            // Using exampleMethod
            int doubled = exampleMethod(7); // Doubling 7
            System.out.println("Doubled value: " + doubled); // Output: Doubled value: 14
    
            // Using displayMessage
            displayMessage("This is a test message!"); // Output: Message: This is a test message!
        }
        
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