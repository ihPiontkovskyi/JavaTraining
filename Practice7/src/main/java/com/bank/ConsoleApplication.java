package com.bank;

import com.bank.controller.Controller;
import com.bank.injector.ApplicationInjector;

public class ConsoleApplication {
    public static void main(String[] args) {
        new Controller(ApplicationInjector.getInstance()).run();
    }
}