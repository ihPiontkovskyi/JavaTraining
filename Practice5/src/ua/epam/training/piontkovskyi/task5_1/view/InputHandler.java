package ua.epam.training.piontkovskyi.task5_1.view;

import ua.epam.training.piontkovskyi.task5_1.util.Constants;

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
            if (!Pattern.matches("\\d+", receivedString)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return Integer.parseInt(receivedString);
            }
        }
    }

    public String inputName() {
        while (true) {
            String name = inputString();
            if (!Pattern.matches("^[A-Z]\\w{2,}$", name)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return name;
            }
        }
    }

    public String inputPhone() {
        while (true) {
            String phone = inputString();
            if (!Pattern.matches("^[+]\\d{1,3}(\\s+?|-?)([(][0-9]{2}[)]|[0-9]{2})(\\s+?|-?)\\d{3}(\\s?|-?)\\d{2}(\\s+?|-)?\\d{2}$", phone)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return phone;
            }
        }
    }

    public String inputDate() {
        while (true) {
            String date = inputString();
            if (!Pattern.matches("^\\d{1,2}([/.])\\d{1,2}([/.])(\\d{4}|\\d{2})$", date)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return date;
            }
        }
    }

    public String inputAddress() {
        while (true) {
            String address = inputString();
            if (!Pattern.matches("^\\w{3,}(\\s+|,)\\d+(-)\\d+", address)) {
                view.print(Constants.WRONG_INPUT_MESSAGE);
            } else {
                return address;
            }
        }
    }
}
