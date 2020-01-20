package org.lesson2;

import org.junit.Assert;
import org.junit.Test;
import org.lesson2.factorial.LongFactorial;

public class FactorialTest {

    @Test
    public void factorialTestShouldReturn39_916_800(){
        Assert.assertEquals("39916800", LongFactorial.factorial(11).toString());
    }
}
