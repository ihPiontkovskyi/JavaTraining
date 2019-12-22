package ua.epam.training.piontkovskyi.task3_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        for (DaysOfWeek day : DaysOfWeek.values()) {
            if (day.equals(DaysOfWeek.valueOf("FRIDAY")) ||
                    day.equals(DaysOfWeek.valueOf("MONDAY")) ||
                    day.equals(DaysOfWeek.valueOf("WEDNESDAY"))) {
                System.out.println(day);
            }

        }
        System.out.println("-----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day of week -> ");
        System.out.println("Next day -> " + DaysOfWeek.valueOf(scanner.next().toUpperCase()).nextDay());

    }
}