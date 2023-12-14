package org.example;

public class Factorial {

    public long getFactorial(int f) {
        if (f < 0) {
            throw new IllegalArgumentException("Нельзя высчитать факториал отрицательного числа");
        } else if (f == 1 || f == 0) {
            return 1;
        }
        else {
            return f * getFactorial(f - 1);
        }
    }
}
