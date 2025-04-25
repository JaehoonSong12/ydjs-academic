/**
 * DecoratorPractice.java
 * 
 * This is a Java Swing application that 
 * 
 * MVC Design Principle:
 * - ...
 *
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      `javac async-jayden/*.java`
 * 3. Run: 
 *      `java -cp async-jayden DecoratorPractice`
 * 4. Clean: 
 *      `rm -rf async-jayden/*.class`
 */

public class DecoratorPractice {
    public static void main(String[] args) {
        print("Hello World");
    }

public interface Pizza {
    String Description();
    double cost();
}

public class NormalPizza implements Pizza {
    public String Description() {
        return "Pizza";
    }

    public double cost() {
        return 1.00;
    }
}

public abstract class Decorator implements Pizza {
    protected Pizza pizza;

    public Decorator(Pizza pizza) {
        this.pizza = pizza;
    }

    // public string Decorator() {
    //     return pizza.Decorator();
    // }

    public double cost() {
        return pizza.cost();
    }
}

















    public static void print(String text) {
        System.out.println(text);
    }
}