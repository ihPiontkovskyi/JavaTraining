package com.bank.validator.impl;

import com.bank.domain.User;
import com.bank.exception.InvalidFieldException;
import com.bank.validator.Validator;

import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {

    @Override
    public void validate(User entity) throws InvalidFieldException {
        if (entity == null) {
            throw new IllegalArgumentException("User is null!");
        }
        if (!validateEmail(entity.getEmail())) {
            throw new InvalidFieldException("Unsupported Email");
        }
        if (!validatePass(entity.getPassword())) {
            throw new InvalidFieldException("Unsupported Password");
        }
    }

    private boolean validatePass(String pass) {
        if (pass == null) {
            return false;
        }
        return Pattern.matches("^\\w{4,}$", pass);
    }

    private boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        return Pattern.matches("^\\w{4,}@\\w+.[a-zA-Z]+$", email);
    }
}
