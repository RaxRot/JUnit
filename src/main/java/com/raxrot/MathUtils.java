package com.raxrot;

public class MathUtils {

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isWeekDay(Days days) {
        return days != Days.SATURDAY || days != Days.SUNDAY;
    }
}
