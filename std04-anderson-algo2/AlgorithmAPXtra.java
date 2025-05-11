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
 *      javac std04-anderson-algo2/AlgorithmAPXtra.java
 *      ```
 * 3. Run & Clean: 
 *      ```
 *      java -cp std04-anderson-algo2 AlgorithmAPXtra; rm -rf std04-anderson-algo2/*.class
 *      ```
 */
import java.util.*;

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
        int bigTotal = big * 5; 
        int TotalTotal = bigTotal + small;
        if (TotalTotal == goal ){
            return true;
        }
        for (int s = 0; s <= small; s++){
            for (int b = 0; b <= big; b++){
                TotalTotal = (b * 5) + s;
                if (TotalTotal == goal ){
                    return true;
                }
            }
        }

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
        s = s.toLowerCase();
        int lastLetterOfWord = 0;
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if (!Character.isLetter(s.charAt(i)) && i != 0){
                if (s.charAt(i-1) == 'z') { answer++; }
                if (s.charAt(i-1) == 'y') { answer++; }
            } 
        }
        if (s.charAt(s.length()-1) == 'z') { answer++; }
        if (s.charAt(s.length()-1) == 'y') { answer++; }


        //        int firstSpacePlaces = s.indexOf(" ");
        // if (firstSpacePlaces == -1){
        //     if (s.charAt(s.length()-1) == 'z') { answer++; }
        //     if (s.charAt(s.length()-1) == 'y') { answer++; }
        // } else {
        //     int secondSpacePlaces = s.indexOf(" ", firstSpacePlaces + 1);
        //     if (s.charAt(firstSpacePlaces-1) == 'z') { answer++; }
        //     if (s.charAt(firstSpacePlaces-1) == 'y') { answer++; }
        //     if (secondSpacePlaces != -1){
        //     if (s.charAt(secondSpacePlaces-1) == 'z') { answer++; }
        //     if (s.charAt(secondSpacePlaces-1) == 'y') { answer++; }
        //     }
        //     if (s.charAt(s.length()-1) == 'z') { answer++; }
        //     if (s.charAt(s.length()-1) == 'y') { answer++; }
        // }
        return answer;
        // [Your Implementation Here]
    
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
        int number = 0;
        int numbersSpan = 0;
        int maxSpan = 0;
        for (int i = 0; i != nums.length; i++ ){
            number = nums[i];
            for (int brainHurt = nums.length - 1; brainHurt >= 0; brainHurt--){
                if(nums[brainHurt] == number){
                    numbersSpan = brainHurt - i + 1;
                    break;
                }
            }
            if (numbersSpan > maxSpan){
                maxSpan = numbersSpan;
            }
        }
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return maxSpan;
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
        int timesDog = 0;
        int timesCat = 0;
        for (int i = 0; i < s.length() - 2; i++){
            if(s.charAt(i) == 'c' && s.charAt(i + 1) == 'a' && s.charAt(i + 2) == 't'){
                timesCat++; 
            } else if(s.charAt(i) == 'd' && s.charAt(i + 1) == 'o' && s.charAt(i + 2) == 'g'){
                timesDog++; 
            }
        }
        return timesCat == timesDog;
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        // return false;
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
        int co_eTimes = 0;
        for (int i = 0; i < s.length() - 3; i++){
            if(s.charAt(i) == 'c' && s.charAt(i + 1) == 'o' && s.charAt(i + 3) == 'e'){
                co_eTimes++; 
            }
        }
        return co_eTimes;

        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        // return 0;
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
        int total = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 13){ 
                i++;
            } else {
                total = total + nums[i];
            }
        }
                // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return total;
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
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == 2 && nums[i + 1] == 2){
                return true;
            }
        }

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
        int total = 0; 
        if (a != b && a != c) {
            total = total + a;
        }
        if (b != a && b != c) {
            total = total + b;
        }
        if (c != a && c != b) {
            total = total + c;
        }
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return total;
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
        String result = base.replace(remove, "");
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return result;
    }









    /**
     * < Q36 >
     * Return a list containing exactly the same numbers as the given array,
     * but rearranged so that every 3 is immediately followed by a 4.
     * Do not move the 3's themselves, but every other number may move.
     * You may assume:
     *   - The array contains the same number of 3's and 4's.
     *   - Every 3 has a non-3 immediately after it.
     *   - No 4 appears before the first 3.
     *
     * @param nums The input array of integers containing matching numbers of 3's and 4's.
     * @return A new array where each 3 is immediately followed by a 4.
     * <p>
     * <ul>
     *   <li>fix34(new int[]{1,3,1,4}) returns [1,3,4,1]</li>
     *   <li>fix34(new int[]{1,3,1,4,4,3,1}) returns [1,3,4,1,1,3,4]</li>
     *   <li>fix34(new int[]{3,2,2,4}) returns [3,4,2,2]</li>
     * </ul>
     * </p>
     */
    public static int[] fix34(int[] nums) {

        for (int i = 0; i < nums.length -1 ; i++){
            if (nums[i] == 3){
                nums[i + 1] = 4;
            }else if (nums[i] == 4){
                nums[i] = null;
            }
        }
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
     * < Q37 >
     * Given two strings, return true if either of the strings appears at the very end
     * of the other string, ignoring upper/lower case differences.
     *
     * @param a First input string.
     * @param b Second input string.
     * @return true if one string appears at the end of the other (case-insensitive), else false.
     * <p>
     * <ul>
     *   <li>endOther("Hiabc", "abc") returns true</li>
     *   <li>endOther("AbC", "HiaBc") returns true</li>
     *   <li>endOther("abc", "abXabc") returns true</li>
     * </ul>
     * </p>
     */
    public static boolean endOther(String a, String b) {
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        return false;
    }






















    
}


















