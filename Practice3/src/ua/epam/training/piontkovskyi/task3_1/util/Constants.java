package ua.epam.training.piontkovskyi.task3_1.util;

public class Constants {
    public static String WRONG_INPUT_MESSAGE = "Wrong input, try again ->";

    public static String WRONG_COMMAND_MESSAGE = "There is no such command\n";

    public static String SELECT_TOY_TYPE_MESSAGE = "Select toy type:\n1.Car\n2.Lego\n3.Puzzle\n";
    public static String SELECT_TOY_EXTEND_CAR_MESSAGE = "Select toy type:\n1.Car";
    public static String SELECT_TOY_EXTEND_PUZZLE_MESSAGE = "Select toy type:\n1.Puzzle";
    public static String SELECT_TOY_EXTEND_LEGO_MESSAGE = "Select toy type:\n1.Lego";

    public static String INIT_PLAYROOM_MESSAGE = "Select playroom type:\n1.Car\n2.Lego\n3.Puzzle\n4.Toy\n5.Exit\n";

    public static String ERROR_ADD_MESSAGE = "This type of toys cannot be added to the %s game room";

    public static String ALL_COMMANDS_MESSAGE =
            "Command:\n" +
                    "1.Add toy\n" +
                    "2.Sort toys by parameter\n" +
                    "3.Calculate the total cost of all toys\n" +
                    "4.Identify toys that fit parameter range\n" +
                    "5.Print all toys\n" +
                    "6.Exit\n";

    public static final String ENTER_COMMAND_MESSAGE = "Enter command number -> ";

    public static final String FILTER_MESSAGE = "Enter a value or leave it blank to ignore the criterion\n";

    public static final String ENTER_NAME_MESSAGE = "Enter toy name -> ";
    public static final String ENTER_COUNTRY_MESSAGE = "Enter toy country of production -> ";
    public static final String ENTER_MATERIAL_MESSAGE = "Enter toy material -> ";
    public static final String ENTER_PRICE_MESSAGE = "Enter toy price ->";
    public static final String ENTER_AGE_LIMIT_MESSAGE = "Enter toy age limit - >";
    public static final String ENTER_NUMBER_OF_PARTS_MESSAGE = "Enter lego number of parts -> ";
    public static final String ENTER_NUMBER_OF_PUZZLES_MESSAGE = "Enter puzzle number  -> ";

    public static final String LIST_EMPTY_MESSAGE = "List is empty\n";
    public static final String CHOOSE_CRITERION_MESSAGE =
            "Choose criterion for sorting:\n" +
                    "1.Country of production\n" +
                    "2.Price\n" +
                    "3.Age limit\n" +
                    "4.Name\n" +
                    "5.Material\n";
}
