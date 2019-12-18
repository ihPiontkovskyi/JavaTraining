package ua.epam.training.piontkovskyi.task3_1.util;

import ua.epam.training.piontkovskyi.task3_1.model.toys.Toy;

import java.util.List;

public class ConverterInString {
    public static String convertListOfToys(List<? extends Toy> toys) {
        String result = "";
        for (Toy elem : toys) {
            result += elem.toString() + "\n";
        }
        return result;
    }
}