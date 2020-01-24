package com.bank.utility;

import com.bank.service.PasswordEncrypt;
import org.junit.Assert;
import org.junit.Test;

public class PasswordEncryptTest {
    private String pass = "12345678";

    private PasswordEncrypt encrypt = new PasswordEncrypt();

    @Test
    public void testEncryptAndCheckShouldReturnTrue() {
        Assert.assertTrue(encrypt.checkPw(pass, encrypt.encrypt(pass)));
    }

    @Test
    public void testEncryptAndCheckShouldReturnFalse() {
        Assert.assertFalse(encrypt.checkPw("1234567", encrypt.encrypt(pass)));
    }
}
