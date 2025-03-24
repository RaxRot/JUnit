package com.raxrot.parameterized;

import com.raxrot.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgumentSourceDemoTest {

    @ParameterizedTest
    @ArgumentsSource(MyCustomArgumentsProvider.class)
    void myTest2(int a, int b,int c){
        Calculator calculator = new Calculator();
        assertEquals(calculator.add(a,b), c);
    }
}
