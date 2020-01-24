package com.bank.service;

import static org.mindrot.jbcrypt.BCrypt.checkpw;
import static org.mindrot.jbcrypt.BCrypt.gensalt;
import static org.mindrot.jbcrypt.BCrypt.hashpw;

public class PasswordEncrypt {

    public String encrypt(String pass) {
        return hashpw(pass, gensalt());
    }

    public boolean checkPw(String pass, String hash) {
        return checkpw(pass, hash);
    }
}
