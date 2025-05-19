// File: AlgorithmAPFirstTest.java
// JDK-17: https://developers.redhat.com/products/openjdk/download?sc_cid=701f2000000RWTnAAO
// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * The AlgorithmAPFirstTest class provides JUnit tests for the recursive methods in the AlgorithmAPFirst class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile (Current Test Only): 
 *      `javac -cp junit-1.9.3.jar std03-noah/AlgorithmAPFirst*.java`
 * 3. Compile (All Tests): 
 *      `javac -cp junit-1.9.3.jar std03-noah/*.java`
 * 4. Run & Clean: 
 *      `java -jar junit-1.9.3.jar --class-path std03-noah --scan-classpath; rm -rf std03-noah/*.class`
 */
public class AlgorithmAPFirstTest {
    
    /**
     * < Q01 >
     * Tests the scoresIncreasing method.
     */
    @Test
    public void testScoresIncreasing() {
        assertTrue(AlgorithmAPFirst.scoresIncreasing(new int[]{1, 3, 4}));            // -> True
        assertFalse(AlgorithmAPFirst.scoresIncreasing(new int[]{1, 3, 2}));           // -> False
        assertTrue(AlgorithmAPFirst.scoresIncreasing(new int[]{1, 1, 4}));            // -> True
        assertTrue(AlgorithmAPFirst.scoresIncreasing(new int[]{1, 1, 2, 4, 4, 7}));   // -> True
        assertFalse(AlgorithmAPFirst.scoresIncreasing(new int[]{1, 1, 2, 4, 3, 7}));  // -> False
        assertTrue(AlgorithmAPFirst.scoresIncreasing(new int[]{-5, 4, 11}));          // -> True
    }

    /**
     * < Q02 >
     * Tests the scores100 method.
     */
    @Test
    public void testScores100() {
        assertTrue(AlgorithmAPFirst.scores100(new int[]{1, 100, 100}));           // -> True
        assertFalse(AlgorithmAPFirst.scores100(new int[]{1, 100, 99, 100}));        // -> False
        assertTrue(AlgorithmAPFirst.scores100(new int[]{100, 1, 100, 100}));        // -> True
        assertFalse(AlgorithmAPFirst.scores100(new int[]{100, 1, 100, 1}));         // -> False
        assertFalse(AlgorithmAPFirst.scores100(new int[]{1, 2, 3, 4, 5}));          // -> False
        assertFalse(AlgorithmAPFirst.scores100(new int[]{1, 2, 100, 4, 5}));        // -> False
    }

    /**
     * < Q03 >
     * Tests the scoresClump method.
     */
    @Test
    public void testScoresClump() {
        assertTrue(AlgorithmAPFirst.scoresClump(new int[]{3, 4, 5}));           // -> True
        assertFalse(AlgorithmAPFirst.scoresClump(new int[]{3, 4, 6}));          // -> False
        assertTrue(AlgorithmAPFirst.scoresClump(new int[]{1, 3, 5, 5}));         // -> True
        assertTrue(AlgorithmAPFirst.scoresClump(new int[]{2, 4, 5, 6}));         // -> True
        assertFalse(AlgorithmAPFirst.scoresClump(new int[]{2, 4, 5, 7}));         // -> False
        assertTrue(AlgorithmAPFirst.scoresClump(new int[]{2, 4, 4, 7}));          // -> True
        assertFalse(AlgorithmAPFirst.scoresClump(new int[]{3, 3, 6, 7, 9}));       // -> False
        assertTrue(AlgorithmAPFirst.scoresClump(new int[]{3, 3, 7, 7, 9}));        // -> True
        assertFalse(AlgorithmAPFirst.scoresClump(new int[]{4, 5, 8}));             // -> False
    }

    /**
     * < Q04 >
     * Tests the scoresAverage method.
     */
    @Test
    public void testScoresAverage() {
        assertEquals(4, AlgorithmAPFirst.scoresAverage(new int[]{2, 2, 4, 4}));
        assertEquals(4, AlgorithmAPFirst.scoresAverage(new int[]{4, 4, 4, 2, 2, 2}));
        assertEquals(4, AlgorithmAPFirst.scoresAverage(new int[]{3, 4, 5, 1, 2, 3}));
        assertEquals(6, AlgorithmAPFirst.scoresAverage(new int[]{5, 6}));
        assertEquals(5, AlgorithmAPFirst.scoresAverage(new int[]{5, 4}));
        assertEquals(5, AlgorithmAPFirst.scoresAverage(new int[]{5, 4, 5, 6, 2, 1, 2, 3}));
    }

    /**
     * < Q05 >
     * Tests the wordsCount method.
     */
    @Test
    public void testWordsCount() {
        assertEquals(2, AlgorithmAPFirst.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 1));
        assertEquals(1, AlgorithmAPFirst.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 3));
        assertEquals(0, AlgorithmAPFirst.wordsCount(new String[]{"a", "bb", "b", "ccc"}, 4));
        assertEquals(2, AlgorithmAPFirst.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 1));
        assertEquals(2, AlgorithmAPFirst.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 2));
        assertEquals(1, AlgorithmAPFirst.wordsCount(new String[]{"xx", "yyy", "x", "yy", "z"}, 3));
    }
    
    /**
     * < Q06 >
     * Tests the wordsFront method.
     */
    @Test
    public void testWordsFront() {
        assertArrayEquals(new String[]{"a"}, AlgorithmAPFirst.wordsFront(new String[]{"a", "b", "c", "d"}, 1));
        assertArrayEquals(new String[]{"a", "b"}, AlgorithmAPFirst.wordsFront(new String[]{"a", "b", "c", "d"}, 2));
        assertArrayEquals(new String[]{"a", "b", "c"}, AlgorithmAPFirst.wordsFront(new String[]{"a", "b", "c", "d"}, 3));
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, AlgorithmAPFirst.wordsFront(new String[]{"a", "b", "c", "d"}, 4));
        assertArrayEquals(new String[]{"Hi"}, AlgorithmAPFirst.wordsFront(new String[]{"Hi", "There"}, 1));
        assertArrayEquals(new String[]{"Hi", "There"}, AlgorithmAPFirst.wordsFront(new String[]{"Hi", "There"}, 2));
    }
    
    /**
     * < Q07 >
     * Tests the wordsWithoutList method.
     */
    @Test
    public void testWordsWithoutList() {
        List<String> expected1 = Arrays.asList("bb", "ccc");
        assertEquals(expected1, AlgorithmAPFirst.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 1));

        List<String> expected2 = Arrays.asList("a", "bb", "b");
        assertEquals(expected2, AlgorithmAPFirst.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 3));

        List<String> expected3 = Arrays.asList("a", "bb", "b", "ccc");
        assertEquals(expected3, AlgorithmAPFirst.wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 4));

        List<String> expected4 = Arrays.asList("xx", "yyy", "yy");
        assertEquals(expected4, AlgorithmAPFirst.wordsWithoutList(new String[]{"xx", "yyy", "x", "yy", "z"}, 1));

        List<String> expected5 = Arrays.asList("yyy", "x", "z");
        assertEquals(expected5, AlgorithmAPFirst.wordsWithoutList(new String[]{"xx", "yyy", "x", "yy", "z"}, 2));
    }

    /**
     * < Q08 >
     * Tests the hasOne method.
     */
    @Test
    public void testHasOne() {
        assertTrue(AlgorithmAPFirst.hasOne(10));
        assertFalse(AlgorithmAPFirst.hasOne(22));
        assertFalse(AlgorithmAPFirst.hasOne(220));
        assertTrue(AlgorithmAPFirst.hasOne(212));
        assertTrue(AlgorithmAPFirst.hasOne(1));
        assertFalse(AlgorithmAPFirst.hasOne(9));
        assertTrue(AlgorithmAPFirst.hasOne(211112));
        assertTrue(AlgorithmAPFirst.hasOne(121121));
        assertFalse(AlgorithmAPFirst.hasOne(222222));
        assertTrue(AlgorithmAPFirst.hasOne(56156));
        assertFalse(AlgorithmAPFirst.hasOne(56556));
    }

    /**
     * < Q09 >
     * Tests the dividesSelf method.
     */
    @Test
    public void testDividesSelf() {
        assertTrue(AlgorithmAPFirst.dividesSelf(128));
        assertTrue(AlgorithmAPFirst.dividesSelf(12));
        assertFalse(AlgorithmAPFirst.dividesSelf(120));
        assertTrue(AlgorithmAPFirst.dividesSelf(122));
        assertFalse(AlgorithmAPFirst.dividesSelf(13));
        assertFalse(AlgorithmAPFirst.dividesSelf(32));
        assertTrue(AlgorithmAPFirst.dividesSelf(22));
        assertFalse(AlgorithmAPFirst.dividesSelf(42));
        assertTrue(AlgorithmAPFirst.dividesSelf(212));
        assertFalse(AlgorithmAPFirst.dividesSelf(213));
        assertTrue(AlgorithmAPFirst.dividesSelf(162));
    }

    /**
     * < Q10 >
     * Tests the copyEvens method.
     */ 
    @Test
    public void testCopyEvens() {
        assertArrayEquals(new int[]{2, 4}, 
            AlgorithmAPFirst.copyEvens(new int[]{3, 2, 4, 5, 8}, 2));

        assertArrayEquals(new int[]{2, 4, 8}, 
            AlgorithmAPFirst.copyEvens(new int[]{3, 2, 4, 5, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4}, 
            AlgorithmAPFirst.copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4, 8}, 
            AlgorithmAPFirst.copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 4));

        assertArrayEquals(new int[]{4}, 
            AlgorithmAPFirst.copyEvens(new int[]{3, 1, 4, 1, 5}, 1));

        assertArrayEquals(new int[]{2}, 
            AlgorithmAPFirst.copyEvens(new int[]{2}, 1));

        assertArrayEquals(new int[]{6, 2}, 
            AlgorithmAPFirst.copyEvens(new int[]{6, 2, 4, 8}, 2));

        assertArrayEquals(new int[]{6, 2, 4}, 
            AlgorithmAPFirst.copyEvens(new int[]{6, 2, 4, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4, 8}, 
            AlgorithmAPFirst.copyEvens(new int[]{6, 2, 4, 8}, 4));

        assertArrayEquals(new int[]{8}, 
            AlgorithmAPFirst.copyEvens(new int[]{1, 8, 4}, 1));

        assertArrayEquals(new int[]{8, 4}, 
            AlgorithmAPFirst.copyEvens(new int[]{1, 8, 4}, 2));

        assertArrayEquals(new int[]{2, 8}, 
            AlgorithmAPFirst.copyEvens(new int[]{2, 8, 4}, 2));
    }
}
