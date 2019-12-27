package ua.epam.training.piontkovskyi.task2_1.view;

import ua.epam.training.piontkovskyi.task2_1.model.Shape;

public class View {
    public void printAllCommands() {
        System.out.println("Command:\n1.Print all\n" +
                "2.Calculate sum of all areas\n" +
                "3.Calculate sum of circle areas\n" +
                "4.Calculate sum of triangle areas\n" +
                "5.Calculate sum of rectangle areas\n" +
                "6.Sort in ascending order of color\n" +
                "7.Sort in ascending order of area\n" +
                "8.Exit");
    }

    public void printWrongCommand() {
        System.out.println("Wrong command, try again");
    }

    public void printList(String[] items) {
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    public void printSumArea(double sum) {
        System.out.printf("The sum of the area of all shapes: %.2f\n", sum);
    }

    public void printSumArea(double sum, Class<? extends Shape> type) {
        System.out.printf("The sum of the area of %s shapes: %.2f\n", type.getSimpleName(), sum);
    }
}
