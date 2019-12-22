package ua.epam.training.piontkovskyi.task3_2.control;

import ua.epam.training.piontkovskyi.task3_2.model.Shop;
import ua.epam.training.piontkovskyi.task3_2.util.Constants;
import ua.epam.training.piontkovskyi.task3_2.util.Converter;
import ua.epam.training.piontkovskyi.task3_2.view.InputHandler;
import ua.epam.training.piontkovskyi.task3_2.view.View;

public class Controller {
    Shop shop;
    View view;
    InputHandler inputHandler;

    public Controller() {
        view = new View();
        inputHandler = new InputHandler(view);
    }

    public void run() {
        initShop();
        while (true) {
            view.print(Constants.ALL_COMMANDS_MESSAGE);
            view.print(Constants.ENTER_COMMAND_MESSAGE);
            int response = inputHandler.inputInt();
            if (response > 6 || response < 0) {
                view.print(Constants.WRONG_COMMAND_MESSAGE);
            } else {
                switch (response) {
                    case 1:
                        addDepartment();
                        break;
                    case 2:
                        removeDepartment();
                        break;
                    case 3:
                        sortDepartments();
                        break;
                    case 4:
                        makeOperation();
                        break;
                    case 5:
                        view.print(shop.toString());
                        break;
                    default:
                        return;
                }
            }
        }
    }

    private void addDepartment() {
        Shop.DepartmentBuilder departmentBuilder = shop.new DepartmentBuilder();
        view.print(Constants.ENTER_NAME_MESSAGE);
        departmentBuilder.withName(inputHandler.inputString());
        view.print(Constants.ENTER_LOCATION_MESSAGE);
        departmentBuilder.withLocation(inputHandler.inputString());
        view.print(Constants.ENTER_PRODUCT_TYPE_MESSAGE);
        departmentBuilder.withProductType(inputHandler.inputString());
        view.print(Constants.ENTER_SERVICE_INFO_MESSAGE);
        while (true) {
            view.print(Constants.ENTER_SERVICE_MESSAGE);
            String service = inputHandler.inputString();
            if (service.equals("")) {
                break;
            }
            departmentBuilder.addService(service);
        }
        departmentBuilder.buildDepartment();
    }

    private void removeDepartment() {
        if (shop.getDepartments().size() > 0) {
            view.print(Converter.convertFromList(shop.getDepartments()));
            view.print(Constants.ENTER_DEPARTMENT_NUMBER_MESSAGE);
            if (!shop.removeDepartment(inputHandler.inputInt())) {
                view.print(Constants.DEPARTMENT_NOT_FOUND_MESSAGE);
            }
        } else {
            view.print(Constants.NO_DEPARTMENT_MESSAGE);
        }
    }

    private void sortDepartments() {
        if (shop.getDepartments().size() > 0) {
            view.print(Constants.ENTER_PARAMETER_MESSAGE);
            shop.sort(inputHandler.inputString());
        } else {
            view.print(Constants.NO_DEPARTMENT_MESSAGE);
        }
    }

    private void initShop() {
        view.print(Constants.ENTER_SHOP_NAME_MESSAGE);
        shop = new Shop(inputHandler.inputString());
    }

    private void makeOperation() {
        if (shop.getDepartments().size() > 0) {
            view.print(Converter.convertFromList(shop.getDepartments()));
            view.print(Constants.ENTER_DEPARTMENT_NUMBER_MESSAGE);
            String result = shop.performOperation(inputHandler.inputInt());
            if (result == null) {
                view.print(Constants.DEPARTMENT_NOT_FOUND_MESSAGE);
            } else {
                view.print(result);
            }
        } else {
            view.print(Constants.NO_DEPARTMENT_MESSAGE);
        }
    }

}
