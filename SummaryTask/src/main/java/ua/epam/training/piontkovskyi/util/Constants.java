package ua.epam.training.piontkovskyi.util;

public class Constants {

    private Constants(){
        //ignore
    }

    public static String WRONG_INPUT_MESSAGE = "Wrong input, try again ->";

    public static String WRONG_COMMAND_MESSAGE = "There is no such command\n";

    public static String ALL_COMMANDS_MESSAGE =
            "Command:\n" +
                    "1.Calculate the cost of the taxi pool\n" +
                    "2.Sort by fuel consumption\n" +
                    "3.Find a car in a company corresponding to a given range of speed parameters\n" +
                    "4.Print taxi pool\n" +
                    "5.Exit\n" +
                    "6.Show all commands\n" +
                    "7.Open taxi service\n";

    public static String MAKE_ORDER_MESSAGE = "Do you want make order? 1 - Yes 0 - No ->";

    public static final String ENTER_COMMAND_MESSAGE = "Enter command number -> ";

    public static final String ENTER_DISTANCE_MESSAGE = "Enter distance -> ";

    public static final String SELECT_CAR_MESSAGE = "Select car -> ";

    public static final String ORDER_CAR_MESSAGE = "Wait for car, total price: %.2f\n";

    public static final String ENTER_START_RANGE_MESSAGE = "Enter start of max speed range -> ";

    public static final String ENTER_END_RANGE_MESSAGE = "Enter end of max speed range -> ";

    public static final String LIST_EMPTY_MESSAGE = "Taxi pool is empty\n";

    public static final String TOTAL_PRICE_MESSAGE = "Total price of taxi pool -> %d\n";

    public static final String ENTER_COMPANY_MESSAGE = "Enter the company where you want to search for cars -> ";

    public static final String NO_SUCH_COMPANY_MESSAGE = "There isn`t such company\n";
    public static final String NO_SUCH_CAR_MESSAGE = "There isn`t such car\n";

    public static final String NOT_AVAILABLE_CAR_MESSAGE = "There isn`t available taxi\n";
}
