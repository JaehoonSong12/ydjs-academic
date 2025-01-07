package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyClass2Test {
    @Test
    public void testMainMethod() {
        String expectedOutput = "Hello, MyClass2!";
        assertEquals(expectedOutput, "Hello, MyClass2!");
    }
}