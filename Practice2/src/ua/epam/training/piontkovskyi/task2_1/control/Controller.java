package ua.epam.training.piontkovskyi.task2_1.control;

import ua.epam.training.piontkovskyi.task2_1.model.Circle;
import ua.epam.training.piontkovskyi.task2_1.model.DataStorage;
import ua.epam.training.piontkovskyi.task2_1.model.Rectangle;
import ua.epam.training.piontkovskyi.task2_1.model.Triangle;
import ua.epam.training.piontkovskyi.task2_1.view.View;

import java.util.Scanner;

public class Controller {
    private View view;
    private DataStorage dataStorage;


    public Controller() {
        view = new View();
        dataStorage = new DataStorage();
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int commandNumber = 0;
        while (commandNumber != 8) {
            view.printAllCommands();
            commandNumber = input.nextInt();
            handleCommand(commandNumber);
        }
    }

    public void handleCommand(int command) {
        switch (command) {
            case 1:
                view.printList(dataStorage.getShapeList());
                break;
            case 2:
                view.printSumArea(dataStorage.getSumArea());
                break;
            case 3:
                view.printSumArea(dataStorage.getSumArea(Circle.class), Circle.class);
                break;
            case 4:
                view.printSumArea(dataStorage.getSumArea(Triangle.class), Triangle.class);
                break;
            case 5:
                view.printSumArea(dataStorage.getSumArea(Rectangle.class), Rectangle.class);
                break;
            case 6:
                dataStorage.sortByColor();
                view.printList(dataStorage.getShapeList());
                break;
            case 7:
                dataStorage.sortByArea();
                view.printList(dataStorage.getShapeList());
                break;
            default:
                view.printWrongCommand();
        }
    }
}
