package ua.epam.training.piontkovskyi.task2_2.view;

import ua.epam.training.piontkovskyi.task2_2.model.Book;

public class View {
    public void printAllCommands() {
        System.out.println("Command:\n1. Get a list of books by a specified author\n" +
                "2.Get a list of books that are published specified publisher\n" +
                "3. Get a list of books published later of the specified year\n" +
                "4. Sort books by publishers\n" +
                "5.Print all\n" +
                "6.Exit\n");
    }

    public void printAll(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
