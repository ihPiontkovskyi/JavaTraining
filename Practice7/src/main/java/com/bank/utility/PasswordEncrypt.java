package com.bank.utility;

import static org.mindrot.jbcrypt.BCrypt.checkpw;
import static org.mindrot.jbcrypt.BCrypt.gensalt;
import static org.mindrot.jbcrypt.BCrypt.hashpw;

public class PasswordEncrypt {
    private PasswordEncrypt() {
    }

    public static String encrypt(String pass) {
        return hashpw(pass, gensalt());
    }

    public static boolean checkPw(String pass, String hash) {
        return checkpw(pass, hash);
    }
}
