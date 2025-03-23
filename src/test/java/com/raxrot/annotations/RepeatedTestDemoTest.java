package com.raxrot.annotations;

import com.raxrot.Calculator;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedTestDemoTest {

    @RepeatedTest(5)
    public void addTest() {
        Calculator calculator = new Calculator();
        assertEquals(5,calculator.add(2,3), "wrong result");
    }
}
