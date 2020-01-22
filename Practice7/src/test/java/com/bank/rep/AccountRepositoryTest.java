package com.bank.rep;

import com.bank.domain.Account;
import com.bank.domain.User;
import com.bank.repository.AccountRepository;
import com.bank.repository.impl.AccountRepositoryImpl;
import com.bank.utility.CollectionUtility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountRepositoryTest {
    private AccountRepository repository;

    @Before
    public void initRepository() {
        repository = new AccountRepositoryImpl();
        User user = User.builder()
                .withEmail("email")
                .withId(1)
                .withPassword("password")
                .withAccounts(CollectionUtility.nullSafeListInitialize(null))
                .build();
        repository.save(new Account(1, user, 1000));
    }

    @After
    public void clearRepository() {
        repository = null;
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
        repository.save(new Account(1, null, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateShouldThrowIllegalArgument2() {
        repository.update(new Account(2, null, null));
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
        Account current = repository.findById(1);
        Account account = new Account(current.getId(), current.getUser(), 10);
        repository.update(account);
        Assert.assertNotEquals(current, repository.findById(1));
    }
}
