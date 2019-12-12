package ua.epam.training.piontkovskyi.task2_2.control;

import ua.epam.training.piontkovskyi.task2_2.model.DataSource;
import ua.epam.training.piontkovskyi.task2_2.model.DataStorage;
import ua.epam.training.piontkovskyi.task2_2.util.Constants;
import ua.epam.training.piontkovskyi.task2_2.util.ConverterInString;
import ua.epam.training.piontkovskyi.task2_2.view.InputHandler;
import ua.epam.training.piontkovskyi.task2_2.view.View;

import java.util.Random;

public class Controller {
    private View view;
    private DataStorage dataStorage;
    InputHandler inputHandler;
    Random rnd = new Random();

    public Controller() {
        view = new View();
        dataStorage = new DataStorage();
        inputHandler = new InputHandler(view);
    }

    public void run() {
        view.print(ConverterInString.convertArrayOfBooks(dataStorage.getBooks()));
        int commandNumber;
        while (true) {
            view.print(Constants.ALL_COMMANDS);
            commandNumber = inputHandler.inputInt();
            if (commandNumber == 5) {
                break;
            }
            if (commandNumber < 0 || commandNumber > 5) {
                view.print(Constants.WRONG_COMMAND);
            }
            handleCommand(commandNumber);
        }
    }


    public void handleCommand(int command) {
        switch (command) {
            case 1:
                String randomAuthor = DataSource.AUTHORS_NAME[rnd.nextInt(DataSource.AUTHORS_NAME.length)];
                view.print("Books by " + randomAuthor);
                view.print(ConverterInString.convertArrayOfBooks(dataStorage.getBookListByAuthor(randomAuthor)));
                break;
            case 2:
                String randomPublisher = DataSource.PUBLISHERS[rnd.nextInt(DataSource.PUBLISHERS.length)];
                view.print("Books published by " + randomPublisher);
                view.print(ConverterInString.convertArrayOfBooks(dataStorage.getBookListByPublisher(randomPublisher)));
                break;
            case 3:
                view.print("Enter year :");
                int year = inputHandler.inputInt();
                view.print(ConverterInString.convertArrayOfBooks(dataStorage.getBookListByPublishYear(year)));
                break;
            case 4:
                view.print(ConverterInString.convertArrayOfBooks(dataStorage.sortByPublishers()));
                break;
        }
    }
}
