package com.bank.util;

import com.bank.utility.PasswordEncrypt;
import org.junit.Assert;
import org.junit.Test;

public class PasswordEncryptTest {
    private String pass = "12345678";

    @Test
    public void testEncryptAndCheckShouldReturnTrue() {
        Assert.assertTrue(PasswordEncrypt.checkPw(pass, PasswordEncrypt.encrypt(pass)));
    }
    @Test
    public void testEncryptAndCheckShouldReturnFalse() {
        Assert.assertFalse(PasswordEncrypt.checkPw("1234567", PasswordEncrypt.encrypt(pass)));
    }
}
