package com.bank.rep;

import com.bank.domain.User;
import com.bank.repository.UserRepository;
import com.bank.repository.impl.UserRepositoryImpl;
import com.bank.utility.CollectionUtility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserRepositoryTest {
    private UserRepository repository;

    @Before
    public void initRepository() {
        repository = new UserRepositoryImpl();
        repository.save(User.builder()
                .withEmail("email")
                .withId(1)
                .withPassword("password")
                .withAccounts(CollectionUtility.nullSafeListInitialize(null))
                .build());
    }

    @After
    public void clearRepository() {
        repository = null;
    }

    @Test
    public void findByEmailShouldReturnNull() {
        Assert.assertNull(repository.findByEmail(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByIdShouldThrowIllegalArgument() {
        repository.findById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateShouldThrowIllegalArgument() {
        repository.update(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveShouldThrowIllegalArgument() {
        repository.save(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveShouldThrowIllegalArgument2() {
        repository.save(User.builder().withId(1).build());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateShouldThrowIllegalArgument2() {
        repository.update(User.builder().withId(2).build());
    }

    @Test
    public void findByEmailShouldReturnUser() {
        Assert.assertNotNull(repository.findByEmail("email"));
    }

    @Test
    public void findByIdShouldReturnUser() {
        Assert.assertNotNull(repository.findById(1));
    }

    @Test
    public void deleteByIdRepositoryTest() {
        int initialSize = repository.findAll().size();
        repository.deleteById(1);
        Assert.assertEquals(initialSize - 1, repository.findAll().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteByIdRepositoryTestShouldThrowIllegalArgument() {
        repository.deleteById(null);
    }

    @Test
    public void updateUserShouldUpdate() {
        User current = repository.findById(1);
        User user = User.builder()
                .withId(current.getId())
                .withEmail(current.getEmail() + "email")
                .withPassword(current.getPassword())
                .withAccounts(current.getAccounts()).build();
        repository.update(user);
        Assert.assertNotEquals(current, repository.findById(1));
    }
}
