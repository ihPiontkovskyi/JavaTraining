package com.bank.controller;

import com.bank.domain.User;
import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;
import com.bank.view.View;

import static com.bank.utility.Constants.ALL_COMMANDS_MESSAGE;
import static com.bank.utility.Constants.ALL_USER_COMMANDS_MESSAGE;
import static com.bank.utility.Constants.ENTER_COMMAND_MESSAGE;
import static com.bank.utility.Constants.ENTER_EMAIL_MESSAGE;
import static com.bank.utility.Constants.ENTER_ID_MESSAGE;
import static com.bank.utility.Constants.ENTER_PASSWORD_MESSAGE;
import static com.bank.utility.Constants.LOGOUT_MESSAGE;
import static com.bank.utility.Constants.SUCCESSFUL_LOGIN_MESSAGE;
import static com.bank.utility.Constants.SUCCESSFUL_REGISTER_MESSAGE;
import static com.bank.utility.Constants.UNSUCCESSFUL_LOGIN_MESSAGE;
import static com.bank.utility.Constants.UNSUCCESSFUL_REGISTER_MESSAGE;
import static com.bank.utility.Constants.WRONG_COMMAND_MESSAGE;

public class Controller {
    private View view;
    private UserService service;

    public Controller(ApplicationInjector injector) {
        view = new View();
        service = injector.getUserService();
    }

    public void run() {
        int command = 4;//for printing commands list
        while (command != 3) {
            switch (command) {
                case 1:
                    if (login()) {
                        handleUser();
                        view.print(ALL_COMMANDS_MESSAGE);
                    } else {
                        view.print(UNSUCCESSFUL_LOGIN_MESSAGE);
                    }
                    break;
                case 2:
                    if (!register()) {
                        view.print(UNSUCCESSFUL_REGISTER_MESSAGE);
                    } else {
                        view.print(SUCCESSFUL_REGISTER_MESSAGE);
                    }
                    break;
                case 3:
                    return;
                case 4:
                    view.print(ALL_COMMANDS_MESSAGE);
                    break;
                case 5:
                    view.changeLocale();
                    view.print(ALL_COMMANDS_MESSAGE);
                    break;
                default:
                    view.print(WRONG_COMMAND_MESSAGE);
                    break;
            }
            view.print(ENTER_COMMAND_MESSAGE);
            command = view.getInputHandler().inputInt();
        }
    }

    private void handleUser() {
        view.print(SUCCESSFUL_LOGIN_MESSAGE);
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
                    view.print(LOGOUT_MESSAGE);
                    return;
                case 5:
                    view.changeLocale();
                    view.print(ALL_USER_COMMANDS_MESSAGE);
                    break;
                default:
                    view.print(WRONG_COMMAND_MESSAGE);
                    break;
            }
            view.print(ENTER_COMMAND_MESSAGE);
            command = view.getInputHandler().inputInt();
        }
    }

    private boolean login() {
        view.print(ENTER_EMAIL_MESSAGE);
        String email = view.getInputHandler().inputString();
        view.print(ENTER_PASSWORD_MESSAGE);
        String pass = view.getInputHandler().inputString();
        return service.login(email, pass);
    }

    private boolean register() {
        view.print(ENTER_EMAIL_MESSAGE);
        String email = view.getInputHandler().inputString();
        view.print(ENTER_PASSWORD_MESSAGE);
        String pass = view.getInputHandler().inputString();
        view.print(ENTER_ID_MESSAGE);
        Integer id = view.getInputHandler().inputInt();
        return service.register(User.builder().withEmail(email).withPassword(pass).withId(id).build());
    }

    private void findById() {
        view.print(ENTER_ID_MESSAGE);
        Integer id = view.getInputHandler().inputInt();
        view.print(service.findById(id).toString());
    }

    private void findByEmail() {
        view.print(ENTER_EMAIL_MESSAGE);
        String email = view.getInputHandler().inputString();
        view.print(service.findByEmail(email).toString());
    }

    private void findAll() {
        view.print(service.findAll().toString());
    }

}

