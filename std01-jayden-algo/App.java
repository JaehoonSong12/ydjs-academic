/**
INSTRUCTIONS: 
    The Algorithm class contains recursive methods for several algorithmic problems.
    It includes methods to compute factorial, count bunny ears, calculate Fibonacci numbers,
    sum the digits of a number, count occurrences of the digit 8 (with special counting rules),
    and compute exponentiation recursively.

COMPILE & EXECUTE & CLEANUP (Java):

     javac  -d out              App.java
     java           -cp out     App
     rm -rf out/
     












 */

public class App {
    /**
     * This is a placeholder for the main method. It can be used to test the methods in this class.
     * You can add your own test cases here.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        Animal cat = new Animal() {
            {
                // Initialization block (optional)
                name = "Mystery Beast";
                age = 5;
            }

            @Override
            public void makeNoise() {
                System.out.println(name + " says: Raaaawr!");
            }
        };

        // Use the object
        cat.makeNoise();           // prints: Mystery Beast says: Raaaawr!
        System.out.println(cat.age);  // prints: 5
    }
}

// Abstract class definition
abstract class Animal {
    int age;
    String name;

    public abstract void makeNoise();
}

class Cat extends Animal {
    // Initialization block (optional)
    name = "Mystery Beast";
    age = 5;

    @Override
    public void makeNoise() {
        System.out.println(name + " says: Raaaawr!");
    }
}