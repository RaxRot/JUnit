package com.raxrot;

public class Factorial {
    public int factorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}
