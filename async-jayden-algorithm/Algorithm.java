/**
 * The Algorithm class contains recursive methods for several algorithmic problems.
 * <p>
 * It includes methods to compute factorial, count bunny ears, calculate Fibonacci numbers,
 * sum the digits of a number, count occurrences of the digit 8 (with special counting rules),
 * and compute exponentiation recursively.
 * </p>
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      `javac async-jayden-algorithm/Algorithm.java`
 * 3. Run: 
 *      `java -cp async-jayden-algorithm Algorithm`
 * 4. Clean: 
 *      `rm -rf async-jayden-algorithm/*.class`
 */
public class Algorithm {

    /**
     * Computes the factorial of a given number n recursively.
     *
     * @param n the non-negative integer for which to compute the factorial.
     * @return the factorial of n.
     * <p>
     * Examples:
     * <ul>
     *   <li>factorial(0) returns 1</li>
     *   <li>factorial(1) returns 1</li>
     *   <li>factorial(5) returns 120</li>
     * </ul>
     */
    public static int factorial(int n) {
        // // classic way (using conditions, repetition)
        // int product = 1;
        // for (int num = n; num >= 1; num-- ){
        //     product = product * num;
        // }
        // return product;

        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        if (n == 0) return 1;
        if (n == 1) return 1;
        // 2. recursive-case
        return n * factorial(n - 1); // recursive function call (self-call)
    }






    /**
     * Recursively computes the total number of ears across a given number of bunnies.
     * Each bunny is assumed to have 2 ears.
     *
     * @param bunnies the number of bunnies.
     * @return the total number of ears.
     * <p>
     * Examples:
     * <ul>
     *   <li>bunnyEars(0) returns 0</li>
     *   <li>bunnyEars(1) returns 2</li>
     *   <li>bunnyEars(5) returns 10</li>
     * </ul>
     */
    public static int bunnyEars(int bunnies) {
        // // classic way (using conditions, repetition)
        // return bunnies*2;

        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        if (bunnies < 1) return 0;
        if (bunnies == 1) return 2;
        // 2. recursive-case
        return 2 + bunnyEars(bunnies - 1);
    }

    /**
     * Recursively calculates the nth Fibonacci number.
     * The sequence starts with fibonacci(0) = 0 and fibonacci(1) = 1.
     *
     * @param n the position in the Fibonacci sequence, starting from 0.
     * @return the nth Fibonacci number.
     * <p>
     * Examples:
     * <ul>
     *   <li>fibonacci(0) returns 0</li>
     *   <li>fibonacci(1) returns 1</li>
     *   <li>fibonacci(7) returns 13</li>
     * </ul>
     */
    public static int fibonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0;
        int b = 1;
        int sum;
        // classic way (using conditions, repetition)
        for (int num = 2; num <= n; num++){
            sum = a+b;
            a=b;
            b=sum;

        }

        return b;

        // // recursive way (divide-and-conquer, recursion)
        // // 1. base-case
        // if (n == 0) return 0;
        // if (n == 1) return 1;
        // // 2. recursive-case
        // return fibonacci(n - 2) + fibonacci(n - 1);
    }

    /**
     * Recursively sums the digits of a non-negative integer.
     *
     * @param n the non-negative integer whose digits will be summed.
     * @return the sum of the digits of n.
     * <p>
     * Examples:
     * <ul>
     *   <li>sumDigits(126) returns 9 (1+2+6)</li>
     *   <li>sumDigits(49) returns 13 (4+9)</li>
     *   <li>sumDigits(12) returns 3 (1+2)</li>
     * </ul>
     */
    public static int sumDigits(int n) {
        // classic way (using conditions, repetition)

        // int sum = 0;
        
        // while (n > 0) {
        //     sum += n % 10; // Add the last digit to sum
        //     n /= 10;       // Remove the last digit
        // }
        
        // return sum;

        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        if (n < 10) return n;
        // 2. recursive-case
        return (n % 10) + sumDigits(n / 10);
    }

    /**
     * Recursively counts the occurrences of the digit 8 in a non-negative integer.
     * An occurrence of 8 counts as double if it immediately follows another 8.
     *
     * @param n the non-negative integer to inspect.
     * @return the count of the digit 8, with adjacent 8's counted appropriately.
     * <p>
     * Examples:
     * <ul>
     *   <li>count8(8) returns 1</li>
     *   <li>count8(818) returns 2</li>
     *   <li>count8(8818) returns 4</li>
     * </ul>
     */
    public static int count8(int n) {

        // classic way (using conditions, repetition)
        int count = 0;
        boolean previousWasEight = false; // Track if the previous digit was 8
    
        while (n > 0) {
            int lastDigit = n % 10; // Get the last digit, (%): remainder operator,  8818 -> 881(8)
    
            if (lastDigit == 8) {
                if (previousWasEight) {
                    count += 2; // Double count if the previous digit was also 8
                } else {
                    count += 1;
                }
                previousWasEight = true; // Mark that the last digit was 8
            } else {
                previousWasEight = false; // Reset tracking if the digit is not 8
            }
    
            n /= 10; // compound operator, n = n / 10; (/): quotient operator,  8818 -> (881)8
        }
    
        return count;


        // Base case: If n is 0, there are no more digits to check
        if (n == 0) return 0;

        // Check the last digit
        int lastDigit = n % 10;
        int secondLastDigit = (n / 10) % 10; // Get the second last digit

        if (lastDigit == 8) {
            // If the previous digit is also 8, count double
            if (secondLastDigit == 8) {
                return 2 + count8(n / 10);
            }
            // Otherwise, count normally
            return 1 + count8(n / 10);
        }

        // Move to the next digit
        return count8(n / 10);
    }

    /**
     * Recursively computes the value of base raised to the power n.
     *
     * @param base the base number (must be 1 or more).
     * @param n the exponent (must be 1 or more).
     * @return the result of base raised to the power n.
     * <p>
     * Examples:
     * <ul>
     *   <li>powerN(3, 1) returns 3</li>
     *   <li>powerN(3, 2) returns 9</li>
     *   <li>powerN(3, 3) returns 27</li>
     * </ul>
     */
    public static int powerN(int base, int n) {

        // classic way (using conditions, repetition)
        // int result = 1;
    
        // for (int i = 0; i < n; i++) {
        //     result *= base;
        // }
        
        // return result;
        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        if (n == 1) return base;
        // 2. recursive-case
        return base * powerN(base, n - 1);
    }


    







    /**
     * Main method to demonstrate sample outputs of the recursive algorithms.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("factorial(5) = " + factorial(5));
        





        System.out.println("bunnyEars(5) = " + bunnyEars(5));
        System.out.println("fibonacci(7) = " + fibonacci(7));
        System.out.println("sumDigits(126) = " + sumDigits(126));
        System.out.println("count8(8818) = " + count8(8818));
        System.out.println("powerN(3, 3) = " + powerN(3, 3));
    }
}
