package ua.epam.training.piontkovskyi.task2_2.control;

import ua.epam.training.piontkovskyi.task2_2.model.DataStorage;
import ua.epam.training.piontkovskyi.task2_2.view.View;

import java.util.Random;
import java.util.Scanner;

public class Controller {
    private View view;
    private DataStorage dataStorage;

    public Controller() {
        view = new View();
        dataStorage = new DataStorage();
    }

    public void run() {
        view.printAll(dataStorage.getBookList());
        int commandNumber;
        Scanner input = new Scanner(System.in);
        while (true) {
            view.printAllCommands();
            commandNumber = input.nextInt();
            if (commandNumber == 6) {
                break;
            }
            handleCommand(commandNumber);
        }
    }


    public void handleCommand(int command) {
        switch (command) {
            case 1:
                String randomAuthor = dataStorage.getRandomAuthor();
                view.printMessage("Books by " + randomAuthor + ":");
                view.printAll(dataStorage.getBookListByAuthor(randomAuthor));
                break;
            case 2:
                String randomPublisher = dataStorage.getRandomPublisher();
                view.printMessage("Books published by " + randomPublisher + ":");
                view.printAll(dataStorage.getBookListByPublisher(randomPublisher));
                break;
            case 3:
                int randomYear = new Random().nextInt(2019);
                view.printMessage("Books published after " + randomYear + ":");
                view.printAll(dataStorage.getBookListByPublishYear(randomYear));
                break;
            case 4:
                dataStorage.sortByPublishers();
                break;
            case 5:
                view.printAll(dataStorage.getBookList());
                break;
            default:
                view.printMessage("Wrong command, try again");
        }
    }
}
