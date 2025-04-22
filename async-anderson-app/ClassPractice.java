
/**
 * ClassPractice.java
 * 
 * This is a ClassPractice
 * 
 * MVC Design Principle:
 * - ...
 *
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      `javac async/*.java`
 * 3. Run: 
 *      `java -cp async ClassPractice`
 * 4. Clean: 
 *      `rm -rf async/*.class`
 */


public class ClassPractice {
    public static void main(String[] args) {
        // // Create a Car object using the non-public Car class
        // Car myCar = new Car("Toyota", 2020, "Red");
        // myCar.displayInfo();

        // // Using setter to update the year and then display updated info
        // myCar.setYear(2021);
        // System.out.println("After update:");
        // myCar.displayInfo();
        

        // Game.Name
        Game myGame = new Game("Anderson ",  "Ak " , "showdown " ,11 , 42);
        // myGame.setName("new name");
        myGame.displayInfo(); // request to display information of the game at the frontend desk! (API call)

        
        String str = "hi there"; // String str = new String("hi there"); 
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
}








class Game {
    /**
     * Attributes (Variables in Class) <--- encapsulation
     */
    // immutable data
    private String Name;
    public String getName() { return Name; } // getter (to read the data, only for reading, not modifying)
    // public void setName(String Name) { this.Name = Name; } // setter (to change the data), mutable

    // mutable data
    private int AgeOfUser;
    public int getAgeOfUser() { return AgeOfUser; }  
    public void setAgeOfUser(int AgeOfUser) { this.AgeOfUser = AgeOfUser; }  

    private String UserName;
    public String getUserName() { return UserName; }  
    public void setUserName(String UserName) { this.UserName = UserName; }  

    private String GameMode;
    public String getGameMode() { return GameMode; }  
    public void setGameMode(String GameMode) { this.GameMode = GameMode; }  

    private int level;
    public int getlevel() { return level; }  
    public void setlevel(int level) { this.level = level; }  


    /*
     * Methods (Functions in Class)
     */
    /**
     * Contructor, a special method called only when "new" operation.
     * No return type or value because it will return the allocated object (this)
     * @param Name
     * @param UserName
     * @param GameMode
     * @param AgeOfUser
     * @param level
     */
    public Game(String Name, String UserName, String GameMode, int AgeOfUser, int level){
        this.Name = Name;
        this.AgeOfUser = AgeOfUser;
        this.UserName = UserName;
        this.GameMode = GameMode;
        this.level = level;
        // return this;
    }

    // APIs (Application Programming Interfaces)
    public void displayInfo() {
        System.out.println("Game name: " + Name + ", Age Of User: " + AgeOfUser + ", UserName: " + UserName + "Game Mode:" + GameMode + "level" + level);
    }
}





// // Non-public Car class: This class is not declared as public so it is package-private.
// class Car {
//     // Fields are private to enforce encapsulation.
//     private String brand;
//     private int year;
//     private String color;

//     // Constructor to initialize the Car object.
//     public Car(String brand, int year, String color) {
//         this.brand = brand;
//         this.year = year;
//         this.color = color;
//     }

//     // Getter for brand
//     public String getBrand() {
//         return brand;
//     }

//     // Setter for brand
//     public void setBrand(String brand) {
//         this.brand = brand;
//     }

//     // Getter for year
//     public int getYear() {
//         return year;
//     }

//     // Setter for year with a basic validation example.
//     public void setYear(int year) {
//         if (year > 1885) {  // The first car was invented around 1885
//             this.year = year;
//         } else {
//             System.out.println("Invalid year for a car.");
//         }
//     }

//     // Getter for color
//     public String getColor() {
//         return color;
//     }

//     // Setter for color
//     public void setColor(String color) {
//         this.color = color;
//     }

//     // Method to display car details.
//     public void displayInfo() {
//         System.out.println("Car Brand: " + brand + ", Year: " + year + ", Color: " + color);
//     }
// }
