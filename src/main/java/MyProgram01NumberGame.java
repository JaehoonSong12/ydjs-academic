import java.util.Scanner;

public class MyProgram01NumberGame {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        repeatNumber(x, y);
        // numberGame();
        return;
    }

    public static void repeatNumber(int z, int y) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many times do you want to repeat the number?");
        z = scan.nextInt();
        System.out.println("What number do you want to repeat?");
        y = scan.nextInt();

        if(z<1)
        {
            // throw new RuntimeException("0 and negative numbers are not allowed.");
            System.out.println("0 and negative numbers are not allowed.");
            return;
        }

        System.out.println("============ start ==============");

        for (int i = 0; i < z; i++) {
            System.out.println(y);
        }
        return;
    } 

    public static void numberGame() {
        Scanner scan = new Scanner(System.in);
        // Choose a random number from 0-100 
        int randNum = (int) (Math.random() * 101); // 0 <= x < 101

        // Ask the user to guess a number from 0 to 100 
        System.out.println("Guess a random number 0 to 100");
        // Get the first guess using scan.nextInt();
        int guess = scan.nextInt();

        // Loop while the guess does not equal the random number
        while (guess != randNum) {
            // If the guess is less than the random number, print out "Too low!"
            if (guess < randNum) System.out.println("Too low!");
            // If the guess is greater than the random number, print out "Too high!"
            if (guess > randNum) System.out.println("Too high!");
            // Get a new guess (save it into the same variable)
            guess = scan.nextInt();
        }

        // Print out something like "You got it!"
        System.out.println("You got it!");
        scan.close();
    }
}
