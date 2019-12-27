package ua.epam.training.piontkovskyi.task2_2.util;

import ua.epam.training.piontkovskyi.task2_2.model.Book;

public class ConverterInString {
    public static String convertArrayOfBooks(Book[] books) {
        String result = "";
        for (Book elem : books) {
            result += elem.toString();
        }
        return result;
    }
}
