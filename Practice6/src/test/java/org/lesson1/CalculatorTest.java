package org.lesson1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void calculateShouldReturnSum() {
        final int actual = calculator.calculate(1, "+", 2);
        final int expected = 3;
        Assert.assertEquals("Actual sum not equal to expected value", expected, actual);
    }

    @Test
    public void calculateShouldReturnDifference() {
        final int actual = calculator.calculate(1, "-", 2);
        final int expected = -1;
        Assert.assertEquals("Actual diff not equal to expected value", expected, actual);
    }

    @Test
    public void calculateShouldReturnMult() {
        final int actual = calculator.calculate(1, "*", 2);
        final int expected = 2;
        Assert.assertEquals("Actual multiplication not equal to expected value", expected, actual);
    }

    @Test
    public void calculateShouldReturnDiv() {
        final int actual = calculator.calculate(2, "/", 3);
        final int expected = 0;
        Assert.assertEquals("Actual division not equal to expected value", expected, actual);
    }

    @Test(expected = ArithmeticException.class)
    public void calculateShouldThrowArithmeticalExceptionDivideByZero() {
        final int actual = calculator.calculate(2, "/", 0);
        final int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void calculateShouldThrowExceptionNullOperator() {
        final int actual = calculator.calculate(2, null, 0);
        final int expected = 2;
        Assert.assertEquals(expected, actual);
    }
}
