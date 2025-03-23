package com.raxrot.annotations;

import com.raxrot.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderCalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Order(1)
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(3, 2));
    }
    @Order(3)
    @Test
    public void testSubtract() {
        assertEquals(4, calculator.subtract(6, 2));
    }

    @Order(2)
    @Test
    public void testMultiply() {
        assertEquals(2, calculator.multiply(1, 2));
    }

    @Order(4)
    @Test
    public void testDivide() {
        assertEquals(1, calculator.divide(2, 2));
    }
}
