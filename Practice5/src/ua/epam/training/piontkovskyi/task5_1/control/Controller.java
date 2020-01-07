package ua.epam.training.piontkovskyi.task5_1.control;

import ua.epam.training.piontkovskyi.task5_1.model.CuratorJournal;
import ua.epam.training.piontkovskyi.task5_1.model.RecordBuilder;
import ua.epam.training.piontkovskyi.task5_1.util.Constants;
import ua.epam.training.piontkovskyi.task5_1.util.Converter;
import ua.epam.training.piontkovskyi.task5_1.view.InputHandler;
import ua.epam.training.piontkovskyi.task5_1.view.View;

public class Controller {
    private InputHandler inputHandler;
    private View view;
    private CuratorJournal journal = new CuratorJournal();

    public Controller() {
        view = new View();
        inputHandler = new InputHandler(view);
    }

    public void run() {
        int command = 4;//for printing commands list
        while (command != 3) {
            switch (command) {
                case 1:
                    addName();
                    break;
                case 2:
                    view.print(Converter.convertListOfToys(journal.getRecordList()));
                    break;
                case 4:
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

    private void addName() {
        RecordBuilder builder = new RecordBuilder();
        view.print(Constants.ENTER_FIRST_NAME_MESSAGE);
        builder.withFirstName(inputHandler.inputName());
        view.print(Constants.ENTER_LAST_NAME_MESSAGE);
        builder.withLastName(inputHandler.inputName());
        view.print(Constants.ENTER_DATE_OF_BIRTH_MESSAGE);
        builder.withDateOfBirth(inputHandler.inputDate());
        view.print(Constants.ENTER_ADDRESS_MESSAGE);
        builder.withAddress(inputHandler.inputAddress());
        view.print(Constants.ENTER_PHONE_NUMBER_MESSAGE);
        builder.withPhoneNumber(inputHandler.inputPhone());
        journal.add(builder.build());
    }
}
