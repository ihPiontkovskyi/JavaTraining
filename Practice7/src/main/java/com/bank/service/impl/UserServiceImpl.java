package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.exception.InvalidFieldException;
import com.bank.exception.NoSuchUserException;
import com.bank.repository.UserRepository;
import com.bank.service.UserService;
import com.bank.service.validator.Validator;
import com.bank.utility.PasswordEncrypt;

import java.util.List;
import java.util.Optional;

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
        return userRepository.findByEmail(email)
                .map(User::getPassword)
                .filter(pass -> PasswordEncrypt.checkPw(password,pass))
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
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NoSuchUserException("No such user!");
    }
}