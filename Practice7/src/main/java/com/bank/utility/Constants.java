package com.bank.utility;

import java.util.Locale;

public class Constants {
    private Constants() {
    }

    public static final String WRONG_INPUT_MESSAGE = "wrong.input.message";
    public static final String WRONG_COMMAND_MESSAGE = "wrong.command.message";
    public static final String UNSUCCESSFUL_LOGIN_MESSAGE = "unsuccessful.login.message";
    public static final String UNSUCCESSFUL_REGISTER_MESSAGE = "unsuccessful.register.message";
    public static final String SUCCESSFUL_LOGIN_MESSAGE = "successful.login.message";
    public static final String SUCCESSFUL_REGISTER_MESSAGE = "successful.register.message";
    public static final String ALL_COMMANDS_MESSAGE = "all.commands.message";
    public static final String ALL_USER_COMMANDS_MESSAGE = "all.user.commands.message";
    public static final String ENTER_COMMAND_MESSAGE = "enter.command.message";
    public static final String ENTER_ID_MESSAGE = "enter.id.message";
    public static final String ENTER_EMAIL_MESSAGE = "enter.email.message";
    public static final String ENTER_PASSWORD_MESSAGE = "enter.password.message";
    public static final String LOGOUT_MESSAGE = "logout.message";
    public static final String LOCALE_MESSAGE = "locale.message";
    public static final Locale LOCALE_RU = new Locale("ru", "RU");
    public static final Locale LOCALE_EN = Locale.forLanguageTag("EN");
}
