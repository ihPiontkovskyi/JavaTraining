package ua.epam.training.piontkovskyi.task3_2.util;

import java.util.List;

public class Converter {
    public static <T> String convertFromList(List<T> list) {
        String result = "";
        int i = 1;
        for (T obj : list) {
            result += String.format("%d.%s\n", i++, obj.toString());
        }
        return result;
    }
}
