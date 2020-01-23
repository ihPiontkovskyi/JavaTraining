package com.bank.view;

import com.bank.utility.Constants;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandler {

    private static Scanner sc = new Scanner(System.in);
    private View view;

    public InputHandler(View view) {
        this.view = view;
    }

    public String inputString() {
        return sc.nextLine().trim();
    }

    public Integer inputInt() {
        while (true) {
            String receivedString = sc.nextLine().trim();
            if (!isInteger(receivedString)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return Integer.parseInt(receivedString);
            }
        }
    }

    private boolean isInteger(String s) {
        return Pattern.matches("[0-9]+", s);
    }
}