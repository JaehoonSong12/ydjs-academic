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
 *      ```
 *      javac _instructor/AlgorithmAPXXXtra.java
 *      ```
 * 3. Run & Clean: 
 *      ```
 *      java -cp _instructor AlgorithmAPXXXtra; rm -rf _instructor/*.class
 *      ```
 */
import java.util.*;

public class AlgorithmAPXXXtra {
    /**
     * < Q00 >
     * This is a placeholder for the main method. It can be used to test the methods in this class.
     * You can add your own test cases here.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }





    
    /**
     * < Q46 >
     * Given a string {@code s} and an integer {@code n}, return a string made of the first {@code n} characters
     * of {@code s}, followed by the first {@code n-1} characters, and so on down to 1.
     * You may assume {@code 0 ≤ n ≤ s.length()}.
     *
     * @param s The input string.
     * @param n Number of characters to start with.
     * @return The concatenated prefix sequence.
     * <p>
     * <ul>
     *   <li>repeatFront("Chocolate", 4) returns "ChocChoChC"</li>
     *   <li>repeatFront("Chocolate", 3) returns "ChoChC"</li>
     *   <li>repeatFront("Ice Cream", 2) returns "IcI"</li>
     * </ul>
     * </p>
     */
    public static String repeatFront(String s, int n) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return null;
    }

    
    /**
     * < Q47 >
     * Given a number n, create and return a new array of length n containing the numbers
     * 0, 1, 2, ... n-1. If n is 0, return an empty array.
     *
     * @param n Non‑negative length of the array to generate.
     * @return An int array of integers from 0 up to n‑1.
     * <p>
     * <ul>
     *   <li>fizzArray(4) returns [0, 1, 2, 3]</li>
     *   <li>fizzArray(1) returns [0]</li>
     *   <li>fizzArray(10) returns [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]</li>
     * </ul>
     * </p>
     */
    public static int[] fizzArray(int n) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return null;
    }


    
    /**
     * < Q48 >
     * Given a list of integers, return true if every element is either a 1 or a 4.
     * An empty array counts as true since there are no disallowed elements.
     *
     * @param nums The array of integers to check.
     * @return true if every element is 1 or 4, false otherwise.
     * <p>
     * <ul>
     *   <li>only14(new int[]{1,4,1,4}) returns true</li>
     *   <li>only14(new int[]{1,4,2,4}) returns false</li>
     *   <li>only14(new int[]{1,1}) returns true</li>
     * </ul>
     * </p>
     */
    public static boolean only14(int[] nums) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return false;
    }


    
    /**
     * < Q49 >
     * Given a non-negative integer n, create and return a new array of length n
     * containing the string representations of the numbers 0, 1, 2, ... n-1.
     * If n is 0, return an empty array.
     *
     * @param n The length of the array to generate (n ≥ 0).
     * @return A String array of "0" through String.valueOf(n-1).
     * <p>
     * <ul>
     *   <li>fizzArray2(4)  returns ["0","1","2","3"]</li>
     *   <li>fizzArray2(10) returns ["0","1","2","3","4","5","6","7","8","9"]</li>
     *   <li>fizzArray2(2)  returns ["0","1"]</li>
     * </ul>
     * </p>
     */
    public static String[] fizzArray2(int n) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return null;
    }


    
    /**
     * < Q50 >
     * Given three integer values a, b, and c, return their sum. However, if any of the values
     * is a 'teen' (in the range 13..19 inclusive), that value counts as 0, except 15 and 16 are not
     * considered teens. Uses a helper method fixTeen to adjust each value.
     *
     * @param a First integer value.
     * @param b Second integer value.
     * @param c Third integer value.
     * @return The sum after applying the teen rules.
     * <p>
     * <ul>
     *   <li>noTeenSum(1, 2, 3) returns 6</li>
     *   <li>noTeenSum(2, 13, 1) returns 3</li>
     *   <li>noTeenSum(2, 1, 14) returns 3</li>
     * </ul>
     * </p>
     */
    public static int noTeenSum(int a, int b, int c) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return null;
    }
    /**
     * Adjusts a single value according to the teen rules: returns 0 if n is in [13..19]
     * except 15 or 16; otherwise returns n.
     *
     * @param n The integer to adjust.
     * @return 0 if n is a disallowed teen, else n.
     */
    private static int fixTeen(int n) {
        // [Your Implementation Here]
        // This is a helper method to adjust the value according to the rules.
        return 0;
    }
}