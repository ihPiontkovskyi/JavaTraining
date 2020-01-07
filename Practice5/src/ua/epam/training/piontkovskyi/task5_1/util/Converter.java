package ua.epam.training.piontkovskyi.task5_1.util;

import ua.epam.training.piontkovskyi.task5_1.model.Record;

import java.util.List;

public class Converter {
    private Converter() {
    }

    public static String convertListOfToys(List<? extends Record> records) {
        String result = "";
        if (records.isEmpty()) {
            return "List is empty\n";
        }
        for (Record elem : records) {
            result += elem.toString() + "\n";
        }
        return result;
    }
}
