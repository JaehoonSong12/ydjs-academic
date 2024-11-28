import java.util.Scanner;

public class Cli 
{
  public static void main(String[] args) {
      for (String arg : args) {
        System.out.println(arg);
      }
    // numberGame();
    return;
  }

  public static void numberGame()
  {
    Scanner scan = new Scanner(System.in);
   // Choose a random number from 0-100 
    int randNum = (int)(Math.random()*101); // 0<=x<101
    
   // Ask the user to guess a number from 0 to 100 
  System.out.println("Guess a random number 0 to 100");
   // Get the first guess using scan.nextInt();
    int guess = scan.nextInt();

   // Loop while the guess does not equal the random number,
   while (guess != randNum)
   {
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