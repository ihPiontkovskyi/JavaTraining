package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.exception.InvalidFieldException;
import com.bank.repository.UserRepository;
import com.bank.service.UserService;
import com.bank.utility.PasswordEncrypt;
import com.bank.validator.Validator;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserRepository userRepository,
                           Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        String encryptedPassword = PasswordEncrypt.encrypt(password);

        return userRepository.findByEmail(email)
                .map(User::getPassword)
                .filter(pass -> pass.equals(encryptedPassword))
                .isPresent();
    }

    @Override
    public boolean register(User user) {
        try {
            userValidator.validate(user);
            user.setPassword(PasswordEncrypt.encrypt(user.getPassword()));
            userRepository.save(user);
            return true;
        } catch (InvalidFieldException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
}