package com.bank.service.validator;

import com.bank.domain.User;
import com.bank.exception.InvalidFieldException;
import com.bank.service.validator.impl.UserValidator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserValidatorTest {

    private Validator<User> validator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void init() {
        validator = new UserValidator();
    }

    @Test
    public void validateTestShouldThrowEx() {
        exception.expect(IllegalArgumentException.class);
        validator.validate(null);
    }

    @Test
    public void validateTestShouldThrowEx1() {
        exception.expect(InvalidFieldException.class);
        validator.validate(User.builder().build());
    }

    @Test
    public void validateTestShouldThrowEx2() throws InvalidFieldException {
        exception.expect(InvalidFieldException.class);
        validator.validate(User.builder().withEmail("asd@asd.a").withPassword("12345678").build());
    }

    @Test
    public void validateTestShouldNotThrowEx() {
        validator.validate(User.builder().withEmail("asda@asda.aa").withPassword("12345678").build());
    }
}
