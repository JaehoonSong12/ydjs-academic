package eugene.unit.b;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Example01Test {
    @Test
    public void testMainMethod() {
        String expectedOutput = "Hello, Example01!";
        assertEquals(expectedOutput, "Hello, Example01!");
    }
}