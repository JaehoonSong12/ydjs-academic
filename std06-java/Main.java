/**
INSTRUCTIONS: 
    This is a java practice space for Eloise..!

COMPILE & EXECUTE & CLEANUP (Java):

     javac  -d out              Main*.java
     java           -cp out     Main*
     rm -rf out/
     












 */

// import java.lang.*; <----------- by JVMjava



public class Main {
    public static void main(String[] args) {
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

