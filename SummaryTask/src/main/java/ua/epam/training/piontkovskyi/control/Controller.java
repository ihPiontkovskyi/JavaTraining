package ua.epam.training.piontkovskyi.control;

import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.model.entity.CarPark;
import ua.epam.training.piontkovskyi.util.Constants;
import ua.epam.training.piontkovskyi.util.Converter;
import ua.epam.training.piontkovskyi.view.InputHandler;
import ua.epam.training.piontkovskyi.view.View;

public class Controller {

    private View view;
    private CarPark taxiPool;
    private InputHandler inputHandler;

    public Controller() {
        view = new View();
        taxiPool = new CarPark();
        inputHandler = new InputHandler(view);
    }

    public void run() {
        int command = 6;//for printing commands list
        while (command != 5) {
            switch (command) {
                case 1:
                    view.print(String.format(Constants.TOTAL_PRICE_MESSAGE, taxiPool.calculateCarsCost()));
                    break;
                case 2:
                    if (checkParkingInNotEmpty()) continue;
                    view.print(Converter.convertListOfCars(taxiPool.sortByFuelEconomy()));
                    break;
                case 3:
                    if (checkParkingInNotEmpty()) continue;
                    findCars();
                    break;
                case 4:
                    view.print(Converter.convertListOfCars(taxiPool.getCars()));
                    break;
                case 6:
                    view.print(Constants.ALL_COMMANDS_MESSAGE);
                    break;
                default:
                    view.print(Constants.WRONG_COMMAND_MESSAGE);
                    break;
            }
            view.print(Constants.ENTER_COMMAND_MESSAGE);
            command = inputHandler.inputInt();
        }
    }

    private boolean checkParkingInNotEmpty() {
        if (taxiPool.getCars().isEmpty()) {
            view.print(Constants.LIST_EMPTY_MESSAGE);
            return true;
        }
        return false;
    }

    private void findCars() {
        view.print(Constants.ENTER_COMPANY_MESSAGE);

        try {
            Manufacturer manufacturer = Manufacturer.valueOf(inputHandler.inputString().toUpperCase());
            view.print(Constants.ENTER_START_RANGE_MESSAGE);
            int start = inputHandler.inputInt();
            view.print(Constants.ENTER_END_RANGE_MESSAGE);
            int end = inputHandler.inputInt();
            view.print(Converter.convertListOfCars(taxiPool.searchBySpeed(manufacturer, start, end)));
        } catch (IllegalArgumentException ex) {
            view.print(Constants.NO_SUCH_COMPANY_MESSAGE);
        }
    }
}

