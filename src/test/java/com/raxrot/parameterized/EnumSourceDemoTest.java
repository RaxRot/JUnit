package com.raxrot.parameterized;

import com.raxrot.Days;
import com.raxrot.MathUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class EnumSourceDemoTest {

    private MathUtils mathUtils;

    @ParameterizedTest
    @EnumSource(Days.class)
    void isWeekDay(Days days) {
        mathUtils = new MathUtils();
        assertNotNull(mathUtils.isWeekDay(days));
    }
}
