// File: AlgorithmAPXXXtraTest.java
// JDK-17: https://developers.redhat.com/products/openjdk/download?sc_cid=701f2000000RWTnAAO
// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * The AlgorithmAPXXXtraTest class provides JUnit tests for the recursive methods in the AlgorithmAPXXXtra class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile (Current Test Only): 
 *      ```
 *      javac -cp junit-1.9.3.jar _instructor/AlgorithmAPXXXtra*.java
 *      ```
 * 3. Compile (All Tests): 
 *      `javac -cp junit-1.9.3.jar _instructor/*.java`
 * 4. Run & Clean: 
 *      ```
 *      java -jar junit-1.9.3.jar --class-path _instructor --scan-classpath; rm -rf _instructor/*.class
 *      ```
 */
public class AlgorithmAPXXXtraTest {
    /**
     * < Q46 >
     * Tests the repeatFront method.
     */
    @Test
    public void testRepeatFront() {
        assertEquals("ChocChoChC", AlgorithmAPXXXtra.repeatFront("Chocolate", 4));
        assertEquals("ChoChC",     AlgorithmAPXXXtra.repeatFront("Chocolate", 3));
        assertEquals("IcI",        AlgorithmAPXXXtra.repeatFront("Ice Cream", 2));
        assertEquals("I",          AlgorithmAPXXXtra.repeatFront("Ice Cream", 1));
        assertEquals("",           AlgorithmAPXXXtra.repeatFront("Ice Cream", 0));
        assertEquals("xyzxyx",     AlgorithmAPXXXtra.repeatFront("xyz", 3));
        assertEquals("",           AlgorithmAPXXXtra.repeatFront("", 0));
        assertEquals("JavaJavJaJ", AlgorithmAPXXXtra.repeatFront("Java", 4));
        assertEquals("J",          AlgorithmAPXXXtra.repeatFront("Java", 1));
    }


    
    /**
     * < Q47 >
     * Tests the fizzArray method.
     */
    @Test
    public void testFizzArray() {
        assertArrayEquals(new int[]{0, 1, 2, 3},                    AlgorithmAPXXXtra.fizzArray(4));
        assertArrayEquals(new int[]{0},                             AlgorithmAPXXXtra.fizzArray(1));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},  AlgorithmAPXXXtra.fizzArray(10));
        assertArrayEquals(new int[]{},                              AlgorithmAPXXXtra.fizzArray(0));
        assertArrayEquals(new int[]{0, 1},                          AlgorithmAPXXXtra.fizzArray(2));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6},           AlgorithmAPXXXtra.fizzArray(7));
    }

    
    /**
     * < Q48 >
     * Tests the only14 method.
     */
    @Test
    public void testOnly14() {
        assertTrue(AlgorithmAPXXXtra.only14(new int[]{1,4,1,4}));
        assertFalse(AlgorithmAPXXXtra.only14(new int[]{1,4,2,4}));
        assertTrue(AlgorithmAPXXXtra.only14(new int[]{1,1}));
        assertTrue(AlgorithmAPXXXtra.only14(new int[]{4,1}));
        assertFalse(AlgorithmAPXXXtra.only14(new int[]{2}));
        assertTrue(AlgorithmAPXXXtra.only14(new int[]{}));
        assertFalse(AlgorithmAPXXXtra.only14(new int[]{1,4,1,3}));
        assertFalse(AlgorithmAPXXXtra.only14(new int[]{3,1,3}));
        assertTrue(AlgorithmAPXXXtra.only14(new int[]{1}));
        assertTrue(AlgorithmAPXXXtra.only14(new int[]{4}));
        assertFalse(AlgorithmAPXXXtra.only14(new int[]{3,4}));
        assertFalse(AlgorithmAPXXXtra.only14(new int[]{1,3,4}));
        assertTrue(AlgorithmAPXXXtra.only14(new int[]{1,1,1}));
        assertFalse(AlgorithmAPXXXtra.only14(new int[]{1,1,1,5}));
        assertTrue(AlgorithmAPXXXtra.only14(new int[]{4,1,4,1}));
    }

    
    /**
     * < Q49 >
     * Tests the fizzArray2 method.
     */
    @Test
    public void testFizzArray2() {
        assertArrayEquals(new String[]{"0","1","2","3"},
            AlgorithmAPXXXtra.fizzArray2(4));
        assertArrayEquals(new String[]{"0","1","2","3","4","5","6","7","8","9"},
            AlgorithmAPXXXtra.fizzArray2(10));
        assertArrayEquals(new String[]{"0","1"},
            AlgorithmAPXXXtra.fizzArray2(2));
        assertArrayEquals(new String[]{"0"},
            AlgorithmAPXXXtra.fizzArray2(1));
        assertArrayEquals(new String[]{},
            AlgorithmAPXXXtra.fizzArray2(0));
        assertArrayEquals(new String[]{"0","1","2","3","4","5","6"},
            AlgorithmAPXXXtra.fizzArray2(7));
        assertArrayEquals(new String[]{"0","1","2","3","4","5","6","7","8"},
            AlgorithmAPXXXtra.fizzArray2(9));
        assertArrayEquals(new String[]{"0","1","2","3","4","5","6","7","8","9","10"},
            AlgorithmAPXXXtra.fizzArray2(11));
    }

    
    /**
     * < Q50 >
     * Tests the noTeenSum method.
     */
    @Test
    public void testNoTeenSum() {
        assertEquals(6,  AlgorithmAPXXXtra.noTeenSum(1,  2,  3));
        assertEquals(3,  AlgorithmAPXXXtra.noTeenSum(2, 13,  1));
        assertEquals(3,  AlgorithmAPXXXtra.noTeenSum(2,  1, 14));
        assertEquals(18, AlgorithmAPXXXtra.noTeenSum(2,  1, 15));
        assertEquals(19, AlgorithmAPXXXtra.noTeenSum(2,  1, 16));
        assertEquals(3,  AlgorithmAPXXXtra.noTeenSum(2,  1, 17));
        assertEquals(3,  AlgorithmAPXXXtra.noTeenSum(17, 1,  2));
        assertEquals(19, AlgorithmAPXXXtra.noTeenSum(2, 15,  2));
        assertEquals(16, AlgorithmAPXXXtra.noTeenSum(16,17, 18));
        assertEquals(0,  AlgorithmAPXXXtra.noTeenSum(17,18, 19));
        assertEquals(32, AlgorithmAPXXXtra.noTeenSum(15,16,  1));
        assertEquals(30, AlgorithmAPXXXtra.noTeenSum(15,15, 19));
        assertEquals(31, AlgorithmAPXXXtra.noTeenSum(15,19, 16));
        assertEquals(5,  AlgorithmAPXXXtra.noTeenSum(5, 17, 18));
        assertEquals(16, AlgorithmAPXXXtra.noTeenSum(17,18, 16));
        assertEquals(0,  AlgorithmAPXXXtra.noTeenSum(17,19, 18));
    }
}