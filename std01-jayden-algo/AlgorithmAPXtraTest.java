// File: AlgorithmAPXtraTest.java
// JDK-17: https://developers.redhat.com/products/openjdk/download?sc_cid=701f2000000RWTnAAO
// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * The AlgorithmAPXtraTest class provides JUnit tests for the recursive methods in the AlgorithmAPXtra class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile (Current Test Only): 
 *  ```
 *  javac -cp ../junit-1.9.3.jar AlgorithmAPXtra*.java && kotlinc AlgorithmAPXtra.kt -d .
 *  ```
 * 3. Run & Clean: 
 *  ```
 *  java -jar ../junit-1.9.3.jar --class-path ".:$KOTLIN_HOME/lib/kotlin-stdlib.jar" --scan-classpath
 *  ```
 * 4. Clean: 
 *  ```
 *  rm -rf *.class META-INF/
 *  ```
 */
public class AlgorithmAPXtraTest {
    

    /**
     * < Q27 >
     * Tests the makeBricks method.
     */
    @Test
    public void testMakeBricks() {
        assertTrue(AlgorithmAPXtra.makeBricks(3, 1, 8));
        assertFalse(AlgorithmAPXtra.makeBricks(3, 1, 9));
        assertTrue(AlgorithmAPXtra.makeBricks(3, 2, 10));
        assertTrue(AlgorithmAPXtra.makeBricks(3, 2, 8));
        assertFalse(AlgorithmAPXtra.makeBricks(3, 2, 9));
        assertTrue(AlgorithmAPXtra.makeBricks(6, 1, 11));
        assertFalse(AlgorithmAPXtra.makeBricks(6, 0, 11));
        assertTrue(AlgorithmAPXtra.makeBricks(1, 4, 11));
        assertTrue(AlgorithmAPXtra.makeBricks(0, 3, 10));
        assertFalse(AlgorithmAPXtra.makeBricks(1, 4, 12));
        assertTrue(AlgorithmAPXtra.makeBricks(3, 1, 7));
        assertFalse(AlgorithmAPXtra.makeBricks(1, 1, 7));
        assertTrue(AlgorithmAPXtra.makeBricks(2, 1, 7));
        assertTrue(AlgorithmAPXtra.makeBricks(7, 1, 11));
        assertTrue(AlgorithmAPXtra.makeBricks(7, 1, 8));
        assertFalse(AlgorithmAPXtra.makeBricks(7, 1, 13));
        assertTrue(AlgorithmAPXtra.makeBricks(43, 1, 46));
        assertFalse(AlgorithmAPXtra.makeBricks(40, 1, 46));
        assertTrue(AlgorithmAPXtra.makeBricks(40, 2, 47));
        assertTrue(AlgorithmAPXtra.makeBricks(40, 2, 50));
        assertFalse(AlgorithmAPXtra.makeBricks(40, 2, 52));
        assertFalse(AlgorithmAPXtra.makeBricks(22, 2, 33));
        assertTrue(AlgorithmAPXtra.makeBricks(0, 2, 10));
        assertTrue(AlgorithmAPXtra.makeBricks(1000000, 1000, 1000100));
        assertFalse(AlgorithmAPXtra.makeBricks(2, 1000000, 100003));
        assertTrue(AlgorithmAPXtra.makeBricks(20, 0, 19));
        assertFalse(AlgorithmAPXtra.makeBricks(20, 0, 21));
        assertFalse(AlgorithmAPXtra.makeBricks(20, 4, 51));
        assertTrue(AlgorithmAPXtra.makeBricks(20, 4, 39));
    }
    

    /**
     * < Q28 >
     * Tests the countYZ method.
     */
    @Test
    public void testCountYZ() {
        assertEquals(2, AlgorithmAPXtra.countYZ("fez day"));
        assertEquals(2, AlgorithmAPXtra.countYZ("day fez"));
        assertEquals(2, AlgorithmAPXtra.countYZ("day fyyyz"));
        assertEquals(1, AlgorithmAPXtra.countYZ("day yak"));
        assertEquals(1, AlgorithmAPXtra.countYZ("day:yak"));
        assertEquals(2, AlgorithmAPXtra.countYZ("!!day--yaz!!"));
        assertEquals(0, AlgorithmAPXtra.countYZ("yak zak"));
        assertEquals(2, AlgorithmAPXtra.countYZ("DAY abc XYZ"));
        assertEquals(3, AlgorithmAPXtra.countYZ("aaz yyz my"));
        assertEquals(2, AlgorithmAPXtra.countYZ("y2bz"));
        assertEquals(0, AlgorithmAPXtra.countYZ("zxyx"));
    }

    /**
     * < Q29 >
     * Tests the maxSpan method.
     */
    @Test
    public void testMaxSpan() {
        assertEquals(4, AlgorithmAPXtra.maxSpan(new int[]{1, 2, 1, 1, 3}));
        assertEquals(6, AlgorithmAPXtra.maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}));
        assertEquals(6, AlgorithmAPXtra.maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}));
        assertEquals(3, AlgorithmAPXtra.maxSpan(new int[]{3, 3, 3}));
        assertEquals(3, AlgorithmAPXtra.maxSpan(new int[]{3, 9, 3}));
        assertEquals(2, AlgorithmAPXtra.maxSpan(new int[]{3, 9, 9}));
        assertEquals(1, AlgorithmAPXtra.maxSpan(new int[]{3, 9}));
        assertEquals(2, AlgorithmAPXtra.maxSpan(new int[]{3, 3}));
        assertEquals(0, AlgorithmAPXtra.maxSpan(new int[]{}));
        assertEquals(1, AlgorithmAPXtra.maxSpan(new int[]{1}));
    }











    
    /**
     * < Q30 >
     * Tests the catDog method.
     */
    @Test
    public void testCatDog() {
        assertTrue(AlgorithmAPXtra.catDog("catdog"));
        assertFalse(AlgorithmAPXtra.catDog("catcat"));
        assertTrue(AlgorithmAPXtra.catDog("1cat1cadodog"));
        assertFalse(AlgorithmAPXtra.catDog("catxxdogxxxdog"));
        assertTrue(AlgorithmAPXtra.catDog("catxdogxdogxcat"));
        assertFalse(AlgorithmAPXtra.catDog("catxdogxdogxca"));
        assertFalse(AlgorithmAPXtra.catDog("dogdogcat"));
        assertTrue(AlgorithmAPXtra.catDog("dogogcat"));
        assertFalse(AlgorithmAPXtra.catDog("dog"));
        assertFalse(AlgorithmAPXtra.catDog("cat"));
        assertTrue(AlgorithmAPXtra.catDog("ca"));
        assertTrue(AlgorithmAPXtra.catDog("c"));
        assertTrue(AlgorithmAPXtra.catDog(""));
    }

    /**
     * < Q31 >
     * Tests the countCode method.
     */
    @Test
    public void testCountCode() {
        assertEquals(1, AlgorithmAPXtra.countCode("aaacodebbb"));
        assertEquals(2, AlgorithmAPXtra.countCode("codexxcode"));
        assertEquals(2, AlgorithmAPXtra.countCode("cozexxcope"));
        assertEquals(1, AlgorithmAPXtra.countCode("cozfxxcope"));
        assertEquals(1, AlgorithmAPXtra.countCode("xxcozeyycop"));
        assertEquals(0, AlgorithmAPXtra.countCode("cozcop"));
        assertEquals(0, AlgorithmAPXtra.countCode("abcxyz"));
        assertEquals(1, AlgorithmAPXtra.countCode("code"));
        assertEquals(0, AlgorithmAPXtra.countCode("ode"));
        assertEquals(0, AlgorithmAPXtra.countCode("c"));
        assertEquals(0, AlgorithmAPXtra.countCode(""));
        assertEquals(3, AlgorithmAPXtra.countCode("AAcodeBBcoleCCccoreDD"));
        assertEquals(2, AlgorithmAPXtra.countCode("AAcodeBBcoleCCccorfDD"));
        assertEquals(3, AlgorithmAPXtra.countCode("coAcodeBcoleccoreDD"));
    }

    /**
     * < Q32 >
     * Tests the sum13 method.
     */
    @Test
    public void testSum13() {
        assertEquals(6, AlgorithmAPXtra.sum13(new int[]{1, 2, 2, 1}));
        assertEquals(2, AlgorithmAPXtra.sum13(new int[]{1, 1}));
        assertEquals(6, AlgorithmAPXtra.sum13(new int[]{1, 2, 2, 1, 13}));
        assertEquals(4, AlgorithmAPXtra.sum13(new int[]{1, 2, 13, 2, 1, 13}));
        assertEquals(3, AlgorithmAPXtra.sum13(new int[]{13, 1, 2, 13, 2, 1, 13}));
        assertEquals(0, AlgorithmAPXtra.sum13(new int[]{}));
        assertEquals(0, AlgorithmAPXtra.sum13(new int[]{13}));
        assertEquals(0, AlgorithmAPXtra.sum13(new int[]{13, 13}));
        assertEquals(0, AlgorithmAPXtra.sum13(new int[]{13, 0, 13}));
        assertEquals(0, AlgorithmAPXtra.sum13(new int[]{13, 1, 13}));
        assertEquals(14, AlgorithmAPXtra.sum13(new int[]{5, 7, 2}));
        assertEquals(5, AlgorithmAPXtra.sum13(new int[]{5, 13, 2}));
        assertEquals(0, AlgorithmAPXtra.sum13(new int[]{0}));
        assertEquals(0, AlgorithmAPXtra.sum13(new int[]{13, 0}));
    }



    /**
     * < Q33 >
     * Tests the has22 method.
     */
    @Test
    public void testHas22() {
        assertTrue(AlgorithmAPXtra.has22(new int[]{1, 2, 2}));
        assertFalse(AlgorithmAPXtra.has22(new int[]{1, 2, 1, 2}));
        assertFalse(AlgorithmAPXtra.has22(new int[]{2, 1, 2}));
        assertTrue(AlgorithmAPXtra.has22(new int[]{2, 2, 1, 2}));
        assertFalse(AlgorithmAPXtra.has22(new int[]{1, 3, 2}));
        assertTrue(AlgorithmAPXtra.has22(new int[]{1, 3, 2, 2}));
        assertTrue(AlgorithmAPXtra.has22(new int[]{2, 3, 2, 2}));
        assertTrue(AlgorithmAPXtra.has22(new int[]{4, 2, 4, 2, 2, 5}));
        assertFalse(AlgorithmAPXtra.has22(new int[]{1, 2}));
        assertTrue(AlgorithmAPXtra.has22(new int[]{2, 2}));
        assertFalse(AlgorithmAPXtra.has22(new int[]{2}));
        assertFalse(AlgorithmAPXtra.has22(new int[]{}));
        assertTrue(AlgorithmAPXtra.has22(new int[]{3, 3, 2, 2}));
        assertFalse(AlgorithmAPXtra.has22(new int[]{5, 2, 5, 2}));
    }

    /**
     * < Q34 >
     * Tests the loneSum method.
     */
    @Test
    public void testLoneSum() {
        assertEquals(6, AlgorithmAPXtra.loneSum(1, 2, 3));
        assertEquals(2, AlgorithmAPXtra.loneSum(3, 2, 3));
        assertEquals(0, AlgorithmAPXtra.loneSum(3, 3, 3));
        assertEquals(9, AlgorithmAPXtra.loneSum(9, 2, 2));
        assertEquals(9, AlgorithmAPXtra.loneSum(2, 2, 9));
        assertEquals(9, AlgorithmAPXtra.loneSum(2, 9, 2));
        assertEquals(14, AlgorithmAPXtra.loneSum(2, 9, 3));
        assertEquals(9, AlgorithmAPXtra.loneSum(4, 2, 3));
        assertEquals(3, AlgorithmAPXtra.loneSum(1, 3, 1));
    }

    /**
     * < Q35 >
     * Tests the withoutString method.
     */
    @Test
    public void testWithoutString() {
        assertEquals("He there", AlgorithmAPXtra.withoutString("Hello there", "llo"));
        assertEquals("Hllo thr", AlgorithmAPXtra.withoutString("Hello there", "e"));
        assertEquals("Hello there", AlgorithmAPXtra.withoutString("Hello there", "x"));
        assertEquals("Th a FH", AlgorithmAPXtra.withoutString("This is a FISH", "IS"));
        assertEquals("TH a FH", AlgorithmAPXtra.withoutString("THIS is a FISH", "is"));
        assertEquals("abab", AlgorithmAPXtra.withoutString("abxxxxab", "xx"));
        assertEquals("abxab", AlgorithmAPXtra.withoutString("abxxxab", "xx"));
        assertEquals("abab", AlgorithmAPXtra.withoutString("abxxxab", "x"));
        assertEquals("", AlgorithmAPXtra.withoutString("xxx", "x"));
        assertEquals("x", AlgorithmAPXtra.withoutString("xxx", "xx"));
        assertEquals("xzz", AlgorithmAPXtra.withoutString("xyzzy", "Y"));
        assertEquals("", AlgorithmAPXtra.withoutString("", "x"));
        assertEquals("acac", AlgorithmAPXtra.withoutString("abcabc", "b"));
        assertEquals("AAbb", AlgorithmAPXtra.withoutString("AA22bb", "2"));
        assertEquals("", AlgorithmAPXtra.withoutString("1111", "1"));
        assertEquals("", AlgorithmAPXtra.withoutString("1111", "11"));
        assertEquals("jtx", AlgorithmAPXtra.withoutString("MkjtMkx", "Mk"));
        assertEquals("Hi ", AlgorithmAPXtra.withoutString("Hi HoHo", "Ho"));
    }
}
