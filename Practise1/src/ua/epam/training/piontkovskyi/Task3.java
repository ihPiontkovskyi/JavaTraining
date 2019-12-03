package ua.epam.training.piontkovskyi;

import java.util.Scanner;

public class Task3 {

    private static void printTriangle(int value) {

        for (int i = 1; i <= value; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int k = (i - 1); k >= 1; k--) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of lines: ");
        Scanner input = new Scanner(System.in);
        int linesNumber = input.nextInt();
        if (linesNumber > 9 || linesNumber < 1) {
            System.err.println("Number must be in range [1,9]");
        } else {
            printTriangle(linesNumber);
        }
    }
}
