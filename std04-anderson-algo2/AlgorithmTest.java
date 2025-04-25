// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * The AlgorithmTest class provides JUnit tests for the recursive methods in the Algorithm class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      `javac -cp std04-anderson-algo2/junit-platform-console-standalone-1.9.3.jar std04-anderson-algo2/*.java`
 * 3. Run: 
 *      `java -jar std04-anderson-algo2/junit-platform-console-standalone-1.9.3.jar --class-path std04-anderson-algo2 --scan-classpath`
 * 4. Clean: 
 *      `rm -rf std04-anderson-algo2/*.class`
 */
public class AlgorithmTest {
    
    /*
     * Tests the scoresIncreasing method.
     */
    @Test
    public void testScoresIncreasing() {
        // int[] x = new int[]{1, 3, 4};
        assertTrue(Algorithm.scoresIncreasing(new int[]{1, 3, 4}));            // → True
        assertFalse(Algorithm.scoresIncreasing(new int[]{1, 3, 2}));           // → False
        assertTrue(Algorithm.scoresIncreasing(new int[]{1, 1, 4}));            // → True
        assertTrue(Algorithm.scoresIncreasing(new int[]{1, 1, 2, 4, 4, 7}));   // → True
        assertFalse(Algorithm.scoresIncreasing(new int[]{1, 1, 2, 4, 3, 7}));  // → False
        assertTrue(Algorithm.scoresIncreasing(new int[]{-5, 4, 11}));          // → True
    }

    /**
     * Tests the scores100 method.
     */
    @Test
    public void testScores100() {
        assertTrue(Algorithm.scores100(new int[]{1, 100, 100}));           // → True
        assertFalse(Algorithm.scores100(new int[]{1, 100, 99, 100}));        // → False
        assertTrue(Algorithm.scores100(new int[]{100, 1, 100, 100}));        // → True
        assertFalse(Algorithm.scores100(new int[]{100, 1, 100, 1}));         // → False
        assertFalse(Algorithm.scores100(new int[]{1, 2, 3, 4, 5}));          // → False
        assertFalse(Algorithm.scores100(new int[]{1, 2, 100, 4, 5}));        // → False
    }

    /**
     * Tests the scoresClump method.
     */
    @Test
    public void testScoresClump() {
        assertTrue(Algorithm.scoresClump(new int[]{3, 4, 5}));           // → True
        assertFalse(Algorithm.scoresClump(new int[]{3, 4, 6}));          // → False
        assertTrue(Algorithm.scoresClump(new int[]{1, 3, 5, 5}));         // → True
        assertTrue(Algorithm.scoresClump(new int[]{2, 4, 5, 6}));         // → True
        assertFalse(Algorithm.scoresClump(new int[]{2, 4, 5, 7}));         // → False
        assertTrue(Algorithm.scoresClump(new int[]{2, 4, 4, 7}));          // → True
        assertFalse(Algorithm.scoresClump(new int[]{3, 3, 6, 7, 9}));       // → False
        assertTrue(Algorithm.scoresClump(new int[]{3, 3, 7, 7, 9}));        // → True
        assertFalse(Algorithm.scoresClump(new int[]{4, 5, 8}));             // → False
    }

    /**
     * Tests the scoresAverage method.
     */
    @Test
    public void testScoresAverage() {
        assertEquals(4, Algorithm.scoresAverage(new int[]{2, 2, 4, 4}));
        assertEquals(4, Algorithm.scoresAverage(new int[]{4, 4, 4, 2, 2, 2}));
        assertEquals(4, Algorithm.scoresAverage(new int[]{3, 4, 5, 1, 2, 3}));
        assertEquals(6, Algorithm.scoresAverage(new int[]{5, 6}));
        assertEquals(5, Algorithm.scoresAverage(new int[]{5, 4}));
        assertEquals(5, Algorithm.scoresAverage(new int[]{5, 4, 5, 6, 2, 1, 2, 3}));
    }


    
    /**
     * Tests the wordsCount method.
     */
    @Test
    public void testWordsCount() {
        assertEquals(2, Algorithm.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 1));
        assertEquals(1, Algorithm.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 3));
        assertEquals(0, Algorithm.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 4));
        assertEquals(2, Algorithm.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 1));
        assertEquals(2, Algorithm.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 2));
        assertEquals(1, Algorithm.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 3));
    }
    
    /**
     * Tests the wordsFront method.
     */
    @Test
    public void testWordsFront() {
        assertArrayEquals(new String[]{"a"}, Algorithm.wordsFront(new String[]{"a", "b", "c", "d"}, 1));
        assertArrayEquals(new String[]{"a", "b"}, Algorithm.wordsFront(new String[]{"a", "b", "c", "d"}, 2));
        assertArrayEquals(new String[]{"a", "b", "c"}, Algorithm.wordsFront(new String[]{"a", "b", "c", "d"}, 3));
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, Algorithm.wordsFront(new String[]{"a", "b", "c", "d"}, 4));
        assertArrayEquals(new String[]{"Hi"}, Algorithm.wordsFront(new String[]{"Hi", "There"}, 1));
        assertArrayEquals(new String[]{"Hi", "There"}, Algorithm.wordsFront(new String[]{"Hi", "There"}, 2));
    }
    
    /**
     * Tests the wordsWithoutList method.
     */
    @Test
    public void testWordsWithoutList() {
        List<String> expected1 = Arrays.asList("bb", "ccc");
        assertEquals(expected1, Algorithm.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 1));

        List<String> expected2 = Arrays.asList("a", "bb", "b");
        assertEquals(expected2, Algorithm.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 3));

        List<String> expected3 = Arrays.asList("a", "bb", "b", "ccc");
        assertEquals(expected3, Algorithm.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 4));

        List<String> expected4 = Arrays.asList("xx", "yyy", "yy");
        assertEquals(expected4, Algorithm.wordsWithoutList(new String[]{"xx", "yyy", "x", "yy", "z"}, 1));

        List<String> expected5 = Arrays.asList("yyy", "x", "z");
        assertEquals(expected5, Algorithm.wordsWithoutList(new String[]{"xx", "yyy", "x", "yy", "z"}, 2));
    }

    /**
     * Tests the hasOne method.
     */
    @Test
    public void testHasOne() {
        assertTrue(Algorithm.hasOne(10));
        assertFalse(Algorithm.hasOne(22));
        assertFalse(Algorithm.hasOne(220));
        assertTrue(Algorithm.hasOne(212));
        assertTrue(Algorithm.hasOne(1));
        assertFalse(Algorithm.hasOne(9));
        assertTrue(Algorithm.hasOne(211112));
        assertTrue(Algorithm.hasOne(121121));
        assertFalse(Algorithm.hasOne(222222));
        assertTrue(Algorithm.hasOne(56156));
        assertFalse(Algorithm.hasOne(56556));
    }

    /**
     * Tests the dividesSelf method.
     */
    @Test
    public void testDividesSelf() {
        assertTrue(Algorithm.dividesSelf(128));
        assertTrue(Algorithm.dividesSelf(12));
        assertFalse(Algorithm.dividesSelf(120));
        assertTrue(Algorithm.dividesSelf(122));
        assertFalse(Algorithm.dividesSelf(13));
        assertFalse(Algorithm.dividesSelf(32));
        assertTrue(Algorithm.dividesSelf(22));
        assertFalse(Algorithm.dividesSelf(42));
        assertTrue(Algorithm.dividesSelf(212));
        assertFalse(Algorithm.dividesSelf(213));
        assertTrue(Algorithm.dividesSelf(162));
    }

    /**
     * Tests the copyEvens method.
     */ 
    @Test
    public void testCopyEvens() {
        assertArrayEquals(new int[]{2, 4}, 
            Algorithm.copyEvens(new int[]{3, 2, 4, 5, 8}, 2));

        assertArrayEquals(new int[]{2, 4, 8}, 
            Algorithm.copyEvens(new int[]{3, 2, 4, 5, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4}, 
            Algorithm.copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4, 8}, 
            Algorithm.copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 4));

        assertArrayEquals(new int[]{4}, 
            Algorithm.copyEvens(new int[]{3, 1, 4, 1, 5}, 1));

        assertArrayEquals(new int[]{2}, 
            Algorithm.copyEvens(new int[]{2}, 1));

        assertArrayEquals(new int[]{6, 2}, 
            Algorithm.copyEvens(new int[]{6, 2, 4, 8}, 2));

        assertArrayEquals(new int[]{6, 2, 4}, 
            Algorithm.copyEvens(new int[]{6, 2, 4, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4, 8}, 
            Algorithm.copyEvens(new int[]{6, 2, 4, 8}, 4));

        assertArrayEquals(new int[]{8}, 
            Algorithm.copyEvens(new int[]{1, 8, 4}, 1));

        assertArrayEquals(new int[]{8, 4}, 
            Algorithm.copyEvens(new int[]{1, 8, 4}, 2));

        assertArrayEquals(new int[]{2, 8}, 
            Algorithm.copyEvens(new int[]{2, 8, 4}, 2));
    }
}
