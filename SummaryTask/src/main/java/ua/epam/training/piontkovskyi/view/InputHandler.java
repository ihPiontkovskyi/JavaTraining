package ua.epam.training.piontkovskyi.view;

import ua.epam.training.piontkovskyi.util.Constants;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandler {

    private static final String INTEGER_REGEX = "\\d+";
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
            if (!receivedString.matches(INTEGER_REGEX)) {//
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return Integer.parseInt(receivedString);
            }
        }
    }
}