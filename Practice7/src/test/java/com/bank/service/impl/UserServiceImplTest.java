package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.exception.InvalidFieldException;
import com.bank.exception.NoSuchUserException;
import com.bank.repository.UserRepository;
import com.bank.service.PasswordEncrypt;
import com.bank.service.validator.Validator;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String ENCODED_PASSWORD = "encoded_password";
    private static final String PASSWORD = "password";
    private static final String USER_EMAIL = "user@gmail.com";
    private static final Integer USER_ID = 1;
    private static final String INCORRECT_PASSWORD = "INCORRECT_PASSWORD";
    private static final String ENCODE_INCORRECT_PASSWORD = "encode_incorrect_password";

    private static final User USER =
            User.builder()
                    .withEmail(USER_EMAIL)
                    .withId(USER_ID)
                    .withPassword(ENCODED_PASSWORD)
                    .build();

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncrypt passwordEncriptor;
    @Mock
    private Validator<User> userValidator;

    @InjectMocks
    private UserServiceImpl userService;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @After
    public void resetMocks() {
        reset(userRepository, passwordEncriptor, userValidator);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        when(passwordEncriptor.checkPw(eq(PASSWORD), anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));

        final boolean isLogin = userService.login(USER_EMAIL, PASSWORD);

        assertTrue(isLogin);
        verify(passwordEncriptor).checkPw(eq(PASSWORD), anyString());
        verify(userRepository).findByEmail(eq(USER_EMAIL));
        verifyZeroInteractions(userValidator);
    }

    @Test
    public void userShouldNotLoginAsThereIsNotUserWithSuchEmail() {
        when(passwordEncriptor.checkPw(eq(PASSWORD), anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        final boolean isLogin = userService.login(USER_EMAIL, PASSWORD);

        assertFalse(isLogin);
        verify(userRepository).findByEmail(eq(USER_EMAIL));
        verifyZeroInteractions(userValidator);
    }

    @Test
    public void userShouldNotLoginAsPasswordIsIncorrect() {
        when(passwordEncriptor.checkPw(eq(INCORRECT_PASSWORD), anyString())).thenReturn(false);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));

        final boolean isLogin = userService.login(USER_EMAIL, INCORRECT_PASSWORD);

        assertFalse(isLogin);
        verify(userRepository).findByEmail(eq(USER_EMAIL));
        verifyZeroInteractions(userValidator);
    }

    @Test
    public void userShouldRegisterSuccessfully() {
        doNothing().when(userValidator).validate(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(true);

        final boolean actual = userService.register(USER);

        assertTrue(actual);
        verify(userValidator).validate(any(User.class));
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void userShouldNotRegisterWithInvalidPasswordOrEmail() {
        exception.expect(InvalidFieldException.class);
        doThrow(InvalidFieldException.class).when(userValidator).validate(any(User.class));
        userService.register(USER);
    }

    @Test
    public void userShouldNotRegisterAsEmailIsAlreadyUsed() {
        exception.expect(RuntimeException.class);
        doNothing().when(userValidator).validate(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));
        doNothing().when(userRepository).save(any(User.class));

        userService.register(USER);
    }

    @Test
    public void findAllShouldReturnList() {
        when(userRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        List<User> actual = userService.findAll();
        assertEquals(Collections.EMPTY_LIST, actual);
        verify(userRepository).findAll();
    }

    @Test
    public void findByIdShouldReturnUser() {
        when(userRepository.findById(USER_ID)).thenReturn(USER);
        User actual = userService.findById(USER_ID);
        assertEquals(USER, actual);
        verify(userRepository).findById(USER_ID);
    }

    @Test
    public void findByEmailShouldReturnUser() {
        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.of(USER));
        User actual = userService.findByEmail(USER_EMAIL);
        assertEquals(USER, actual);
        verify(userRepository).findByEmail(USER_EMAIL);
    }

    @Test
    public void findByEmailShouldThrowNoSuchUserException() {
        exception.expect(NoSuchUserException.class);
        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.empty());
        userService.findByEmail(USER_EMAIL);
    }
}