
// JDK-17: https://developers.redhat.com/products/openjdk/download?sc_cid=701f2000000RWTnAAO
// JUnit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.10.0

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The AlgorithmAPTest class provides JUnit tests for the recursive methods in the AlgorithmAP class.
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile (Current Test Only): 
 *      `javac -cp student04-anderson/junit-platform-console-standalone-1.9.3.jar student04-anderson/MyArrayList*.java`
 * 3. Compile (All Tests): 
 *      `javac -cp student04-anderson/junit-platform-console-standalone-1.9.3.jar student04-anderson/*.java`
 * 4. Run & Clean: 
 *      `java -jar student04-anderson/junit-platform-console-standalone-1.9.3.jar --class-path student04-anderson --scan-classpath; rm -rf student04-anderson/*.class`
 */
public class MyArrayListTest {

    /**
     * Tests that a newly constructed list is empty and reports size 0.
     */
    @Test
    public void constructorTest() {
        MyArrayList<String> list = new MyArrayList<>();
        assertTrue(list.isEmpty(), "New list should be empty");
        assertEquals(0, list.size(), "New list should have size 0");
    }

    /**
     * Tests add(T) and get(int), including automatic growth beyond initial capacity.
     */
    @Test
    public void addAndGetTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        // Add more than 10 elements to force a grow()
        for (int i = 0; i < 15; i++) {
            list.add(i * 2);
        }
        assertEquals(15, list.size(), "Size should reflect number of added elements");
        for (int i = 0; i < 15; i++) {
            assertEquals(i * 2, list.get(i), "Element at index " + i + " should match");
        }
    }

    /**
     * Tests get(int) throws IndexOutOfBoundsException for invalid indices.
     */
    @Test
    public void getOutOfBoundsTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1),
            "get(-1) should throw IndexOutOfBoundsException");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1),
            "get(size) should throw IndexOutOfBoundsException");
    }

    /**
     * Tests isEmpty() and clear() behavior.
     */
    @Test
    public void clearAndIsEmptyTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("X");
        list.add("Y");
        assertFalse(list.isEmpty(), "List should not be empty after adds");
        list.clear();
        assertTrue(list.isEmpty(), "List should be empty after clear()");
        assertEquals(0, list.size(), "Size should be 0 after clear()");
        // ensure we can add again after clearing
        list.add("Z");
        assertEquals(1, list.size(), "Size should be 1 after adding post-clear");
        assertEquals("Z", list.get(0), "Element should be retrievable after clearing");
    }

    /**
     * Tests set(int,T) replaces elements correctly and returns the old value.
     */
    @Test
    public void setTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("first");
        list.add("second");
        String old = list.set(1, "newSecond");
        assertEquals("second", old, "set should return the old element");
        assertEquals("newSecond", list.get(1), "Element should be updated to new value");
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, "x"),
            "set(size) should throw IndexOutOfBoundsException");
    }

    /**
     * Tests remove(int) shifts elements and returns the removed value.
     */
    @Test
    public void removeTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        Integer removed = list.remove(1);
        assertEquals(20, removed, "remove should return the removed element");
        assertEquals(2, list.size(), "Size should decrement after remove");
        assertEquals(30, list.get(1), "Elements should shift left after remove");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2),
            "remove(size) should throw IndexOutOfBoundsException");
    }

    /**
     * Tests contains(Object) and indexOf(Object) for present and absent elements.
     */
    @Test
    public void containsAndIndexOfTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add(null);
        list.add("banana");
        assertTrue(list.contains("apple"), "List should contain 'apple'");
        assertEquals(0, list.indexOf("apple"), "indexOf should find 'apple' at 0");
        assertTrue(list.contains(null), "List should contain null");
        assertEquals(1, list.indexOf(null), "indexOf should find null at 1");
        assertFalse(list.contains("cherry"), "List should not contain 'cherry'");
        assertEquals(-1, list.indexOf("cherry"), "indexOf should return -1 for absent element");
    }

    /**
     * Tests toString() returns a properly formatted string.
     */
    @Test
    public void toStringTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertEquals("[]", list.toString(), "Empty list toString should be []");
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("[1, 2, 3]", list.toString(), "toString should list elements in order");
    }
}
