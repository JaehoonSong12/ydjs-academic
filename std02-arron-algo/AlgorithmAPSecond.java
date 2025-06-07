
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
 *      javac std02-arron-algo/AlgorithmAPSecond.java
 *      ```
 * 3. Run & Clean: 
 *      ```
 *      java -cp std02-arron-algo AlgorithmAPSecond; rm -rf std02-arron-algo/*.class
 *      ```
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
        test();
    }
    public static void test() {
        final int n = 5_000;
        int[] base = new Random(0).ints(n, 0, n).toArray();

        // make copies
        int[] a1 = base.clone(), a2 = base.clone(), a3 = base.clone();
        int[] b1 = base.clone(), b2 = base.clone(), b3 = base.clone();

        // time O(n²) sorts
        long tBubble = time(() -> AlgorithmAPSecond.bubbleSort(a1));
        long tSelection = time(() -> AlgorithmAPSecond.selectionSort(a2));
        long tInsertion = time(() -> AlgorithmAPSecond.insertionSort(a3));

        // time O(n log n) sorts
        long tMerge = time(() -> AlgorithmAPSecond.mergeSort(b1));
        long tQuick = time(() -> AlgorithmAPSecond.quickSort(b2));
        long tHeap = time(() -> AlgorithmAPSecond.heapSort(b3));

        System.out.println(String.format("Bubble Sort: (%d ms)", tBubble));
        System.out.println(String.format("Selection Sort: (%d ms)", tSelection));
        System.out.println(String.format("Insertion Sort: (%d ms)", tInsertion));
        System.out.println(String.format("Merge Sort: (%d ms)", tMerge));
        System.out.println(String.format("Quick Sort: (%d ms)", tQuick));
        System.out.println(String.format("Heap Sort: (%d ms)", tHeap));
    }
    // helper to measure elapsed milliseconds
    private static long time(Runnable sortCall) {
        long start = System.nanoTime();
        sortCall.run();
        return (System.nanoTime() - start) / 1_000_000;
    }


  


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
        for(int i = nums.length - 1; i >= 0; i--){ // i: max (sorted max) index
            for (int j = 0; j < i; j++) { // j: bubble up index
                if (nums[j] <= nums[j+1]) continue;
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
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
        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[minIndex] > nums[j]) minIndex = j;
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        // i: min (left sorted min value) index
        // 
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
        // base-case
        if (nums.length < 2) return nums;
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
        }
        // recursive-case
        int leftIndex = 0;
        int rightIndex = 0;
        int[] left = new int[nums.length / 2];
        int[] right = new int[nums.length - nums.length / 2];
        for(int i = 0; i < nums.length; i++){
            if(i < nums.length / 2){ 
                left[leftIndex++] = nums[i];
            }
            else{
                right[rightIndex++] = nums[i];
            }
        }
        left = mergeSort(left); leftIndex = 0;
        right = mergeSort(right); rightIndex = 0;
        // merging process
        int i = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) nums[i] = left[leftIndex++]; 
            else nums[i] = right[rightIndex++];
            i++;
        }
        if(leftIndex == left.length) while(rightIndex != right.length) { // left ran out
            nums[i++] = right[rightIndex++];  
        }
        if(rightIndex == right.length) while(leftIndex != left.length){
            nums[i++] = left[leftIndex++];
        }
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
        /// base-case
        if (nums.length < 2) return nums;
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
        }
        /// recursive-case
        int bigPartSize = 0;
        int smallPartSize = 0;
        /// pivot (purple)
        int middleValue = nums[0];
        /// small & large partition, size look up
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= middleValue) bigPartSize++;
            else smallPartSize++;
        }
        /// small & large partition, array creation
        int[] smalls = new int[smallPartSize]; int smallIndex = 0;
        int[] bigs = new int[bigPartSize]; int bigIndex = 0;
        for(int i = 1; i < nums.length; i++){ // fill out values
            if(nums[i] >= middleValue) bigs[bigIndex++] = nums[i];
            else smalls[smallIndex++] = nums[i];
        }
        // sort 2 sub-problems using recursive call
        smalls = quickSort(smalls); // recursion
        bigs = quickSort(bigs); // recursion
        // merging process (small values on the left, pivot in the middle, large values on the right)
        int index = 0;
        for (int i = 0; i < smalls.length; i++) {
            nums[index++] = smalls[i];
        }
        nums[index++] = middleValue;
        for (int i = 0; i < bigs.length; i++) {
            nums[index++] = bigs[i];
        }
        return nums;
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
