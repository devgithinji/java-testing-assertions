package org.densoft;

public class Calculator {
    public int add(int no1, int no2) {
        return Math.addExact(no1, no2);
    }

    public int multiply(int no1, int no2) {
        return Math.multiplyExact(no1, no2);
    }

    public float divide(int dividend, int divisor) {
        return Math.floorDiv(dividend, divisor);
    }
}
