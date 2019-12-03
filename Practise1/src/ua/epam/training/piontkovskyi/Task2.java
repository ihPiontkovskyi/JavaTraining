package ua.epam.training.piontkovskyi;

import java.util.Scanner;

public class Task2 {
    private static boolean isPerfect(int value) {
        int sumOfDivisors = 0;
        for (Integer divisor : getDivisors(value)) {
            sumOfDivisors += divisor;
        }
        return sumOfDivisors == value;
    }

    private static int[] getDivisors(int value) {
        int size = 5;
        int[] divisors = new int[size];
        int currentIndex = 0;
        for (int i = 1; i < (value / 2) + 1; ++i) {
            if (value % i == 0) {
                if (currentIndex == divisors.length) {
                    size *= 2;
                    int[] tmp = new int[size];
                    System.arraycopy(divisors, 0, tmp, 0, divisors.length);
                    divisors = tmp;
                }
                divisors[currentIndex] = i;
                currentIndex++;
            }
        }
        return divisors;
    }

    private static int[] getPerfectNumsInRange(int endRange) {
        int size = 5;
        int[] perfectNums = new int[size];
        int currentIndex = 0;
        for (int i = 2; i < endRange; ++i) {
            if (isPerfect(i)) {
                if (currentIndex == perfectNums.length) {
                    size *= 2;
                    int[] tmp = new int[size];
                    System.arraycopy(perfectNums, 0, tmp, 0, perfectNums.length);
                    perfectNums = tmp;
                }
                perfectNums[currentIndex] = i;
                currentIndex++;
            }
        }
        return perfectNums;
    }

    private static void printPerfectNumbers(int endRange) {
        System.out.println("The perfect numbers in range from 0 to " + endRange + " is :");
        for (int perfectNumber : getPerfectNumsInRange(endRange)) {
            if (perfectNumber != 0) {
                System.out.print(perfectNumber + " ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the end of the range:");
        Scanner input = new Scanner(System.in);
        int endRange = input.nextInt();
        printPerfectNumbers(endRange);
    }
}