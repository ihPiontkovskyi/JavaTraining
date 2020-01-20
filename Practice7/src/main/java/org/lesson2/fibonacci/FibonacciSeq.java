package org.lesson2.fibonacci;

public class FibonacciSeq {
    private FibonacciSeq() {
    }

    public static int getFibonacciNumberRecursive(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Fibonacci sequence doesnt contains negative indexes");
        }
        if (index == 1 || index == 0) {
            return index;
        } else {
            return getFibonacciNumberRecursive(index - 1) + getFibonacciNumberRecursive(index - 2);
        }
    }

    public static int getFibonacciNumberIterative(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Fibonacci sequence doesnt contains negative indexes");
        }
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        int previous = 0;
        int current = 1;
        int next;
        for (int i = 2; i < index; i++) {
            next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}
