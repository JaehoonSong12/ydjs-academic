package jayden.unit.a;



/**
 * Exercise class containing methods to solve various exercises from Chapter 1.
 */
public class Exercise {

    /**
     * Exercise 1.3: Displays a pattern.
     * <p>
     * The pattern to be displayed:
     * <pre>
     *      J     A     V     V     A
     *      J    A A     V   V     A A
     * J    J   AAAAA     V V     AAAAA
     *  J J    A     A     V     A     A
     * </pre>
     */
    public static void displayPattern() {
        System.out.println("     J     A     V     V     A");
        System.out.println("     J    A A     V   V     A A");
        System.out.println("J    J   AAAAA     V V     AAAAA");
        System.out.println(" J J    A     A     V     A     A");
        return;
    }

    /**
     * Exercise 1.6: Calculates and displays the summation of the series 1 + 2 + 3 + ... + 9.
     * <p>
     * The program computes the summation of integers from 1 to 9:
     * <pre>
     * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
     * </pre>
     */
    public static void displaySummation() {
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum += i;
        }
        System.out.println("The summation of 1 + 2 + 3 + ... + 9 is: " + sum);
    }

    /**
     * Exercise 1.9: Write a program that displays the area and perimeter of a 
     * rectangle with the width of 4.5 and height of 7.9 using the following 
     * formula: area = width * height
     */
    public static void displayRectangleProperties() {
        double width = 4.5;
        double height = 7.9;

        double area = width * height;
        double perimeter = 2 * (width + height);

        System.out.println("The area of the rectangle is: " + area);
        System.out.println("The perimeter of the rectangle is: " + perimeter);
        return;
    }

    /**
     * Exercise 1.12: Assume a runner runs 24 miles in 1 hour, 40 minutes, and 35 seconds. 
     * Write a program that displays the average speed in kilometers per hour. 
     * (Note that 1 mile is 1.6 kilometers.)
     */
    public static void displayAverageSpeed() {
        double miles = 24.0;
        double totalTimeInSeconds = (1 * 3600) + (40 * 60) + 35; // Convert time to seconds
        double kilometersPerMile = 1.6;

        double totalTimeInHours = totalTimeInSeconds / 3600.0;

        double kilometers = miles * kilometersPerMile;

        double averageSpeed = kilometers / totalTimeInHours;

        System.out.println("The average speed is: " + averageSpeed + " kilometers per hour.");
        return;
    }

    /**
     * Driver method to call individual exercise methods.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Exercise 1.3: Display a Pattern");
        displayPattern();
        System.out.println();

        System.out.println("Exercise 1.6: Summation of a Series");
        displaySummation();
        System.out.println();

        System.out.println("Exercise 1.9: Area and Perimeter of a Rectangle");
        displayRectangleProperties();
        System.out.println();

        System.out.println("Exercise 1.12: Average Speed in Kilometers");
        displayAverageSpeed();
    }
}
