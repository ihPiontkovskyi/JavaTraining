package com.bank.repository;

import com.bank.domain.Account;
import com.bank.domain.User;
import com.bank.repository.impl.AccountRepositoryImpl;
import com.bank.utility.CollectionUtility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AccountRepositoryTest {
    private AccountRepository repository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

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

    @Test
    public void findByIdShouldThrowIllegalArgument() {
        exception.expect(IllegalArgumentException.class);
        repository.findById(null);
    }

    @Test
    public void updateShouldThrowIllegalArgument() {
        exception.expect(IllegalArgumentException.class);
        repository.update(null);
    }

    @Test
    public void saveShouldThrowReturnFalse() {
        Assert.assertFalse(repository.save(null));
    }

    @Test
    public void saveShouldReturnFalse2() {
        Assert.assertFalse(repository.save(new Account(1, null, null)));
    }

    @Test
    public void updateShouldThrowIllegalArgument2() {
        exception.expect(IllegalArgumentException.class);
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
