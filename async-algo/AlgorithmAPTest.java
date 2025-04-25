// File: AlgorithmAPTest.java
// JDK-17: https://developers.redhat.com/products/openjdk/download?sc_cid=701f2000000RWTnAAO
// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * The AlgorithmAPTest class provides JUnit tests for the recursive methods in the AlgorithmAP class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile (Current Test Only): 
 *      `javac -cp junit-1.9.3.jar async-algo/AlgorithmAP*.java`
 * 3. Compile (All Tests): 
 *      `javac -cp junit-1.9.3.jar async-algo/*.java`
 * 4. Run & Clean: 
 *      `java -jar junit-1.9.3.jar --class-path async-algo --scan-classpath; rm -rf async-algo/*.class`
 */
public class AlgorithmAPTest {
    
    /**
     * Tests the scoresIncreasing method.
     */
    @Test
    public void testScoresIncreasing() {
        assertTrue(AlgorithmAP.scoresIncreasing(new int[]{1, 3, 4}));            // → True
        assertFalse(AlgorithmAP.scoresIncreasing(new int[]{1, 3, 2}));           // → False
        assertTrue(AlgorithmAP.scoresIncreasing(new int[]{1, 1, 4}));            // → True
        assertTrue(AlgorithmAP.scoresIncreasing(new int[]{1, 1, 2, 4, 4, 7}));   // → True
        assertFalse(AlgorithmAP.scoresIncreasing(new int[]{1, 1, 2, 4, 3, 7}));  // → False
        assertTrue(AlgorithmAP.scoresIncreasing(new int[]{-5, 4, 11}));          // → True
    }

    /**
     * Tests the scores100 method.
     */
    @Test
    public void testScores100() {
        assertTrue(AlgorithmAP.scores100(new int[]{1, 100, 100}));           // → True
        assertFalse(AlgorithmAP.scores100(new int[]{1, 100, 99, 100}));        // → False
        assertTrue(AlgorithmAP.scores100(new int[]{100, 1, 100, 100}));        // → True
        assertFalse(AlgorithmAP.scores100(new int[]{100, 1, 100, 1}));         // → False
        assertFalse(AlgorithmAP.scores100(new int[]{1, 2, 3, 4, 5}));          // → False
        assertFalse(AlgorithmAP.scores100(new int[]{1, 2, 100, 4, 5}));        // → False
    }

    /**
     * Tests the scoresClump method.
     */
    @Test
    public void testScoresClump() {
        assertTrue(AlgorithmAP.scoresClump(new int[]{3, 4, 5}));           // → True
        assertFalse(AlgorithmAP.scoresClump(new int[]{3, 4, 6}));          // → False
        assertTrue(AlgorithmAP.scoresClump(new int[]{1, 3, 5, 5}));         // → True
        assertTrue(AlgorithmAP.scoresClump(new int[]{2, 4, 5, 6}));         // → True
        assertFalse(AlgorithmAP.scoresClump(new int[]{2, 4, 5, 7}));         // → False
        assertTrue(AlgorithmAP.scoresClump(new int[]{2, 4, 4, 7}));          // → True
        assertFalse(AlgorithmAP.scoresClump(new int[]{3, 3, 6, 7, 9}));       // → False
        assertTrue(AlgorithmAP.scoresClump(new int[]{3, 3, 7, 7, 9}));        // → True
        assertFalse(AlgorithmAP.scoresClump(new int[]{4, 5, 8}));             // → False
    }

    /**
     * Tests the scoresAverage method.
     */
    @Test
    public void testScoresAverage() {
        assertEquals(4, AlgorithmAP.scoresAverage(new int[]{2, 2, 4, 4}));
        assertEquals(4, AlgorithmAP.scoresAverage(new int[]{4, 4, 4, 2, 2, 2}));
        assertEquals(4, AlgorithmAP.scoresAverage(new int[]{3, 4, 5, 1, 2, 3}));
        assertEquals(6, AlgorithmAP.scoresAverage(new int[]{5, 6}));
        assertEquals(5, AlgorithmAP.scoresAverage(new int[]{5, 4}));
        assertEquals(5, AlgorithmAP.scoresAverage(new int[]{5, 4, 5, 6, 2, 1, 2, 3}));
    }


    
    /**
     * Tests the wordsCount method.
     */
    @Test
    public void testWordsCount() {
        assertEquals(2, AlgorithmAP.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 1));
        assertEquals(1, AlgorithmAP.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 3));
        assertEquals(0, AlgorithmAP.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 4));
        assertEquals(2, AlgorithmAP.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 1));
        assertEquals(2, AlgorithmAP.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 2));
        assertEquals(1, AlgorithmAP.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 3));
    }
    
    /**
     * Tests the wordsFront method.
     */
    @Test
    public void testWordsFront() {
        assertArrayEquals(new String[]{"a"}, AlgorithmAP.wordsFront(new String[]{"a", "b", "c", "d"}, 1));
        assertArrayEquals(new String[]{"a", "b"}, AlgorithmAP.wordsFront(new String[]{"a", "b", "c", "d"}, 2));
        assertArrayEquals(new String[]{"a", "b", "c"}, AlgorithmAP.wordsFront(new String[]{"a", "b", "c", "d"}, 3));
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, AlgorithmAP.wordsFront(new String[]{"a", "b", "c", "d"}, 4));
        assertArrayEquals(new String[]{"Hi"}, AlgorithmAP.wordsFront(new String[]{"Hi", "There"}, 1));
        assertArrayEquals(new String[]{"Hi", "There"}, AlgorithmAP.wordsFront(new String[]{"Hi", "There"}, 2));
    }
    
    /**
     * Tests the wordsWithoutList method.
     */
    @Test
    public void testWordsWithoutList() {
        List<String> expected1 = Arrays.asList("bb", "ccc");
        assertEquals(expected1, AlgorithmAP.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 1));

        List<String> expected2 = Arrays.asList("a", "bb", "b");
        assertEquals(expected2, AlgorithmAP.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 3));

        List<String> expected3 = Arrays.asList("a", "bb", "b", "ccc");
        assertEquals(expected3, AlgorithmAP.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 4));

        List<String> expected4 = Arrays.asList("xx", "yyy", "yy");
        assertEquals(expected4, AlgorithmAP.wordsWithoutList(new String[]{"xx", "yyy", "x", "yy", "z"}, 1));

        List<String> expected5 = Arrays.asList("yyy", "x", "z");
        assertEquals(expected5, AlgorithmAP.wordsWithoutList(new String[]{"xx", "yyy", "x", "yy", "z"}, 2));
    }

    /**
     * Tests the hasOne method.
     */
    @Test
    public void testHasOne() {
        assertTrue(AlgorithmAP.hasOne(10));
        assertFalse(AlgorithmAP.hasOne(22));
        assertFalse(AlgorithmAP.hasOne(220));
        assertTrue(AlgorithmAP.hasOne(212));
        assertTrue(AlgorithmAP.hasOne(1));
        assertFalse(AlgorithmAP.hasOne(9));
        assertTrue(AlgorithmAP.hasOne(211112));
        assertTrue(AlgorithmAP.hasOne(121121));
        assertFalse(AlgorithmAP.hasOne(222222));
        assertTrue(AlgorithmAP.hasOne(56156));
        assertFalse(AlgorithmAP.hasOne(56556));
    }

    /**
     * Tests the dividesSelf method.
     */
    @Test
    public void testDividesSelf() {
        assertTrue(AlgorithmAP.dividesSelf(128));
        assertTrue(AlgorithmAP.dividesSelf(12));
        assertFalse(AlgorithmAP.dividesSelf(120));
        assertTrue(AlgorithmAP.dividesSelf(122));
        assertFalse(AlgorithmAP.dividesSelf(13));
        assertFalse(AlgorithmAP.dividesSelf(32));
        assertTrue(AlgorithmAP.dividesSelf(22));
        assertFalse(AlgorithmAP.dividesSelf(42));
        assertTrue(AlgorithmAP.dividesSelf(212));
        assertFalse(AlgorithmAP.dividesSelf(213));
        assertTrue(AlgorithmAP.dividesSelf(162));
    }

    /**
     * Tests the copyEvens method.
     */ 
    @Test
    public void testCopyEvens() {
        assertArrayEquals(new int[]{2, 4}, 
            AlgorithmAP.copyEvens(new int[]{3, 2, 4, 5, 8}, 2));

        assertArrayEquals(new int[]{2, 4, 8}, 
            AlgorithmAP.copyEvens(new int[]{3, 2, 4, 5, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4}, 
            AlgorithmAP.copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4, 8}, 
            AlgorithmAP.copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 4));

        assertArrayEquals(new int[]{4}, 
            AlgorithmAP.copyEvens(new int[]{3, 1, 4, 1, 5}, 1));

        assertArrayEquals(new int[]{2}, 
            AlgorithmAP.copyEvens(new int[]{2}, 1));

        assertArrayEquals(new int[]{6, 2}, 
            AlgorithmAP.copyEvens(new int[]{6, 2, 4, 8}, 2));

        assertArrayEquals(new int[]{6, 2, 4}, 
            AlgorithmAP.copyEvens(new int[]{6, 2, 4, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4, 8}, 
            AlgorithmAP.copyEvens(new int[]{6, 2, 4, 8}, 4));

        assertArrayEquals(new int[]{8}, 
            AlgorithmAP.copyEvens(new int[]{1, 8, 4}, 1));

        assertArrayEquals(new int[]{8, 4}, 
            AlgorithmAP.copyEvens(new int[]{1, 8, 4}, 2));

        assertArrayEquals(new int[]{2, 8}, 
            AlgorithmAP.copyEvens(new int[]{2, 8, 4}, 2));
    }
}
