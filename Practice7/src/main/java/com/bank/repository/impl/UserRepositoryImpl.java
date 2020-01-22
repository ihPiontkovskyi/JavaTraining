package com.bank.repository.impl;

import com.bank.domain.User;
import com.bank.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Integer, User> userIdToUser = new HashMap<>();

    @Override
    public Optional<User> findByEmail(String email) {
        return userIdToUser.values().stream().filter(o -> o.getEmail().equals(email)).findFirst();
    }

    @Override
    public boolean save(User entity) {
        if (entity != null) {
            if (!userIdToUser.containsKey(entity.getId())) {
                userIdToUser.put(entity.getId(), entity);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public User findById(Integer id) {
        if (id != null) {
            return userIdToUser.get(id);
        } else {
            throw new IllegalArgumentException("Id is null");
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userIdToUser.values());
    }

    @Override
    public void update(User entity) {
        if (entity != null) {
            if (userIdToUser.containsKey(entity.getId())) {
                userIdToUser.put(entity.getId(), entity);
            } else {
                throw new IllegalArgumentException("There is no user with the same id");
            }
        } else {
            throw new IllegalArgumentException("User is null");
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null) {
            userIdToUser.remove(id);
        } else {
            throw new IllegalArgumentException("Id null");
        }
    }
}