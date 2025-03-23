package com.raxrot.annotations;

import com.raxrot.Calculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisableCalculatorTest {

    @Disabled("Disabled until bug will fixed")
    @Test
    void addTest(){
        Calculator calculator = new Calculator();
        int result = calculator.add(2,3);
        assertEquals(5, result);
    }

    @Test
    void subtractTest(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(2,3);
        assertEquals(-1, result);
    }
}
