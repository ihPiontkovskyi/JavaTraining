package org.lesson1;

public class Calculator {

    public static final String MINUS = "-";
    public static final String PLUS = "+";
    public static final String MULT = "*";
    public static final String DIV = "/";

    public int calculate(int a, String operator, int b) {
        if (operator == null) {
            throw new NullPointerException();
        }
        switch (operator) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MULT:
                return a * b;
            case DIV:
                return a / b;
            default:
                throw new IllegalArgumentException();
        }
    }
}
