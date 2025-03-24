package com.raxrot.parameterized;

import com.raxrot.MathUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ValueScoreDemoTest {

    @ParameterizedTest
    @ValueSource(ints = {2,4,6})
    void isEvenTest(int number) {
        MathUtils mathUtils = new MathUtils();
        assertTrue(mathUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Vlad","Daria"})
    void isStringsNotNullTest(String string) {
        assertNotNull(string);
    }
}
