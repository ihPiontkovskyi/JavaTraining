package ua.epam.training.piontkovskyi.task2_2.view;

import ua.epam.training.piontkovskyi.task2_2.util.Constants;

import java.util.Scanner;

public class InputHandler {

    private static Scanner sc = new Scanner(System.in);
    private View view;

    public InputHandler(View view) {
        this.view = view;
    }

    public Integer inputInt() {
        String receivedString = sc.next();
        if (!isInteger(receivedString)) {
            view.print(Constants.WRONG_INPUT);
            return 0;
        }
        return Integer.parseInt(receivedString);
    }

    private boolean isInteger(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
