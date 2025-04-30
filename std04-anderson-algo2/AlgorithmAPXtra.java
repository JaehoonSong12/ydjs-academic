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
 * 2. Compile: 
 *      `javac std04-anderson-algo2/AlgorithmAPXtra.java`
 * 3. Run: 
 *      `java -cp std04-anderson-algo2 AlgorithmAPXtra`
 * 4. Clean: 
 *      `rm -rf std04-anderson-algo2/*.class`
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
     * The character must appear at the end of a word — that is, it must not be
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
        int firstSpacePlaces = s.indexOf(" ");
        int answer = 0;
        if (firstSpacePlaces == -1){
            if (s.charAt(s.length()-1) == 'z') { answer++; }
            if (s.charAt(s.length()-1) == 'y') { answer++; }
        } else {
            int secondSpacePlaces = s.indexOf(" ", firstSpacePlaces + 1);
            if (s.charAt(firstSpacePlaces-1) == 'z') { answer++; }
            if (s.charAt(firstSpacePlaces-1) == 'y') { answer++; }
            if (secondSpacePlaces != -1){
            if (s.charAt(secondSpacePlaces-1) == 'z') { answer++; }
            if (s.charAt(secondSpacePlaces-1) == 'y') { answer++; }
            }
            if (s.charAt(s.length()-1) == 'z') { answer++; }
            if (s.charAt(s.length()-1) == 'y') { answer++; }
        }
        return answer;
            
        // [Your Implementation Here]
    
        // Case-1. If the question can be solved with 'iteration (for/while)', 
        //         design the most efficient algorithm.
    
        // Case-2. If the question can be solved with 'recursion', design a 
        //         correct algorithm. Since the recursion can be inefficient, 
        //         use either 'tabulation' or 'memorization' to break it down 
        //         into 'iteration'.
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

    // Q30 coming soon..!
}
