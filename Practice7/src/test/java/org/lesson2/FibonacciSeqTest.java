package org.lesson2;

import org.junit.Assert;
import org.junit.Test;
import org.lesson2.fibonacci.FibonacciSeq;

public class FibonacciSeqTest {

    @Test
    public void getFibonacciNumberIterativeTestShouldReturn5() {
        Assert.assertEquals(5, FibonacciSeq.getFibonacciNumberIterative(6));
    }

    @Test
    public void getFibonacciNumberIterativeTestShouldReturn0() {
        Assert.assertEquals(0, FibonacciSeq.getFibonacciNumberIterative(0));
    }

    @Test
    public void getFibonacciNumberIterativeTestShouldReturn1() {
        Assert.assertEquals(1, FibonacciSeq.getFibonacciNumberIterative(2));
    }

    @Test
    public void getFibonacciNumberRecursiveTestShouldReturn2() {
        Assert.assertEquals(2, FibonacciSeq.getFibonacciNumberIterative(4));
    }
}
