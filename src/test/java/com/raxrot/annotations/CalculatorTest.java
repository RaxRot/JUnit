package com.raxrot.annotations;

import com.raxrot.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator operations test")
public class CalculatorTest {

    @DisplayName("Test addition of two numbers")
    @Test
    public void addTest(){
        Calculator calculator = new Calculator();
        int addition = calculator.add(2,3);
        int expected = 5;
        assertEquals(expected,addition,"wrong result");
    }

    @DisplayName("Test subtraction of two numbers")
    @Test
    public void subtractTest(){
        Calculator calculator = new Calculator();
        int subtraction = calculator.subtract(2,3);
        int expected = -1;
        assertEquals(expected,subtraction,"wrong result");
    }
}
