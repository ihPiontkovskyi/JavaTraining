package ua.epam.training.piontkovskyi.task3_1.control;

import ua.epam.training.piontkovskyi.task3_1.model.Criterion;
import ua.epam.training.piontkovskyi.task3_1.model.RoomType;
import ua.epam.training.piontkovskyi.task3_1.model.ToyRoom;
import ua.epam.training.piontkovskyi.task3_1.model.toys.Car;
import ua.epam.training.piontkovskyi.task3_1.model.toys.Lego;
import ua.epam.training.piontkovskyi.task3_1.model.toys.Puzzle;
import ua.epam.training.piontkovskyi.task3_1.model.toys.Toy;
import ua.epam.training.piontkovskyi.task3_1.util.Constants;
import ua.epam.training.piontkovskyi.task3_1.util.ConverterInString;
import ua.epam.training.piontkovskyi.task3_1.view.InputHandler;
import ua.epam.training.piontkovskyi.task3_1.view.View;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    View view;
    InputHandler inputHandler;
    ToyRoom<? extends Toy> room;
    RoomType toyRoomType;

    public Controller() {
        view = new View();
        inputHandler = new InputHandler(view);
    }

    public void run() {
        if (handleInit()) {
            handleRoom();
        }
    }

    private void handleRoom() {
        while (true) {
            view.print(Constants.ALL_COMMANDS_MESSAGE);
            view.print(Constants.ENTER_COMMAND_MESSAGE);
            int response = inputHandler.inputInt();
            if (response > 6 || response < 0) {
                view.print(Constants.WRONG_COMMAND_MESSAGE);
            } else {
                if (response != 1 && response != 6 && room.getToysList().isEmpty()) {
                    view.print(Constants.LIST_EMPTY_MESSAGE);
                    continue;
                }
                switch (response) {
                    case 1:
                        addToy();
                        break;
                    case 2:
                        sortByCriterion();
                        break;
                    case 3:
                        view.print(String.format("The total price = %.2f\n", room.getTotalCost()));
                        break;
                    case 4:
                        Map<Criterion, String> filters = getFilters();
                        view.print(ConverterInString.convertListOfToys(room.getSubList(filters)));
                        break;
                    case 5:
                        view.print(ConverterInString.convertListOfToys(room.getToysList()));
                        break;
                    default:
                        return;
                }
            }
        }
    }

    private boolean handleInit() {
        while (true) {
            view.print(Constants.INIT_PLAYROOM_MESSAGE);
            view.print(Constants.ENTER_COMMAND_MESSAGE);
            int response = inputHandler.inputInt();
            if (response > 5 || response < 0) {
                view.print(Constants.WRONG_COMMAND_MESSAGE);
            } else {
                switch (response) {
                    case 1:
                        room = new ToyRoom<Car>();
                        toyRoomType = RoomType.CAR;
                        return true;
                    case 2:
                        room = new ToyRoom<Lego>();
                        toyRoomType = RoomType.LEGO;
                        return true;
                    case 3:
                        room = new ToyRoom<Puzzle>();
                        toyRoomType = RoomType.PUZZLE;
                        return true;
                    case 4:
                        room = new ToyRoom<>();
                        toyRoomType = RoomType.TOY;
                        return true;
                    default:
                        return false;
                }
            }
        }
    }

    private void addToy() {
        switch (toyRoomType) {
            case CAR:
                createAndAddCar();
                break;
            case PUZZLE:
                createAndAddPuzzle();
                break;
            case LEGO:
                createAndAddLego();
                break;
            case TOY:
                view.print(Constants.SELECT_TOY_TYPE_MESSAGE);
                view.print(Constants.ENTER_COMMAND_MESSAGE);
                int response = inputHandler.inputInt();
                if (response > 3 || response < 0) {
                    view.print(Constants.WRONG_COMMAND_MESSAGE);
                } else {
                    switch (response) {
                        case 1:
                            createAndAddCar();
                            break;
                        case 2:
                            createAndAddPuzzle();
                            break;
                        case 3:
                            createAndAddLego();
                            break;
                    }
                }
                break;
        }
    }

    private void createToy(Toy.BaseBuilder builder) {
        view.print(Constants.ENTER_NAME_MESSAGE);
        builder.withName(inputHandler.inputString());
        view.print(Constants.ENTER_COUNTRY_MESSAGE);
        builder.withCountry(inputHandler.inputString());
        view.print(Constants.ENTER_MATERIAL_MESSAGE);
        builder.withMaterial(inputHandler.inputString());
        view.print(Constants.ENTER_PRICE_MESSAGE);
        builder.withPrice(inputHandler.inputDouble());
        view.print(Constants.ENTER_AGE_LIMIT_MESSAGE);
        builder.withAgeLimit(inputHandler.inputInt());
    }

    private void createAndAddCar() {
        Car.Builder carBuilder = new Car.Builder();
        createToy(carBuilder);
        room.addToy(carBuilder.build());
    }

    private void createAndAddLego() {
        Lego.Builder legoBuilder = new Lego.Builder();
        createToy(legoBuilder);
        view.print(Constants.ENTER_NUMBER_OF_PARTS_MESSAGE);
        legoBuilder.withNumberOfParts(inputHandler.inputInt());
        room.addToy(legoBuilder.build());
    }

    private void createAndAddPuzzle() {
        Puzzle.Builder puzzleBuilder = new Puzzle.Builder();
        createToy(puzzleBuilder);
        view.print(Constants.ENTER_NUMBER_OF_PUZZLES_MESSAGE);
        puzzleBuilder.withNumberOfPuzzles(inputHandler.inputInt());
        room.addToy(puzzleBuilder.build());
    }

    private void sortByCriterion() {
        view.print(Constants.CHOOSE_CRITERION_MESSAGE);
        view.print(Constants.ENTER_COMMAND_MESSAGE);
        int response = inputHandler.inputInt();
        if (response > 5 || response < 0) {
            view.print(Constants.WRONG_COMMAND_MESSAGE);
        } else {
            switch (response) {
                case 1:
                    view.print(ConverterInString.convertListOfToys(room.sort(Criterion.COUNTRY)));
                    break;
                case 2:

                    view.print(ConverterInString.convertListOfToys(room.sort(Criterion.PRICE)));
                    break;
                case 3:
                    view.print(ConverterInString.convertListOfToys(room.sort(Criterion.AGE_LIMIT)));
                    break;
                case 4:
                    view.print(ConverterInString.convertListOfToys(room.sort(Criterion.NAME)));
                    break;
                case 5:
                    view.print(ConverterInString.convertListOfToys(room.sort(Criterion.MATERIAL)));
            }
            view.print(ConverterInString.convertListOfToys(room.getToysList()));
        }
    }

    private Map<Criterion, String> getFilters() {
        Map<Criterion, String> filters = new HashMap<>();
        view.print(Constants.FILTER_MESSAGE);
        view.print(Constants.ENTER_NAME_MESSAGE);
        filters.put(Criterion.NAME, inputHandler.inputString());
        view.print(Constants.ENTER_COUNTRY_MESSAGE);
        filters.put(Criterion.COUNTRY, inputHandler.inputString());
        view.print(Constants.ENTER_MATERIAL_MESSAGE);
        filters.put(Criterion.MATERIAL, inputHandler.inputString());

        view.print(Constants.ENTER_PRICE_MESSAGE);
        filters.put(Criterion.PRICE, inputHandler.inputDoubleFilter());
        view.print(Constants.ENTER_AGE_LIMIT_MESSAGE);
        filters.put(Criterion.AGE_LIMIT, inputHandler.inputIntFilter());
        switch (toyRoomType) {
            case LEGO:
                view.print(Constants.ENTER_NUMBER_OF_PARTS_MESSAGE);
                filters.put(Criterion.NUMBER_OF_PARTS, inputHandler.inputIntFilter());
                break;
            case PUZZLE:
                view.print(Constants.ENTER_NUMBER_OF_PUZZLES_MESSAGE);
                filters.put(Criterion.NUMBER_OF_PUZZLES, inputHandler.inputIntFilter());
                break;
        }
        return filters;
    }

}

