// File: AlgorithmAPSecondTest.java
// JDK-17: https://developers.redhat.com/products/openjdk/download?sc_cid=701f2000000RWTnAAO
// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * The AlgorithmAPSecondTest class provides JUnit tests for the recursive methods 
 * in the AlgorithmAPSecond class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile (Current Test Only): 
 *      `javac -cp junit-1.9.3.jar std02-arron-algo/AlgorithmAPSecond*.java`
 * 3. Compile (All Tests): 
 *      `javac -cp junit-1.9.3.jar std02-arron-algo/*.java`
 * 4. Run & Clean: 
 *      `java -jar junit-1.9.3.jar --class-path std02-arron-algo --scan-classpath; rm -rf std02-arron-algo/*.class`
 */
public class AlgorithmAPSecondTest {
    
    /**
     * < Q10 >
     * Tests the copyEvens method.
     */ 
    @Test
    public void testCopyEvens() {
        assertArrayEquals(new int[]{2, 4}, 
            AlgorithmAPSecond.copyEvens(new int[]{3, 2, 4, 5, 8}, 2));

        assertArrayEquals(new int[]{2, 4, 8}, 
            AlgorithmAPSecond.copyEvens(new int[]{3, 2, 4, 5, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4}, 
            AlgorithmAPSecond.copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4, 8}, 
            AlgorithmAPSecond.copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 4));

        assertArrayEquals(new int[]{4}, 
            AlgorithmAPSecond.copyEvens(new int[]{3, 1, 4, 1, 5}, 1));

        assertArrayEquals(new int[]{2}, 
            AlgorithmAPSecond.copyEvens(new int[]{2}, 1));

        assertArrayEquals(new int[]{6, 2}, 
            AlgorithmAPSecond.copyEvens(new int[]{6, 2, 4, 8}, 2));

        assertArrayEquals(new int[]{6, 2, 4}, 
            AlgorithmAPSecond.copyEvens(new int[]{6, 2, 4, 8}, 3));

        assertArrayEquals(new int[]{6, 2, 4, 8}, 
            AlgorithmAPSecond.copyEvens(new int[]{6, 2, 4, 8}, 4));

        assertArrayEquals(new int[]{8}, 
            AlgorithmAPSecond.copyEvens(new int[]{1, 8, 4}, 1));

        assertArrayEquals(new int[]{8, 4}, 
            AlgorithmAPSecond.copyEvens(new int[]{1, 8, 4}, 2));

        assertArrayEquals(new int[]{2, 8}, 
            AlgorithmAPSecond.copyEvens(new int[]{2, 8, 4}, 2));
    }
}
