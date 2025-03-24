package com.raxrot.parameterized;

import com.raxrot.MathUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CsvSourceDemoTest {

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,2",
            "5,120"
    })
    public void testCsvSource(int number, int expected) {
        MathUtils mathUtils = new MathUtils();
        assertEquals(mathUtils.factorial(number), expected);
    }

    @ParameterizedTest
    @CsvSource({
            "hello, HELLO",
            "world, WORLD",
            "java, JAVA"
    })
    void testToUpperCase(String input, String expected) {
        assertEquals(expected, input.toUpperCase());
    }
}
