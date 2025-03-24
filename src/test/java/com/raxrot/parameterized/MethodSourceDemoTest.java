package com.raxrot.parameterized;

import com.raxrot.MathUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodSourceDemoTest {


    static Stream<Arguments>argumentsMyTest(){
        return Stream.of(
              Arguments.of(3,3),
                Arguments.of(4,4)
        );
    }

    static Stream<Arguments> argumentsMyTest2(){
        return Stream.of(
                Arguments.of(4,24),
                Arguments.of(5,120)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsMyTest")
    public void test(int a, int b){
        assertEquals(a,b);
    }

    @ParameterizedTest
    @MethodSource("argumentsMyTest2")
    public void test2(int a, int b){
        MathUtils mathUtils = new MathUtils();
        assertEquals(mathUtils.factorial(a),b);
    }
}
