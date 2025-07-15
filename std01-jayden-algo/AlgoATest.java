/**
INSTRUCTIONS: 
    The AlgoATest class provides JUnit tests for the recursive 
    methods in the AlgoA class.



COMPILE & EXECUTE & CLEANUP (Java):

     javac     -d out           -cp junit-1.9.3.jar     AlgoA*.java
     java -jar junit-1.9.3.jar  --class-path "out"      --scan-classpath
     rm -rf out/

COMPILE & EXECUTE & CLEANUP (Java x Kotlin):

     javac     -d out   -cp junit-1.9.3.jar             AlgoA*.java
     kotlinc    -d out                                  AlgoA*.kt
     java -jar junit-1.9.3.jar --class-path "./out:$KOTLIN_HOME/lib/kotlin-stdlib.jar" --scan-classpath
     rm -rf out/

TIP:
     - On Windows, use ';' as the classpath separator
     - On Mac/Linux, use ':' as the classpath separator
     - java   `-cp` (Mac/Linux) flag must sepcify absolute paths.
     - kotlin `-cp` (Windows) flag accepts relative paths.
 */

// File: AlgoATest.java
// JDK-17: https://developers.redhat.com/products/openjdk/download?sc_cid=701f2000000RWTnAAO
// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class AlgoATest {
    

    /**
     * < Q27 >
     * Tests the makeBricks method.
     */
    @Test
    public void testMakeBricks() {
        assertTrue(AlgoA.makeBricks(3, 1, 8));
        assertFalse(AlgoA.makeBricks(3, 1, 9));
        assertTrue(AlgoA.makeBricks(3, 2, 10));
        assertTrue(AlgoA.makeBricks(3, 2, 8));
        assertFalse(AlgoA.makeBricks(3, 2, 9));
        assertTrue(AlgoA.makeBricks(6, 1, 11));
        assertFalse(AlgoA.makeBricks(6, 0, 11));
        assertTrue(AlgoA.makeBricks(1, 4, 11));
        assertTrue(AlgoA.makeBricks(0, 3, 10));
        assertFalse(AlgoA.makeBricks(1, 4, 12));
        assertTrue(AlgoA.makeBricks(3, 1, 7));
        assertFalse(AlgoA.makeBricks(1, 1, 7));
        assertTrue(AlgoA.makeBricks(2, 1, 7));
        assertTrue(AlgoA.makeBricks(7, 1, 11));
        assertTrue(AlgoA.makeBricks(7, 1, 8));
        assertFalse(AlgoA.makeBricks(7, 1, 13));
        assertTrue(AlgoA.makeBricks(43, 1, 46));
        assertFalse(AlgoA.makeBricks(40, 1, 46));
        assertTrue(AlgoA.makeBricks(40, 2, 47));
        assertTrue(AlgoA.makeBricks(40, 2, 50));
        assertFalse(AlgoA.makeBricks(40, 2, 52));
        assertFalse(AlgoA.makeBricks(22, 2, 33));
        assertTrue(AlgoA.makeBricks(0, 2, 10));
        assertTrue(AlgoA.makeBricks(1000000, 1000, 1000100));
        assertFalse(AlgoA.makeBricks(2, 1000000, 100003));
        assertTrue(AlgoA.makeBricks(20, 0, 19));
        assertFalse(AlgoA.makeBricks(20, 0, 21));
        assertFalse(AlgoA.makeBricks(20, 4, 51));
        assertTrue(AlgoA.makeBricks(20, 4, 39));
    }
    

    /**
     * < Q28 >
     * Tests the countYZ method.
     */
    @Test
    public void testCountYZ() {
        assertEquals(2, AlgoA.countYZ("fez day"));
        assertEquals(2, AlgoA.countYZ("day fez"));
        assertEquals(2, AlgoA.countYZ("day fyyyz"));
        assertEquals(1, AlgoA.countYZ("day yak"));
        assertEquals(1, AlgoA.countYZ("day:yak"));
        assertEquals(2, AlgoA.countYZ("!!day--yaz!!"));
        assertEquals(0, AlgoA.countYZ("yak zak"));
        assertEquals(2, AlgoA.countYZ("DAY abc XYZ"));
        assertEquals(3, AlgoA.countYZ("aaz yyz my"));
        assertEquals(2, AlgoA.countYZ("y2bz"));
        assertEquals(0, AlgoA.countYZ("zxyx"));
    }

    /**
     * < Q29 >
     * Tests the maxSpan method.
     */
    @Test
    public void testMaxSpan() {
        assertEquals(4, AlgoA.maxSpan(new int[]{1, 2, 1, 1, 3}));
        assertEquals(6, AlgoA.maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}));
        assertEquals(6, AlgoA.maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}));
        assertEquals(3, AlgoA.maxSpan(new int[]{3, 3, 3}));
        assertEquals(3, AlgoA.maxSpan(new int[]{3, 9, 3}));
        assertEquals(2, AlgoA.maxSpan(new int[]{3, 9, 9}));
        assertEquals(1, AlgoA.maxSpan(new int[]{3, 9}));
        assertEquals(2, AlgoA.maxSpan(new int[]{3, 3}));
        assertEquals(0, AlgoA.maxSpan(new int[]{}));
        assertEquals(1, AlgoA.maxSpan(new int[]{1}));
    }











    
    /**
     * < Q30 >
     * Tests the catDog method.
     */
    @Test
    public void testCatDog() {
        assertTrue(AlgoA.catDog("catdog"));
        assertFalse(AlgoA.catDog("catcat"));
        assertTrue(AlgoA.catDog("1cat1cadodog"));
        assertFalse(AlgoA.catDog("catxxdogxxxdog"));
        assertTrue(AlgoA.catDog("catxdogxdogxcat"));
        assertFalse(AlgoA.catDog("catxdogxdogxca"));
        assertFalse(AlgoA.catDog("dogdogcat"));
        assertTrue(AlgoA.catDog("dogogcat"));
        assertFalse(AlgoA.catDog("dog"));
        assertFalse(AlgoA.catDog("cat"));
        assertTrue(AlgoA.catDog("ca"));
        assertTrue(AlgoA.catDog("c"));
        assertTrue(AlgoA.catDog(""));
    }

    /**
     * < Q31 >
     * Tests the countCode method.
     */
    @Test
    public void testCountCode() {
        assertEquals(1, AlgoA.countCode("aaacodebbb"));
        assertEquals(2, AlgoA.countCode("codexxcode"));
        assertEquals(2, AlgoA.countCode("cozexxcope"));
        assertEquals(1, AlgoA.countCode("cozfxxcope"));
        assertEquals(1, AlgoA.countCode("xxcozeyycop"));
        assertEquals(0, AlgoA.countCode("cozcop"));
        assertEquals(0, AlgoA.countCode("abcxyz"));
        assertEquals(1, AlgoA.countCode("code"));
        assertEquals(0, AlgoA.countCode("ode"));
        assertEquals(0, AlgoA.countCode("c"));
        assertEquals(0, AlgoA.countCode(""));
        assertEquals(3, AlgoA.countCode("AAcodeBBcoleCCccoreDD"));
        assertEquals(2, AlgoA.countCode("AAcodeBBcoleCCccorfDD"));
        assertEquals(3, AlgoA.countCode("coAcodeBcoleccoreDD"));
    }

    /**
     * < Q32 >
     * Tests the sum13 method.
     */
    @Test
    public void testSum13() {
        assertEquals(6, AlgoA.sum13(new int[]{1, 2, 2, 1}));
        assertEquals(2, AlgoA.sum13(new int[]{1, 1}));
        assertEquals(6, AlgoA.sum13(new int[]{1, 2, 2, 1, 13}));
        assertEquals(4, AlgoA.sum13(new int[]{1, 2, 13, 2, 1, 13}));
        assertEquals(3, AlgoA.sum13(new int[]{13, 1, 2, 13, 2, 1, 13}));
        assertEquals(0, AlgoA.sum13(new int[]{}));
        assertEquals(0, AlgoA.sum13(new int[]{13}));
        assertEquals(0, AlgoA.sum13(new int[]{13, 13}));
        assertEquals(0, AlgoA.sum13(new int[]{13, 0, 13}));
        assertEquals(0, AlgoA.sum13(new int[]{13, 1, 13}));
        assertEquals(14, AlgoA.sum13(new int[]{5, 7, 2}));
        assertEquals(5, AlgoA.sum13(new int[]{5, 13, 2}));
        assertEquals(0, AlgoA.sum13(new int[]{0}));
        assertEquals(0, AlgoA.sum13(new int[]{13, 0}));
    }



    /**
     * < Q33 >
     * Tests the has22 method.
     */
    @Test
    public void testHas22() {
        assertTrue(AlgoA.has22(new int[]{1, 2, 2}));
        assertFalse(AlgoA.has22(new int[]{1, 2, 1, 2}));
        assertFalse(AlgoA.has22(new int[]{2, 1, 2}));
        assertTrue(AlgoA.has22(new int[]{2, 2, 1, 2}));
        assertFalse(AlgoA.has22(new int[]{1, 3, 2}));
        assertTrue(AlgoA.has22(new int[]{1, 3, 2, 2}));
        assertTrue(AlgoA.has22(new int[]{2, 3, 2, 2}));
        assertTrue(AlgoA.has22(new int[]{4, 2, 4, 2, 2, 5}));
        assertFalse(AlgoA.has22(new int[]{1, 2}));
        assertTrue(AlgoA.has22(new int[]{2, 2}));
        assertFalse(AlgoA.has22(new int[]{2}));
        assertFalse(AlgoA.has22(new int[]{}));
        assertTrue(AlgoA.has22(new int[]{3, 3, 2, 2}));
        assertFalse(AlgoA.has22(new int[]{5, 2, 5, 2}));
    }

    /**
     * < Q34 >
     * Tests the loneSum method.
     */
    @Test
    public void testLoneSum() {
        assertEquals(6, AlgoA.loneSum(1, 2, 3));
        assertEquals(2, AlgoA.loneSum(3, 2, 3));
        assertEquals(0, AlgoA.loneSum(3, 3, 3));
        assertEquals(9, AlgoA.loneSum(9, 2, 2));
        assertEquals(9, AlgoA.loneSum(2, 2, 9));
        assertEquals(9, AlgoA.loneSum(2, 9, 2));
        assertEquals(14, AlgoA.loneSum(2, 9, 3));
        assertEquals(9, AlgoA.loneSum(4, 2, 3));
        assertEquals(3, AlgoA.loneSum(1, 3, 1));
    }

    /**
     * < Q35 >
     * Tests the withoutString method.
     */
    @Test
    public void testWithoutString() {
        assertEquals("He there", AlgoA.withoutString("Hello there", "llo"));
        assertEquals("Hllo thr", AlgoA.withoutString("Hello there", "e"));
        assertEquals("Hello there", AlgoA.withoutString("Hello there", "x"));
        assertEquals("Th a FH", AlgoA.withoutString("This is a FISH", "IS"));
        assertEquals("TH a FH", AlgoA.withoutString("THIS is a FISH", "is"));
        assertEquals("abab", AlgoA.withoutString("abxxxxab", "xx"));
        assertEquals("abxab", AlgoA.withoutString("abxxxab", "xx"));
        assertEquals("abab", AlgoA.withoutString("abxxxab", "x"));
        assertEquals("", AlgoA.withoutString("xxx", "x"));
        assertEquals("x", AlgoA.withoutString("xxx", "xx"));
        assertEquals("xzz", AlgoA.withoutString("xyzzy", "Y"));
        assertEquals("", AlgoA.withoutString("", "x"));
        assertEquals("acac", AlgoA.withoutString("abcabc", "b"));
        assertEquals("AAbb", AlgoA.withoutString("AA22bb", "2"));
        assertEquals("", AlgoA.withoutString("1111", "1"));
        assertEquals("", AlgoA.withoutString("1111", "11"));
        assertEquals("jtx", AlgoA.withoutString("MkjtMkx", "Mk"));
        assertEquals("Hi ", AlgoA.withoutString("Hi HoHo", "Ho"));
    }
}
