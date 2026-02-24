/**
INSTRUCTIONS: 
    This is a java practice space for Eloise..!

COMPILE & EXECUTE & CLEANUP (Java):

     javac  -d out              Main*.java
     java           -cp out     Main*
     rm -rf out/
     












 */

// import java.lang.*; <----------- by JVMjava

import java.util.Scanner; // <----------- by programmer

public class Main {
    /**
     * main method is the entry point of a java program
     * main method is static because it can be called without creating an instance of the class
     * main method is void because it does not return any value
     * main method takes an array of strings as an argument, which can be used to pass command line arguments to the program
     * main method is public because it can be called from anywhere in the program
     */
    public static void main(String[] args) {
        System.out.println("Hello, Eloise");

        Scanner sc = new Scanner(System.in);


        // guessing number game
        // randomly generate a number between 1 and 100
        int numberToGuess = (int) (Math.random() * 100) + 1; // [0, 100) + 1 => [1, 101) => [1, 100]
        while(true) {
            System.out.print("Guess a number between 1 and 100: ");
            int userGuess = sc.nextInt();
            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number!");
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

    }

    public static void datatypesExample() {

        // boolean JVM-dependent Represents true and false values.
        boolean isJavaFun = false; // 0 or 1 (bit)
        System.out.println("Is Java fun? " + isJavaFun);

        // byte 8-bit Numerical, integral values.
        byte smallNumber = (byte) 190; // -128 to 127
        System.out.println("Small number: " + smallNumber);
        
        // short 16-bit Signed numerical, integral value.
        short mediumNumber = (short) 40000; // -32768 to 32767
        System.out.println("Medium number: " + mediumNumber);
        // char 16-bit Unsigned numerical, Unicode character.
        char letterA = 'A'; // Unicode character
        System.out.println("Letter A: " + letterA);
        System.out.println("Letter A (short casted): " + (short) letterA); // https://www.ascii-code.com/

        // int 32-bit Numerical, integral value.
        int largeNumber = 100000; // -2,147,483,648 to 2,147,483,647
        System.out.println("Large number: " + largeNumber);
        // long 64-bit Numerical, integral value.
        long veryLargeNumber = 10000000000L; // -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        System.out.println("Very large number: " + veryLargeNumber);
        // float 32-bit Floating-point value.
        float pi = 3.14f; // 6-7 decimal digits of precision
        System.out.println("Value of pi: " + pi);
        // double 64-bit Floating-point value.
        double e = 2.71828; // 15-16 decimal digits of precision
        System.out.println("Value of e: " + e);
    }

    public static void objectOritentedExample() {
        
        Sandwich mine = new Sandwich(
            "wheat", "mustard", "Beef"
        );
        
        Sandwich eloise = new Sandwich(
            "white","spicy mayo","turkey"
        );
        
        System.out.println(mine);
        System.out.println(eloise);
    }
}

class Sandwich {
    String bread;
    String condiments;
    String meat;
    
    public Sandwich(String bread, String condiments, String meat) {
        this.bread = bread;
        this.condiments = condiments;
        this.meat = meat;
    }
    
    @Override public String toString() {
        return "Sandwich with " + bread + ", " + condiments + ", "+ meat;
    }
}

/**
 * Java
 * 1. Object Oriented Programming Lanugage 
 * (Industiral Revolution)
 * 
 * 2. class (machines) to produce objects (products)
 * 
 */

