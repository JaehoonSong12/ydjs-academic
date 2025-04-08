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
 *      `javac async-anderson-algo/Algorithm.java`
 * 3. Run: 
 *      `java -cp async-anderson-algo Algorithm`
 * 4. Clean: 
 *      `rm -rf async-anderson-algo/*.class`
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
        // // classic way (using for-loop)
        // int product = 1;
        // for(int i = 1; i <= n; i++) {
        //     product = product * i;
        // }
        // return product;

        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        if (n == 0) return 1;
        // 2. recursive-case
        return n * factorial(n - 1);
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

        // // classic way (using for-loop)
        // return bunnies * 2;

        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        if (bunnies <= 0) return 0;
        // 2. recursive-case
        return 2 + bunnyEars(bunnies-1);
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

        // classic way (using for-loop)
        // if (n <= 0) return 0;
        // return n;

        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        if (n <= 0) {return 0;}
        if (n == 1) {return 1;}
        if (n == 2) {return 1;}
        // 2. recursive-case
        return fibonacci(n-1) + fibonacci(n-2);
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
        
        // //classic way (using for-loop)
        // if (n <= 9) {
        //     return n;
        //     }
        //     int total = 0;
        //     int remains = n;
        //     int answer = 0;
        //     int n_int = (int) (Math.log10(n) + 1);
        //     //if (n < )
        //     for (int i = 0; i < n_int; i++) {// n = 7
        //         total = remains % 10; // total = 7
        //         remains = remains - total; // remains = 7
        //         remains = remains / 10; // remains = 0
        //         answer = total + answer; // 0 + 3 + 7
        //     }
        // return answer;


        // if (n < 10) return n;

        // int answer = 0;
        // String str = Integer.toString(n);
        // for (int i = 0; i < str.length(); i++) {
        //     int digit = Character.getNumericValue(str.charAt(i));
        //     answer += digit;
        //     System.out.println(str.charAt(i));
        // }


        int answer = 0;
        for (int i = 0; n > 0; n = n / 10) answer += n % 10;
        
        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        // 2. recursive-case
        return answer;
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

        // classic way (using for-loop)
        int count = 0;
        boolean double_8 = false;
        //if (n < )
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit == 8) {
                count++;
                if (double_8) {
                    count++;
                }
                double_8 = true;
            } else {
                double_8 = false;                
            }
            n /= 10;
        }
        return count;
    }    

        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        // 2. recursive-case

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
        int answer = base;
        // classic way (using for-loop)
        if (n == 1) {return answer;}
        while (n > 1){
            answer = answer * base;            
            n--;
        }
        return answer;

        // recursive way (divide-and-conquer, recursion)
        // 1. base-case
        // 2. recursive-case
    }


    






    /**
     * Main method to demonstrate sample outputs of the recursive algorithms.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("n/n/n/" + count8(818));
        System.out.println("factorial(5) = " + factorial(5));
        System.out.println("bunnyEars(5) = " + bunnyEars(5));
        System.out.println("fibonacci(7) = " + fibonacci(7));
        System.out.println("sumDigits(126) = " + sumDigits(126));
        System.out.println("count8(8818) = " + count8(8818));
        System.out.println("powerN(3, 3) = " + powerN(3, 3));
        System.out.println("HI");
        System.out.println(":"+count8(818)+":");


        
        System.out.println("sumDigits(1265487) = " + sumDigits(1265487));
    }
}