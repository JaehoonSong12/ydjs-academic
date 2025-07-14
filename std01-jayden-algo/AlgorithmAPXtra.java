
// import java.lang.*; <----------- by JVMjava

import java.util.ArrayList;
import java.util.List;
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
 * 2. Compile (Current Test Only): 
 *  ```
 *  javac AlgorithmAPXtra.java
 *  ```
 * 3. Run & Clean: 
 *  ```
 *  java AlgorithmAPXtra && rm -rf AlgorithmAPXtra*.class
 *  ```
 * 4. Clean: 
 *  ```
 *  rm -rf AlgorithmAPXtra*.class
 *  ```
 */
public class AlgorithmAPXtra {
    /**
     * < Q00 >
     * This is a placeholder for the main method. It can be used to test the methods in this class.
     * You can add your own test cases here.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");


        System.out.println(countYZ("!!day--yaz!!"));
        System.out.println(countYZ("yak zak"));
        System.out.println(countYZ("DAY abc XYZ"));
    }




    

    /**
     * < Q27 >
     * Determine if it is possible to reach the desired goal length
     * using a combination of small bricks (1 inch each) and big bricks (5 inches each).
     * The function returns true if the goal can be reached exactly, otherwise false.
     *
     * @param small Number of small bricks (1 inch each).
     * @param big   Number of big bricks (5 inches each).
     * @param goal  The target length to achieve.
     * @return true if the goal can be reached using the available bricks, false otherwise.
     * <p>
     * <ul>
     *   <li>makeBricks(3, 1, 8) returns true</li>
     *   <li>makeBricks(3, 1, 9) returns false</li>
     *   <li>makeBricks(3, 2, 10) returns true</li>
     * </ul>
     * </p>
     */
    public static boolean makeBricks(int small, int big, int goal) {
        // [Your Implementation Here]
        for (int i = 0; i < big; i++) {
            goal -= 5;
            if (goal < 0) {
                goal += 5;
                break;
            }


        }

        return (small >= goal);

    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        // return false;
    }

    
    /**
     * < Q28 >
     * Given a string, count the number of words ending in 'y' or 'z'.
     * The character must appear at the end of a word - that is, it must not be
     * immediately followed by another alphabetic letter. Comparison is case-insensitive.
     *
     * @param s The input string.
     * @return The number of words ending in 'y' or 'z'.
     * <p>
     * <ul>
     *   <li>countYZ("fez day") returns 2</li>
     *   <li>countYZ("day fez") returns 2</li>
     *   <li>countYZ("day fyyyz") returns 2</li>
     * </ul>
     * </p>
     */
    public static int countYZ(String s) {
        // [Your Implementation Here]
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == 'y' || s.charAt(i) == 'z') {
                if (Character.isLetter(s.charAt(i+1)) == false) {
                    count++;
                }
            }
        }
        if (s.charAt(s.length()-1) == 'y' || s.charAt(s.length()-1) == 'z'){
            count++;
        }
        return count;
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        // return 0;
    }

    /**
     * < Q29 >
     * Consider the leftmost and rightmost appearances of some value in an array.
     * We'll say that the "span" is the number of elements between the two, inclusive.
     * A single occurrence has a span of 1. Return the largest span found.
     *
     * @param nums The input array of integers.
     * @return The largest span found in the array.
     * <p>
     * <ul>
     *   <li>maxSpan(new int[]{1, 2, 1, 1, 3}) returns 4</li>
     *   <li>maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}) returns 6</li>
     *   <li>maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}) returns 6</li>
     * </ul>
     * </p>
     */
    public static int maxSpan(int[] nums) {
        int maxspan = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int s = nums.length-1; s >= i; s--) {
                if (nums[i] == nums[s]) {
                    int span = s-i+1;
                    if (span > maxspan) {
                        maxspan = span;
                    }
                    
                }
            }
        }
        return maxspan;
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        // return 0;
    }

    





















    
    /**
     * < Q30 >
     * Return true if the strings "cat" and "dog" appear the same number of times
     * in the given string. Comparison is case-sensitive and counts non-overlapping occurrences.
     *
     * @param s The input string to examine.
     * @return true if "cat" and "dog" occur the same number of times; false otherwise.
     * <p>
     * <ul>
     *   <li>catDog("catdog") returns true</li>
     *   <li>catDog("catcat") returns false</li>
     *   <li>catDog("1cat1cadodog") returns true</li>
     * </ul>
     * </p>
     */
    public static boolean catDog(String s) {
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
     * < Q31 >
     * Return the number of times that the string "code" appears anywhere in the given string,
     * except we'll accept any letter for the 'd' position-so "cope" and "cooe" count as well.
     *
     * @param s The input string to search within.
     * @return The count of substrings matching the pattern "co_e".
     * <p>
     * <ul>
     *   <li>countCode("aaacodebbb") returns 1</li>
     *   <li>countCode("codexxcode") returns 2</li>
     *   <li>countCode("cozexxcope") returns 2</li>
     * </ul>
     * </p>
     */
    public static int countCode(String s) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return 0;
    }

    /**
     * < Q32 >
     * Return the sum of the numbers in the list, returning 0 for an empty list.
     * The number 13 is unlucky-it does not count toward the sum, and any number
     * immediately following a 13 also does not count.
     *
     * @param nums A list of integers.
     * @return The sum according to the "13" rules described above.
     * <p>
     * <ul>
     *   <li>sum13([1, 2, 2, 1]) returns 6</li>
     *   <li>sum13([1, 1, 13, 2, 1, 13]) returns 3</li>
     *   <li>sum13([13, 1, 2, 13, 2, 1, 13]) returns 3</li>
     * </ul>
     * </p>
     */
    public static int sum13(int[] nums) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return 0;
    }

    /**
     * < Q33 >
     * Given a list of integers, return true if the list contains a 2 next to a 2 somewhere.
     *
     * @param nums The list of integers to check.
     * @return true if there is at least one occurrence of two consecutive 2's, false otherwise.
     * <p>
     * <ul>
     *   <li>has22(new int[]{1, 2, 2}) returns true</li>
     *   <li>has22(new int[]{1, 2, 1, 2}) returns false</li>
     *   <li>has22(new int[]{2, 2, 1, 2}) returns true</li>
     * </ul>
     * </p>
     */
    public static boolean has22(int[] nums) {
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
     * < Q34 >
     * Given 3 integer values, a, b, and c, return their sum.
     * However, if one of the values is the same as another value, that value does not count toward the sum.
     *
     * @param a First integer.
     * @param b Second integer.
     * @param c Third integer.
     * @return The sum of the values that are not duplicated.
     * <p>
     * <ul>
     *   <li>loneSum(1, 2, 3) returns 6</li>
     *   <li>loneSum(3, 2, 3) returns 2</li>
     *   <li>loneSum(3, 3, 3) returns 0</li>
     * </ul>
     * </p>
     */
    public static int loneSum(int a, int b, int c) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return 0;
    }

    /**
     * < Q35 >
     * Given two strings, base and remove, return a version of the base string where all
     * non-overlapping instances of the remove string have been removed. Removal is not case
     * sensitive, but the remaining characters keep their original case.
     * [Note: All the whitespace in the string should be replaced with a single space.]
     *
     * @param base   The original string.
     * @param remove The substring to remove (case-insensitive).
     * @return The resulting string after all instances of remove have been removed.
     * <p>
     * <ul>
     *   <li>withoutString("Hello there", "llo") returns "He there"</li>
     *   <li>withoutString("Hello there", "e") returns "Hllo thr"</li>
     *   <li>withoutString("abxxxxab", "xx") returns "abab"</li>
     * </ul>
     * </p>
     */
    public static String withoutString(String base, String remove) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return null;
    }

}
