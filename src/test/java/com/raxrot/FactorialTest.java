package com.raxrot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    public void testFactorial() {
        Factorial f = new Factorial();
        int actualResult = f.factorial(5);
        int expectedResult = 120;
        assertEquals(expectedResult,actualResult);
    }

}