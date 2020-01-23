package com.bank.controller;

import com.bank.domain.User;
import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;
import com.bank.utility.Constants;
import com.bank.view.InputHandler;
import com.bank.view.View;

public class Controller {
    View view;
    InputHandler inputHandler;
    UserService service;

    public Controller(ApplicationInjector injector) {
        view = new View();
        inputHandler = new InputHandler(view);
        service = injector.getUserService();
    }

    public void run() {
        int command = 4;//for printing commands list
        while (command != 3) {
            switch (command) {
                case 1:
                    if (login()) {
                        handleUser();
                        view.print(Constants.ALL_COMMANDS_MESSAGE);
                    } else {
                        view.print(Constants.UNSUCCESSFUL_LOGIN_MESSAGE);
                    }
                    break;
                case 2:
                    if (!register()) {
                        view.print(Constants.UNSUCCESSFUL_REGISTER_MESSAGE);
                    } else {
                        view.print(Constants.SUCCESSFUL_REGISTER_MESSAGE);
                    }
                    break;
                case 3:
                    return;
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

    private void handleUser() {
        view.print(Constants.SUCCESSFUL_LOGIN_MESSAGE);
        int command = 5;//for printing commands list
        while (command != 4) {
            switch (command) {
                case 1:
                    findByEmail();
                    break;
                case 2:
                    findById();
                    break;
                case 3:
                    findAll();
                    break;
                case 4:
                    view.print(Constants.LOGOUT_MESSAGE);
                    return;
                case 5:
                    view.print(Constants.ALL_USER_COMMANDS_MESSAGE);
                    break;
                default:
                    view.print(Constants.WRONG_COMMAND_MESSAGE);
                    break;
            }
            view.print(Constants.ENTER_COMMAND_MESSAGE);
            command = inputHandler.inputInt();
        }
    }

    private boolean login() {
        view.print(Constants.ENTER_EMAIL_MESSAGE);
        String email = inputHandler.inputString();
        view.print(Constants.ENTER_PASSWORD_MESSAGE);
        String pass = inputHandler.inputString();
        return service.login(email, pass);
    }

    private boolean register() {
        view.print(Constants.ENTER_EMAIL_MESSAGE);
        String email = inputHandler.inputString();
        view.print(Constants.ENTER_PASSWORD_MESSAGE);
        String pass = inputHandler.inputString();
        view.print(Constants.ENTER_ID_MESSAGE);
        Integer id = inputHandler.inputInt();
        return service.register(User.builder().withEmail(email).withPassword(pass).withId(id).build());
    }

    private void findById() {
        view.print(Constants.ENTER_ID_MESSAGE);
        Integer id = inputHandler.inputInt();
        view.println(service.findById(id).toString());
    }

    private void findByEmail() {
        view.print(Constants.ENTER_EMAIL_MESSAGE);
        String email = inputHandler.inputString();
        view.println(service.findByEmail(email).toString());
    }

    private void findAll() {
        view.println(service.findAll().toString());
    }
}

