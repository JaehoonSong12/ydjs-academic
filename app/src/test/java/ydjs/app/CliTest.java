package ydjs.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CliTest {
    @Test
    public void testMainMethod() {
        String expectedOutput = "Hello, Cli!";
        assertEquals(expectedOutput, "Hello, Cli!");
    }
}