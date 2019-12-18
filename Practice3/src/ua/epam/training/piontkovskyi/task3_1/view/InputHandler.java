package ua.epam.training.piontkovskyi.task3_1.view;

import ua.epam.training.piontkovskyi.task3_1.util.Constants;

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

    public Double inputDouble() {
        while (true) {
            String receivedString = sc.nextLine().trim();
            if (!isDouble(receivedString)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return Double.parseDouble(receivedString);
            }
        }
    }

    public String inputDoubleFilter() {
        while (true) {
            String receivedString = sc.nextLine().trim();
            if (!receivedString.equals("") && !isDoubleFilter(receivedString)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return receivedString;
            }
        }
    }

    public String inputIntFilter() {
        while (true) {
            String receivedString = sc.nextLine().trim();
            if (!receivedString.equals("") && !isIntegerFilter(receivedString)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return receivedString;
            }
        }
    }

    private boolean isDouble(String s) {
        return Pattern.matches("[0-9]+.[0-9]*", s);
    }

    private boolean isDoubleFilter(String s) {
        return Pattern.matches("[0-9]+.[0-9]*", s) || Pattern.matches("[0-9]+.[0-9]* [0-9]+.[0-9]*", s);
    }

    private boolean isInteger(String s) {
        return Pattern.matches("[0-9]+", s);
    }

    private boolean isIntegerFilter(String s) {
        return Pattern.matches("[0-9]+", s) || Pattern.matches("[0-9]+ [0-9]+", s);
    }
}