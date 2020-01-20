package org.lesson2.factorial;

import java.math.BigInteger;

public class LongFactorial {
    private LongFactorial() {
    }

    public static BigInteger factorial(Integer n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
