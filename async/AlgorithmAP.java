
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
 *      `javac async-algo/AlgorithmAP.java`
 * 3. Run: 
 *      `java -cp async-algo AlgorithmAP`
 * 4. Clean: 
 *      `rm -rf async-algo/*.class`
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class AlgorithmAP {
    /**
     * < Q00 >
     * This is a placeholder for the main method. It can be used to test the methods in this class.
     * You can add your own test cases here.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");


        List<String> result = new ArrayList<>();
        result.add("apple");
        result.add("watermelon");
        result.add("pineapple");
        result.add("banana");

        System.out.println("List of fruits: " + result);
        System.out.println("Number of fruits: " + result.size());


        String[] fruits = new String[10];
        fruits[0] = "apple";
        fruits[1] = "banana";
        fruits[2] = "orange";
        fruits[3] = "watermelon"; // ArrayIndexOutOfBoundsException

        System.out.println("List of fruits: " + Arrays.toString(fruits));
        System.out.println("Number of fruits: " + fruits.length);
    }

    /**
     * < Q01 >
     * Given an array of scores (integers), return true if the scores are
     * in non-decreasing order — that is, each score is equal to or 
     * greater than the one before.
     *
     * @param scores an array of integers (length 2 or more)
     * @return true if each score is equal or greater than the previous one, 
     *         false otherwise
     * <p>
     * <ul>
     *   <li>scoresIncreasing(new int[]{1, 3, 4}) returns true</li>
     *   <li>scoresIncreasing(new int[]{1, 3, 2}) returns false</li>
     *   <li>scoresIncreasing(new int[]{1, 1, 4}) returns true</li>
     * </ul>
     * </p>
     */
    public static boolean scoresIncreasing(int[] scores) {
        // [Your Implementation Here]
        for (int i = 1; i < scores.length; i++) {
            if (scores[i-1] > scores[i]) return false;
        }
        return true;
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
        // return false;
    }

    /**
     * < Q02 >
     * Given an array of scores, return true if there are scores of 100
     * next to each other in the array.
     *
     * @param scores an array of integer scores (length at least 2)
     * @return true if there is at least one occurrence of consecutive 100's, 
     *         else false
     * <p>
     * Examples:
     * <ul>
     *   <li>scores100(new int[]{1, 100, 100}) returns true</li>
     *   <li>scores100(new int[]{1, 100, 99, 100}) returns false</li>
     *   <li>scores100(new int[]{100, 1, 100, 100}) returns true</li>
     * </ul>
     * </p>
     */
    public static boolean scores100(int[] scores) {
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
     * < Q03 >
     * Given an array of scores sorted in increasing order,
     * return true if the array contains 3 adjacent scores that differ
     * from each other by at most 2. In other words, if any consecutive
     * triplet of scores has a maximum difference (between the highest and
     * lowest) of 2 or less, the function returns true.
     *
     * @param scores an array of integer scores, sorted in increasing order
     * @return true if there exists a triplet of adjacent scores with a max 
     *         difference of 2 or less, otherwise false
     * <p>
     * Examples:
     * <ul>
     *   <li>scoresClump(new int[]{3, 4, 5}) returns true</li>
     *   <li>scoresClump(new int[]{3, 4, 6}) returns false</li>
     *   <li>scoresClump(new int[]{1, 3, 5, 5}) returns true</li>
     * </ul>
     * </p>
     */
    public static boolean scoresClump(int[] scores) {
        // [Your Implementation Here]
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        return false;
    }


    /**
     * < Q04 >
     * Given an array of scores, compute the integer average of the
     * first half and the second half, and return whichever is larger.
     * The second half begins at index scores.length / 2.
     *
     * You must use a helper function that computes the average
     * of the values between two indices.
     *
     * @param scores an array of integer scores (at least 2 elements long)
     * @return the higher integer average between the first and second half of the list
     *
     * <p>
     * Examples:
     * <ul>
     *   <li>scoresAverage(new int[]{2, 2, 4, 4}) returns 4</li>
     *   <li>scoresAverage(new int[]{4, 4, 4, 2, 2, 2}) returns 4</li>
     *   <li>scoresAverage(new int[]{3, 4, 5, 1, 2, 3}) returns 4</li>
     * </ul>
     * </p>
     */
    public static int scoresAverage(int[] scores) {
        // [Your Implementation Here]
        int midIndex = scores.length / 2;
        int[] firstHalf = new int[midIndex];
        int[] secondHalf = new int[scores.length - midIndex];
        
        for (int i=0; i < scores.length; i++) {
            if (i < midIndex) firstHalf[i] = scores[i];
            else secondHalf[i - midIndex] = scores[i];
        }
        int firstAvg = 0;
        int secondAvg = 0;
        for (int i=0; i < firstHalf.length; i++) {
            firstAvg += firstHalf[i];
        }
        firstAvg /= firstHalf.length;
        for (int i=0; i < secondHalf.length; i++) {
            secondAvg += secondHalf[i];
        }
        secondAvg /= firstHalf.length;

        return (firstAvg > secondAvg) ? (firstAvg) : (secondAvg);


        
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        // return 0;
    }
    /**
     * Helper function to compute the integer average of elements in scores[start:end).
     *
     * @param scores the array of scores
     * @param start the start index (inclusive)
     * @param end the end index (exclusive)
     * @return the integer average of the values between start and end
     */
    private static int average(int[] scores, int start, int end) {
        // [Your Implementation Here]
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        return 0;
    }



    /**
     * < Q05 >
     * Given an array of strings, return the count of the number
     * of strings that have the given length.
     *
     * @param words an array of strings
     * @param length the target length to match
     * @return the number of strings in the array that have the given length
     *
     * <p>
     * Examples:
     * <ul>
     *   <li>wordsCount(new String[]{"a", "bb", "b", "ccc"}, 1) returns 2</li>
     *   <li>wordsCount(new String[]{"a", "bb", "b", "ccc"}, 3) returns 1</li>
     *   <li>wordsCount(new String[]{"a", "bb", "b", "ccc"}, 4) returns 0</li>
     * </ul>
     * </p>
     */
    public static int wordsCount(String[] words, int length) {
        int count = 0;
        for (int i=0; i < words.length; i++){
            if (words[i].length() == length) {
                count++;
            }
        }
        return count;



        // [Your Implementation Here]
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        // return 0;
    }

    /**
     * < Q06 >
     * Given an array of strings, return a new array containing the first N strings.
     * N will be in the range 1..length of the input array.
     *
     * @param words an array of strings
     * @param n the number of strings to return from the start
     * @return an array containing the first N strings
     *
     * <p>
     * Examples:
     * <ul>
     *   <li>wordsFront(new String[]{"a", "b", "c", "d"}, 1) -> ["a"]</li>
     *   <li>wordsFront(new String[]{"a", "b", "c", "d"}, 2) -> ["a", "b"]</li>
     *   <li>wordsFront(new String[]{"a", "b", "c", "d"}, 3) -> ["a", "b", "c"]</li>
     * </ul>
     * </p>
     */
    public static String[] wordsFront(String[] words, int n) {
        // [Your Implementation Here]


        // 1. array creation
        String[] copy = new String[n];


        // 2. array copy
        for (int i=0; i < n; i++) {
            copy[i] = words[i];
        }

        // 3. return the new array
        return copy;
        
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        // return null;
    }




    /**
     * < Q07 >
     * Given an array of strings, return a new list where all the 
     * strings of the given length are omitted.
     *
     * @param words an array of strings
     * @param length the length of the strings to omit from the list
     * @return a new list with all strings of the given length omitted
     *
     * <p>
     * Examples:
     * <ul>
     *   <li>wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 1) returns ["bb", "ccc"]</li>
     *   <li>wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 3) returns ["a", "bb", "b"]</li>
     *   <li>wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 4) returns ["a", "bb", "b", "ccc"]</li>
     * </ul>
     * </p>
     */
    public static List<String> wordsWithoutList(String[] words, int length) {
        List<String> result = new ArrayList<>();
        // [Your Implementation Here]
        for(int i=0; i < words.length; i++){
            if (words[i].length() != length) 
            result.add(words[i]);
        }
        return result;
            
        // }
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        // return result;
    }

    /**
     * < Q08 >
     * Given a positive integer n, return true if it contains a digit '1'.
     * Note: Use % to get the rightmost digit, and / to discard the rightmost digit.
     *
     * @param n a positive integer
     * @return true if the number contains at least one digit '1', false otherwise
     *
     * <p>
     * Examples:
     * <ul>
     *   <li>hasOne(10) returns true</li>
     *   <li>hasOne(22) returns false</li>
     *   <li>hasOne(220) returns false</li>
     * </ul>
     * </p>
     */
    public static boolean hasOne(int n) {
        // [Your Implementation Here]
        for(int i = 0; n > 0; n /= 10){
            if (n % 10 == 1) return true;
        }
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        return false;
    }


    /**
     * < Q09 >
     * A positive integer divides itself if every digit in the number divides into
     * the number evenly. For example, 128 divides itself since 1, 2, and 8 all divide 
     * into 128 evenly. A number with a 0 digit does not divide itself, as 0 does not 
     * divide into any number.
     *
     * @param n a positive integer
     * @return true if the number divides itself, false otherwise
     *
     * <p>
     * Examples:
     * <ul>
     *   <li>dividesSelf(128) returns true</li>
     *   <li>dividesSelf(12) returns true</li>
     *   <li>dividesSelf(120) returns false</li>
     * </ul>
     * </p>
     */
    public static boolean dividesSelf(int n) {
        // [Your Implementation Here]
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        return false;
    }




    /**
     * < Q10 >
     * Given an array of positive integers, return a new array containing 
     * the first {@code count} even numbers from the original array.
     * The original array will contain at least {@code count} even numbers.
     *
     * @param nums  an array of positive integers
     * @param count the number of even integers to return
     * @return an array of the first {@code count} even integers from the original array
     *
     * <p>
     * Examples:
     * <ul>
     *   <li>copyEvens(new int[]{3, 2, 4, 5, 8}, 2) returns [2, 4]</li>
     *   <li>copyEvens(new int[]{3, 2, 4, 5, 8}, 3) returns [2, 4, 8]</li>
     *   <li>copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 3) returns [6, 2, 4]</li>
     * </ul>
     * </p>
     */
    public static int[] copyEvens(int[] nums, int count) {
        int[] result = new int[count];
        // [Your Implementation Here]
        //
        // Case-1. If the question can be solved with 'iteration (for/while)',
        //         design the most efficient algorithm.
        //
        // Case-2. If the question can be solved with 'recursion', design a
        //         correct algorithm. Since the recursion can be inefficient,
        //         use either 'tabulation' or 'memorization' to break it down
        //         into 'iteration'.
        return result;
    }





    // Q11 comming soon..!
}
