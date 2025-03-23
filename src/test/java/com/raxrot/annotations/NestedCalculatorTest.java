package com.raxrot.annotations;

import com.raxrot.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedCalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("Addition tests")
    class AdditionTest{
        @Test
        public void addPositiveNumbers(){
            assertEquals(6,calculator.add(1,5));
        }
        @Test
        public void addNegativeNumbers(){
            assertEquals(-5,calculator.add(-10,5));
        }
    }

    @Nested
    @DisplayName("Subtraction tests")
    class SubtractionTest{
        @Test
        public void subtractPositiveNumbers(){
            assertEquals(-4,calculator.subtract(1,5));
        }
        @Test
        public void subtractNegativeNumbers(){
            assertEquals(0,calculator.subtract(-5,-5));
        }
    }
}
