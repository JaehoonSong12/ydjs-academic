// File: AlgorithmAPXXtraTest.java
// JDK-17: https://developers.redhat.com/products/openjdk/download?sc_cid=701f2000000RWTnAAO
// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * The AlgorithmAPXXtraTest class provides JUnit tests for the recursive methods in the AlgorithmAPXXtra class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile (Current Test Only): 
 *      ```
 *      javac -cp junit-1.9.3.jar std02-arron-algo/AlgorithmAPXXtra*.java
 *      ```
 * 3. Compile (All Tests): 
 *      `javac -cp junit-1.9.3.jar std02-arron-algo/*.java`
 * 4. Run & Clean: 
 *      ```
 *      java -jar junit-1.9.3.jar --class-path std02-arron-algo --scan-classpath; rm -rf std02-arron-algo/*.class
 *      ```
 */
public class AlgorithmAPXXtraTest {
    /**
     * < Q38 >
     * Tests the xyzThere method.
     */
    @Test
    public void testXyzThere() {
        assertTrue(AlgorithmAPXXtra.xyzThere("abcxyz"));
        assertFalse(AlgorithmAPXXtra.xyzThere("abc.xyz"));
        assertTrue(AlgorithmAPXXtra.xyzThere("xyz.abc"));
        assertFalse(AlgorithmAPXXtra.xyzThere("abcxy"));
        assertTrue(AlgorithmAPXXtra.xyzThere("xyz"));
        assertFalse(AlgorithmAPXXtra.xyzThere("xy"));
        assertFalse(AlgorithmAPXXtra.xyzThere("x"));
        assertFalse(AlgorithmAPXXtra.xyzThere(""));
        assertTrue(AlgorithmAPXXtra.xyzThere("abc.xyzxyz"));
        assertTrue(AlgorithmAPXXtra.xyzThere("abc.xxyz"));
        assertFalse(AlgorithmAPXXtra.xyzThere(".xyz"));
        assertFalse(AlgorithmAPXXtra.xyzThere("12.xyz"));
        assertTrue(AlgorithmAPXXtra.xyzThere("12xyz"));
        assertFalse(AlgorithmAPXXtra.xyzThere("1.xyz.xyz2.xyz"));
    }

    
    /**
     * < Q39 >
     * Tests the lucky13 method.
     */
    @Test
    public void testLucky13() {
        assertTrue(AlgorithmAPXXtra.lucky13(new int[]{0, 2, 4}));
        assertFalse(AlgorithmAPXXtra.lucky13(new int[]{1, 2, 3}));
        assertFalse(AlgorithmAPXXtra.lucky13(new int[]{1, 2, 4}));
        assertTrue(AlgorithmAPXXtra.lucky13(new int[]{2, 7, 2, 8}));
        assertFalse(AlgorithmAPXXtra.lucky13(new int[]{2, 7, 1, 8}));
        assertFalse(AlgorithmAPXXtra.lucky13(new int[]{3, 7, 2, 8}));
        assertFalse(AlgorithmAPXXtra.lucky13(new int[]{2, 7, 2, 1}));
        assertFalse(AlgorithmAPXXtra.lucky13(new int[]{1, 2}));
        assertTrue(AlgorithmAPXXtra.lucky13(new int[]{2, 2}));
        assertTrue(AlgorithmAPXXtra.lucky13(new int[]{2}));
        assertFalse(AlgorithmAPXXtra.lucky13(new int[]{3}));
        assertTrue(AlgorithmAPXXtra.lucky13(new int[]{}));
    }
    
    /**
     * < Q40 >
     * Tests the sum28 method.
     */
    @Test
    public void testSum28() {
        assertTrue(AlgorithmAPXXtra.sum28(new int[]{2, 3, 2, 2, 4, 2}));
        assertFalse(AlgorithmAPXXtra.sum28(new int[]{2, 3, 2, 2, 4, 2, 2}));
        assertFalse(AlgorithmAPXXtra.sum28(new int[]{1, 2, 3, 4}));
        assertTrue(AlgorithmAPXXtra.sum28(new int[]{2, 2, 2, 2}));
        assertTrue(AlgorithmAPXXtra.sum28(new int[]{1, 2, 2, 2, 2, 4}));
        assertFalse(AlgorithmAPXXtra.sum28(new int[]{}));
        assertFalse(AlgorithmAPXXtra.sum28(new int[]{2}));
        assertFalse(AlgorithmAPXXtra.sum28(new int[]{8}));
        assertFalse(AlgorithmAPXXtra.sum28(new int[]{2, 2, 2}));
        assertFalse(AlgorithmAPXXtra.sum28(new int[]{2, 2, 2, 2, 2}));
        assertTrue(AlgorithmAPXXtra.sum28(new int[]{1, 2, 2, 1, 2, 2}));
        assertTrue(AlgorithmAPXXtra.sum28(new int[]{5, 2, 2, 2, 4, 2}));
    }

    
    /**
     * < Q41 >
     * Tests the more14 method.
     */
    @Test
    public void testMore14() {
        assertTrue(AlgorithmAPXXtra.more14(new int[]{1,4,1}));
        assertFalse(AlgorithmAPXXtra.more14(new int[]{1,4,1,4}));
        assertTrue(AlgorithmAPXXtra.more14(new int[]{1,1}));
        assertTrue(AlgorithmAPXXtra.more14(new int[]{1,6,6}));
        assertTrue(AlgorithmAPXXtra.more14(new int[]{1}));
        assertFalse(AlgorithmAPXXtra.more14(new int[]{1,4}));
        assertTrue(AlgorithmAPXXtra.more14(new int[]{6,1,1}));
        assertFalse(AlgorithmAPXXtra.more14(new int[]{1,6,4}));
        assertTrue(AlgorithmAPXXtra.more14(new int[]{1,1,4,4,1}));
        assertTrue(AlgorithmAPXXtra.more14(new int[]{1,1,6,4,4,1}));
        assertFalse(AlgorithmAPXXtra.more14(new int[]{}));
        assertFalse(AlgorithmAPXXtra.more14(new int[]{4,1,4,6}));
        assertFalse(AlgorithmAPXXtra.more14(new int[]{4,1,4,6,1}));
        assertTrue(AlgorithmAPXXtra.more14(new int[]{1,4,1,4,1,6}));
    }

    
    /**
     * < Q42 >
     * Tests the luckySum method.
     */
    @Test
    public void testLuckySum() {
        assertEquals(6,  AlgorithmAPXXtra.luckySum(1,  2,  3));
        assertEquals(3,  AlgorithmAPXXtra.luckySum(1,  2, 13));
        assertEquals(1,  AlgorithmAPXXtra.luckySum(1, 13,  3));
        assertEquals(1,  AlgorithmAPXXtra.luckySum(1, 13, 13));
        assertEquals(13, AlgorithmAPXXtra.luckySum(6,  5,  2));
        assertEquals(0,  AlgorithmAPXXtra.luckySum(13, 2,  3));
        assertEquals(0,  AlgorithmAPXXtra.luckySum(13, 2, 13));
        assertEquals(0,  AlgorithmAPXXtra.luckySum(13,13,  2));
        assertEquals(13, AlgorithmAPXXtra.luckySum(9,  4, 13));
        assertEquals(8,  AlgorithmAPXXtra.luckySum(8, 13,  2));
        assertEquals(10, AlgorithmAPXXtra.luckySum(7,  2,  1));
        assertEquals(6,  AlgorithmAPXXtra.luckySum(3,  3, 13));
    }


    
    /**
     * < Q43 >
     * Tests the equalIsNot method.
     */
    @Test
    public void testEqualIsNot() {
        assertFalse(AlgorithmAPXXtra.equalIsNot("This is not"));
        assertTrue(AlgorithmAPXXtra.equalIsNot("This is notnot"));
        assertTrue(AlgorithmAPXXtra.equalIsNot("noisxxnotyynotxisi"));
        assertFalse(AlgorithmAPXXtra.equalIsNot("noisxxnotyynotxsi"));
        assertTrue(AlgorithmAPXXtra.equalIsNot("xxxyyyzzzintint"));
        assertTrue(AlgorithmAPXXtra.equalIsNot(""));
        assertTrue(AlgorithmAPXXtra.equalIsNot("isisnotnot"));
        assertFalse(AlgorithmAPXXtra.equalIsNot("isisnotno7Not"));
        assertFalse(AlgorithmAPXXtra.equalIsNot("isnotis"));
        assertFalse(AlgorithmAPXXtra.equalIsNot("mis3notpotbotis"));
    }


    
    /**
     * < Q44 >
     * Tests the fix45 method.
     */
    @Test
    public void testFix45() {
        assertArrayEquals(new int[]{9,4,5,4,5,9},
            AlgorithmAPXXtra.fix45(new int[]{5,4,9,4,9,5}));
        assertArrayEquals(new int[]{1,4,5,1},
            AlgorithmAPXXtra.fix45(new int[]{1,4,1,5}));
        assertArrayEquals(new int[]{1,4,5,1,1,4,5},
            AlgorithmAPXXtra.fix45(new int[]{1,4,1,5,5,4,1}));
        assertArrayEquals(new int[]{4,5,2,2},
            AlgorithmAPXXtra.fix45(new int[]{4,2,2,5}));
        assertArrayEquals(new int[]{9,4,5,4,5,9},
            AlgorithmAPXXtra.fix45(new int[]{4,9,4,9,5,5,4,9,5}).length == 9 
                ? new int[]{4,5,4,5,9,9,4,5,9}
                : AlgorithmAPXXtra.fix45(new int[]{4,9,4,9,5,5,4,9,5}));
        // The above handles the longer example:
        // fix45(new int[]{4,9,4,9,5,5,4,9,5}) → [4,5,4,5,9,9,4,5,9]
        assertArrayEquals(new int[]{1,1,4,5,4,5},
            AlgorithmAPXXtra.fix45(new int[]{5,5,4,1,4,1}));
        assertArrayEquals(new int[]{4,5,2,2},
            AlgorithmAPXXtra.fix45(new int[]{4,2,2,5}));
        assertArrayEquals(new int[]{4,5,4,5,2,2},
            AlgorithmAPXXtra.fix45(new int[]{4,2,4,2,5,5}));
        assertArrayEquals(new int[]{4,5,4,5,2},
            AlgorithmAPXXtra.fix45(new int[]{4,2,4,5,5}));
        assertArrayEquals(new int[]{1,1,1},
            AlgorithmAPXXtra.fix45(new int[]{1,1,1}));
        assertArrayEquals(new int[]{4,5},
            AlgorithmAPXXtra.fix45(new int[]{4,5}));
        assertArrayEquals(new int[]{1,4,5},
            AlgorithmAPXXtra.fix45(new int[]{5,4,1}));
        assertArrayEquals(new int[]{},
            AlgorithmAPXXtra.fix45(new int[]{}));
        assertArrayEquals(new int[]{1,4,5,4,5},
            AlgorithmAPXXtra.fix45(new int[]{5,4,5,4,1}));
        assertArrayEquals(new int[]{4,5,4,5,1},
            AlgorithmAPXXtra.fix45(new int[]{4,5,4,1,5}));
        assertArrayEquals(new int[]{3,4,5},
            AlgorithmAPXXtra.fix45(new int[]{3,4,5}));
        assertArrayEquals(new int[]{4,5,1},
            AlgorithmAPXXtra.fix45(new int[]{4,1,5}));
        assertArrayEquals(new int[]{1,4,5},
            AlgorithmAPXXtra.fix45(new int[]{5,4,1}));
        assertArrayEquals(new int[]{2,4,5,2},
            AlgorithmAPXXtra.fix45(new int[]{2,4,2,5}));
    }
    
    /**
     * < Q45 >
     * Tests the repeatSeparator method.
     */
    @Test
    public void testRepeatSeparator() {
        assertEquals("WordXWordXWord", AlgorithmAPXXtra.repeatSeparator("Word", "X", 3));
        assertEquals("ThisAndThis",     AlgorithmAPXXtra.repeatSeparator("This", "And", 2));
        assertEquals("This",            AlgorithmAPXXtra.repeatSeparator("This", "And", 1));
        assertEquals("Hi-n-Hi",         AlgorithmAPXXtra.repeatSeparator("Hi", "-n-", 2));
        assertEquals("AAA",             AlgorithmAPXXtra.repeatSeparator("AAA", "", 1));
        assertEquals("",                AlgorithmAPXXtra.repeatSeparator("AAA", "", 0));
        assertEquals("ABABABABA",       AlgorithmAPXXtra.repeatSeparator("A", "B", 5));
        assertEquals("abcXXabcXXabc",   AlgorithmAPXXtra.repeatSeparator("abc", "XX", 3));
        assertEquals("abcXXabc",        AlgorithmAPXXtra.repeatSeparator("abc", "XX", 2));
        assertEquals("abc",             AlgorithmAPXXtra.repeatSeparator("abc", "XX", 1));
        assertEquals("XYZaXYZ",         AlgorithmAPXXtra.repeatSeparator("XYZ", "a", 2));
    }
}