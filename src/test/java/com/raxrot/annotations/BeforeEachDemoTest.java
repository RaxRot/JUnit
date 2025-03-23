package com.raxrot.annotations;

import com.raxrot.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeforeEachDemoTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
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
