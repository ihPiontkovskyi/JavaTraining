package com.bank.view;

import com.bank.utility.ResourceManager;

import static com.bank.utility.Constants.LOCALE_EN;
import static com.bank.utility.Constants.LOCALE_MESSAGE;
import static com.bank.utility.Constants.LOCALE_RU;

public class View {
    private InputHandler inputHandler;
    private ResourceManager manager;

    public View() {
        inputHandler = new InputHandler(this);
        manager = ResourceManager.getInstance();
    }

    public void print(String key) {
        System.out.println(manager.getString(key));
    }

    public void changeLocale() {
        print(manager.getString(LOCALE_MESSAGE));
        int command = inputHandler.inputInt();
        while (command != 1 && command != 2) {
            command = inputHandler.inputInt();
        }
        if (command == 1) {
            manager.changeResource(LOCALE_EN);
        } else {
            manager.changeResource(LOCALE_RU);
        }
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
}