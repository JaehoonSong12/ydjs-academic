// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * The AlgorithmRecurTest class provides JUnit tests for the recursive methods in the AlgorithmRecur class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile (Current Test Only): 
 *      `javac -cp async-algo/junit-platform-console-standalone-1.9.3.jar async-algo/AlgorithmRecur*.java`
 * 3. Compile (All Tests): 
 *      `javac -cp async-algo/junit-platform-console-standalone-1.9.3.jar async-algo/*.java`
 * 4. Run & Clean: 
 *      ````
 *      java -jar async-algo/junit-platform-console-standalone-1.9.3.jar --class-path async-algo --scan-classpath; rm -rf async-algo/*.class
 *      ````
 */
public class AlgorithmRecurTest {

    /**
     * Tests the factorial method.
     */
    @Test
    public void testFactorial() {
        assertEquals(1, AlgorithmRecur.factorial(0), "0! should be 1");
        assertEquals(1, AlgorithmRecur.factorial(1), "1! should be 1");
        assertEquals(2, AlgorithmRecur.factorial(2), "2! should be 2");
        assertEquals(6, AlgorithmRecur.factorial(3), "3! should be 6");
        assertEquals(24, AlgorithmRecur.factorial(4), "4! should be 24");
        assertEquals(120, AlgorithmRecur.factorial(5), "5! should be 120");
    }

    /**
     * Tests the bunnyEars method.
     */
    @Test
    public void testBunnyEars() {
        assertEquals(0, AlgorithmRecur.bunnyEars(0), "0 bunnies should have 0 ears");
        assertEquals(2, AlgorithmRecur.bunnyEars(1), "1 bunny should have 2 ears");
        assertEquals(4, AlgorithmRecur.bunnyEars(2), "2 bunnies should have 4 ears");
        assertEquals(10, AlgorithmRecur.bunnyEars(5), "5 bunnies should have 10 ears");
        assertEquals(24, AlgorithmRecur.bunnyEars(12), "12 bunnies should have 24 ears");
    }

    /**
     * Tests the fibonacci method.
     */
    @Test
    public void testFibonacci() {
        assertEquals(0, AlgorithmRecur.fibonacci(0), "fibonacci(0) should be 0");
        assertEquals(1, AlgorithmRecur.fibonacci(1), "fibonacci(1) should be 1");
        assertEquals(1, AlgorithmRecur.fibonacci(2), "fibonacci(2) should be 1");
        assertEquals(2, AlgorithmRecur.fibonacci(3), "fibonacci(3) should be 2");
        assertEquals(3, AlgorithmRecur.fibonacci(4), "fibonacci(4) should be 3");
        assertEquals(5, AlgorithmRecur.fibonacci(5), "fibonacci(5) should be 5");
        assertEquals(8, AlgorithmRecur.fibonacci(6), "fibonacci(6) should be 8");
        assertEquals(13, AlgorithmRecur.fibonacci(7), "fibonacci(7) should be 13");
    }

    /**
     * Tests the sumDigits method.
     */
    @Test
    public void testSumDigits() {
        assertEquals(9, AlgorithmRecur.sumDigits(126), "Sum of digits of 126 should be 9");
        assertEquals(13, AlgorithmRecur.sumDigits(49), "Sum of digits of 49 should be 13");
        assertEquals(3, AlgorithmRecur.sumDigits(12), "Sum of digits of 12 should be 3");
        assertEquals(1, AlgorithmRecur.sumDigits(10), "Sum of digits of 10 should be 1");
        assertEquals(0, AlgorithmRecur.sumDigits(0), "Sum of digits of 0 should be 0");
        assertEquals(10, AlgorithmRecur.sumDigits(730), "Sum of digits of 730 should be 10");
    }

    /**
     * Tests the count8 method.
     */
    @Test
    public void testCount8() {
        assertEquals(1, AlgorithmRecur.count8(8), "count8(8) should return 1");
        assertEquals(2, AlgorithmRecur.count8(818), "count8(818) should return 2");
        assertEquals(4, AlgorithmRecur.count8(8818), "count8(8818) should return 4");
        assertEquals(4, AlgorithmRecur.count8(8088), "count8(8088) should return 4");
        assertEquals(0, AlgorithmRecur.count8(123), "count8(123) should return 0");
        assertEquals(2, AlgorithmRecur.count8(81238), "count8(81238) should return 2");
        assertEquals(6, AlgorithmRecur.count8(88788), "count8(88788) should return 6");
        assertEquals(1, AlgorithmRecur.count8(8234), "count8(8234) should return 1");
        assertEquals(1, AlgorithmRecur.count8(2348), "count8(2348) should return 1");
        assertEquals(3, AlgorithmRecur.count8(23884), "count8(23884) should return 3");
        assertEquals(0, AlgorithmRecur.count8(0), "count8(0) should return 0");
        assertEquals(5, AlgorithmRecur.count8(1818188), "count8(1818188) should return 5");
        assertEquals(5, AlgorithmRecur.count8(8818181), "count8(8818181) should return 5");
        assertEquals(1, AlgorithmRecur.count8(1080), "count8(1080) should return 1");
        assertEquals(3, AlgorithmRecur.count8(188), "count8(188) should return 3");
        assertEquals(9, AlgorithmRecur.count8(88888), "count8(88888) should return 9");
        assertEquals(2, AlgorithmRecur.count8(9898), "count8(9898) should return 2");
        assertEquals(1, AlgorithmRecur.count8(78), "count8(78) should return 1");
    }

    /**
     * Tests the powerN method.
     */
    @Test
    public void testPowerN() {
        assertEquals(3, AlgorithmRecur.powerN(3, 1), "powerN(3, 1) should return 3");
        assertEquals(9, AlgorithmRecur.powerN(3, 2), "powerN(3, 2) should return 9");
        assertEquals(27, AlgorithmRecur.powerN(3, 3), "powerN(3, 3) should return 27");
        assertEquals(2, AlgorithmRecur.powerN(2, 1), "powerN(2, 1) should return 2");
        assertEquals(4, AlgorithmRecur.powerN(2, 2), "powerN(2, 2) should return 4");
        assertEquals(8, AlgorithmRecur.powerN(2, 3), "powerN(2, 3) should return 8");
        assertEquals(16, AlgorithmRecur.powerN(2, 4), "powerN(2, 4) should return 16");
        assertEquals(32, AlgorithmRecur.powerN(2, 5), "powerN(2, 5) should return 32");
        assertEquals(10, AlgorithmRecur.powerN(10, 1), "powerN(10, 1) should return 10");
        assertEquals(100, AlgorithmRecur.powerN(10, 2), "powerN(10, 2) should return 100");
        assertEquals(1000, AlgorithmRecur.powerN(10, 3), "powerN(10, 3) should return 1000");
    }
}
