package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.exception.NoSuchUserException;
import com.bank.repository.UserRepository;
import com.bank.service.PasswordEncrypt;
import com.bank.service.UserService;
import com.bank.service.validator.Validator;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    public static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final Validator<User> userValidator;
    private final PasswordEncrypt encryptor;

    public UserServiceImpl(UserRepository userRepository,
                           Validator<User> userValidator, PasswordEncrypt encryptor) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.encryptor = encryptor;
    }

    @Override
    public boolean login(String email, String password) {
        return userRepository.findByEmail(email)
                .map(User::getPassword)
                .filter(pass -> encryptor.checkPw(password, pass))
                .isPresent();
    }

    @Override
    public boolean register(User user) {
        userValidator.validate(user);
        user.setPassword(encryptor.encrypt(user.getPassword()));
        userRepository.save(user);
        return true;
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