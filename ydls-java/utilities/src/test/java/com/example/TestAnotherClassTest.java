package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAnotherClassTest {
    @Test
    public void testMainMethod() {
        String expectedOutput = "Hello, AnotherClass!";
        assertEquals(expectedOutput, "Hello, AnotherClass!");
    }
}