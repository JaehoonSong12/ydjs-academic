
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
 *      `javac std02-arron-algo/AlgorithmAPSecond.java`
 * 3. Run: 
 *      `java -cp std02-arron-algo AlgorithmAPSecond`
 * 4. Clean: 
 *      `rm -rf std02-arron-algo/*.class`
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class AlgorithmAPSecond {
    /**
     * < Q00 >
     * This is a placeholder for the main method. It can be used to 
     * test the methods in this class.
     * You can add your own test cases here.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
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











    /**
     * < Q20 >
     * Sort the given array in ascending order using the bubble sort algorithm.
     *
     * @param nums the array of integers to sort in-place
     * @return the same array, sorted in ascending order
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>bubbleSort(new int[]{5, 1, 4, 2, 8}) returns [1, 2, 4, 5, 8]</li>
     *   <li>bubbleSort(new int[]{}) returns []</li>
     *   <li>bubbleSort(new int[]{3}) returns [3]</li>
     * </ul>
     */
    public static int[] bubbleSort(int[] nums) {
        // [Your Implementation Here]
        return nums;
    }

    /**
     * < Q21 >
     * Sort the given array in ascending order using the selection sort algorithm.
     *
     * @param nums the array of integers to sort in-place
     * @return the same array, sorted in ascending order
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>selectionSort(new int[]{64, 25, 12, 22, 11}) returns [11, 12, 22, 25, 64]</li>
     *   <li>selectionSort(new int[]{2, 1}) returns [1, 2]</li>
     * </ul>
     */
    public static int[] selectionSort(int[] nums) {
        // [Your Implementation Here]
        return nums;
    }

    /**
     * < Q22 >
     * Sort the given array in ascending order using the insertion sort algorithm.
     *
     * @param nums the array of integers to sort in-place
     * @return the same array, sorted in ascending order
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>insertionSort(new int[]{12, 11, 13, 5, 6}) returns [5, 6, 11, 12, 13]</li>
     *   <li>insertionSort(new int[]{1, 2, 3}) returns [1, 2, 3]</li>
     * </ul>
     */
    public static int[] insertionSort(int[] nums) {
        // [Your Implementation Here]
        return nums;
    }

    /**
     * < Q23 >
     * Sort the given array in ascending order using the merge sort algorithm.
     *
     * @param nums the array of integers to sort
     * @return a new array, sorted in ascending order
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>mergeSort(new int[]{38, 27, 43, 3, 9, 82, 10}) returns [3, 9, 10, 27, 38, 43, 82]</li>
     *   <li>mergeSort(new int[]{}) returns []</li>
     * </ul>
     */
    public static int[] mergeSort(int[] nums) {
        // [Your Implementation Here]
        return nums;
    }

    /**
     * < Q24 >
     * Sort the given array in ascending order using the quick sort algorithm.
     *
     * @param nums the array of integers to sort in-place
     * @return the same array, sorted in ascending order
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>quickSort(new int[]{10, 7, 8, 9, 1, 5}) returns [1, 5, 7, 8, 9, 10]</li>
     *   <li>quickSort(new int[]{}) returns []</li>
     * </ul>
     */
    public static int[] quickSort(int[] nums) {
        // [Your Implementation Here]
        // 1. base-case
        // 2. recursive-case
        return null;
    }

    /**
     * < Q25 >
     * Sort the given array in ascending order using the heap sort algorithm.
     *
     * @param nums the array of integers to sort in-place
     * @return the same array, sorted in ascending order
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>heapSort(new int[]{12, 11, 13, 5, 6, 7}) returns [5, 6, 7, 11, 12, 13]</li>
     *   <li>heapSort(new int[]{}) returns []</li>
     * </ul>
     */
    public static int[] heapSort(int[] nums) {
        // [Your Implementation Here]
        return nums;
    }
}
