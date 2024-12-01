import java.util.Scanner;
import chapter01.*;
// import chapter02.*;
// import chapter03.*;
// import chapter04.*;
// import chapter05.*;



/**
 * The {@code Cli} class provides a command-line interface for executing
 * various tasks, such as running a number-guessing game or delegating to
 * other classes like Eugene01 or Payroll.
 */
public class Cli {

    /**
     * The entry point of the program.
     * Prints the command-line arguments and delegates to other methods or classes.
     * 
     * @param args Command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        // Print all command-line arguments
        for (String arg : args) {
            System.out.println(arg);
        }

        ////////////////////////////////////////
        // Uncomment the method or class to run for testing ***************************************************************
        ////////////////////////////////////////
        // numberGame();
        // Eugene01.main(args);
        // Payroll.main(args);


        Workspace.main(args);
        
        


    }

    /**
     * A simple number-guessing game.
     * The program randomly selects a number between 0 and 100, and the user is prompted
     * to guess the number. Feedback is provided if the guess is too high or too low,
     * and the game continues until the user guesses the correct number.
     */
    public static void numberGame() {
        Scanner scan = new Scanner(System.in);

        // Generate a random number between 0 and 100
        int randNum = (int) (Math.random() * 101);

        System.out.println("Guess a random number between 0 and 100:");

        int guess;
        do {
            // Ensure user input is a valid integer
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a valid number:");
                scan.next(); // Clear invalid input
            }
            guess = scan.nextInt();

            // Provide feedback on the guess
            if (guess < randNum) {
                System.out.println("Too low!");
            } else if (guess > randNum) {
                System.out.println("Too high!");
            }
        } while (guess != randNum); // Repeat until the user guesses correctly

        // Congratulate the user
        System.out.println("You got it!");

        // Close the scanner resource
        scan.close();
    }
}
