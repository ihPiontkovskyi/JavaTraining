package ua.epam.training.piontkovskyi;

import java.util.Random;

public class Task1 {

    private static String fromDecToBin(int value) {
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            result.insert(0, value % 2);
            value /= 2;
        }
        return result.toString();
    }

    private static String fromDecToOct(int value) {
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            result.insert(0, value % 8);
            value /= 8;
        }
        return result.toString();
    }

    private static String fromDecToHex(int value) {
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            int tmp = value % 16;
            if (tmp < 10) {
                result.insert(0, (char) (tmp + 48));
                value /= 16;
            } else {
                result.insert(0, (char) (tmp + 55));
                value /= 16;
            }
        }
        return result.toString();
    }

    private static void printNumber(int number) {
        System.out.print("Decimal " + number + " in binary representation: ");
        System.out.println(fromDecToBin(number));
        System.out.print("Decimal " + number + " in octal representation: ");
        System.out.println(fromDecToOct(number));
        System.out.print("Decimal " + number + " in hexadecimal representation: ");
        System.out.println(fromDecToHex(number));
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        printNumber(rnd.nextInt(100));
    }
}
