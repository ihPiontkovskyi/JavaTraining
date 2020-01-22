package com.bank.valid;

import com.bank.domain.User;
import com.bank.exception.InvalidFieldException;
import com.bank.validator.Validator;
import com.bank.validator.impl.UserValidator;
import org.junit.Before;
import org.junit.Test;

public class UserValidatorTest {


    private Validator<User> validator;

    @Before
    public void init() {
        validator = new UserValidator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateTestShouldThrowEx() throws InvalidFieldException {
        validator.validate(null);
    }

    @Test(expected = InvalidFieldException.class)
    public void validateTestShouldThrowEx1() throws InvalidFieldException {
        validator.validate(User.builder().build());
    }

    @Test(expected = InvalidFieldException.class)
    public void validateTestShouldThrowEx2() throws InvalidFieldException {
        validator.validate(User.builder().withEmail("asd@asd.a").withPassword("12345678").build());
    }

    @Test
    public void validateTestShouldNotThrowEx() throws InvalidFieldException {
        validator.validate(User.builder().withEmail("asda@asda.aa").withPassword("12345678").build());
    }
}
