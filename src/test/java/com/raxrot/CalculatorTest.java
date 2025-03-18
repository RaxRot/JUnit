package com.raxrot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void addTest(){
        Calculator calc = new Calculator();
        int actualResult = calc.add(1,2);
        int expectedResult = 3;
        assertEquals(expectedResult,actualResult);
    }
}