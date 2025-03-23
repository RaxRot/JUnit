package com.raxrot.annotations;

import com.raxrot.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeforeAllDemoTest {

    private static Calculator calculator;

    @BeforeAll
   static void setUp() {
        calculator = new Calculator();
    }
    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @DisplayName("Test addition of two numbers")
    @Test
    public void addTest(){
        int addition = calculator.add(2,3);
        int expected = 5;
        assertEquals(expected,addition,"wrong result");
    }

    @DisplayName("Test subtraction of two numbers")
    @Test
    public void subtractTest(){
        int subtraction = calculator.subtract(2,3);
        int expected = -1;
        assertEquals(expected,subtraction,"wrong result");
    }
}
