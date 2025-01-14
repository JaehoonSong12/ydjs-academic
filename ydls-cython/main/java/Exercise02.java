/**
 * Exercise class containing methods to solve various exercises 
 * about `Elementary Programming`.
 */
public class Exercise02 {

    /**
     * Exercise 2.3: (Convert feet into meters) Write a program that reads 
	 * a number in feet, converts it to meters, and displays the result. 
	 * One foot is 0.305 meter.
     */
    public static void convertFeetToMeters() {
        // [YOUR_IMPLEMENTATION]
        return;
    }

    /**
     * Exercise 2.6: (Sum the digits in an integer) Write a program that 
	 * reads an integer between 0 and 1000 and adds all the digits in 
	 * the integer. For example, if an integer is 932, the sum of all 
	 * its digits is 14.
     * <p>
     * For example:
     * <pre>
     * Input: 932
     * Output: 9 + 3 + 2 = 14
     * </pre>
     */
    public static void sumDigits() {
        // [YOUR_IMPLEMENTATION]
        return;
    }

    /**
     * Exercise 2.9: (Physics: acceleration) Average acceleration is 
	 * defined as the change of velocity divided by the time taken to 
	 * make the change, as shown in the following formula:
	 * <p>
	 * Write a program that prompts the user to enter the starting velocity v0 in meters/
	 * second, the ending velocity v1 in meters/second, and the time span t in seconds,
	 * and displays the average acceleration.
	 * 
     * Formula used:
     * <pre>
     * acceleration = (v1 - v0) / t
     * </pre>
     * Where:
     * v0 = initial velocity, v1 = final velocity, t = time.
     */
    public static void calculateAcceleration() {
        // [YOUR_IMPLEMENTATION]
        return;
    }

    /**
     * Exercise 2.12: (Physics: finding runway length) Given an airplane�s 
	 * acceleration a and take-off speed v, you can compute the minimum runway 
	 * length needed for an airplane to take off using the following formula.
	 * Write a program that prompts the user to enter v in meters/second (m/s) 
	 * and the acceleration a in meters/second squared (m/s2), and displays the 
	 * minimum runway length.
     * <p>
     * Formula used:
     * <pre>
     * length = (speed^2) / (2 * acceleration)
     * </pre>
     */
    public static void calculateRunwayLength() {
        // [YOUR_IMPLEMENTATION]
        return;
    }

    /**
     * Exercise 2.15: (Geometry: distance of two points) Write a program 
	 * that prompts the user to enter two points (x1, y1) and (x2, y2) and 
	 * displays their distance between them. The formula for computing the 
	 * distance is sqrt[(x2 - x1)^2 + (y2 - y1)^2)]. Note that you can use 
	 * Math.pow(a, 0.5) to compute sqrt(a). 
     * <p>
     * Formula used:
     * <pre>
     * distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     * </pre>
     */
    public static void calculateDistance() {
        // [YOUR_IMPLEMENTATION]
        return;
    }

    /**
     * Exercise 2.18: (Print a table) Write a program that displays 
	 * the following table. Cast floating point numbers into integers.
     * <p>
     * Example output:
     * <pre>
     * a    b    pow(a, b)
     * 1    2    1
     * 2    3    8
	 * 3 	4 	 81
	 * 4 	5 	 1024
	 * 5 	6 	 15625
     * </pre>
     */
    public static void printTable() {
        // [YOUR_IMPLEMENTATION]
        return;
    }

    /**
     * Exercise 2.21: (Financial application: calculate future investment value) 
	 * Write a program that reads in investment amount, annual interest rate, and 
	 * number of years, and displays the future investment value using the 
	 * following formula:
     * <p>
     * Formula used:
     * <pre>
     * futureValue = investment * (1 + monthlyRate)^(years * 12)
     * </pre>
	 * 
	 * For example, if you enter amount 1000, annual interest rate 3.25%, and 
	 * number of years 1, the future investment value is 1032.98. Here is a sample run:
	 * <p>
	 * Enter investment amount: 1000.56 Enter annual interest rate in percentage:
	 * 4.25 Enter number of years: 1 Accumulated value is $1043.92
     */
    public static void calculateFutureInvestmentValue() {
        // [YOUR_IMPLEMENTATION]
        return;
    }

    /**
     * Driver method to call individual exercise methods.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Exercise 2.3: Convert Feet to Meters");
        convertFeetToMeters();
        System.out.println();

        System.out.println("Exercise 2.6: Sum the Digits of an Integer");
        sumDigits();
        System.out.println();

        System.out.println("Exercise 2.9: Calculate Average Acceleration");
        calculateAcceleration();
        System.out.println();

        System.out.println("Exercise 2.12: Calculate Minimum Runway Length");
        calculateRunwayLength();
        System.out.println();

        System.out.println("Exercise 2.15: Calculate Distance Between Points");
        calculateDistance();
        System.out.println();

        System.out.println("Exercise 2.18: Print a Table of Powers");
        printTable();
        System.out.println();

        System.out.println("Exercise 2.21: Calculate Future Investment Value");
        calculateFutureInvestmentValue();
    }
}
