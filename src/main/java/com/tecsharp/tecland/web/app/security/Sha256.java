package com.tecsharp.tecland.web.app.security;

import static com.tecsharp.tecland.web.app.security.HashUtils.isEqual;
import static com.tecsharp.tecland.web.app.security.HashUtils.sha256;


public class Sha256 {


    public String computeHash(String password, String salt, String username) {

        return "$SHA$" + salt + "$" + sha256(sha256(password) + salt);
    }


    public boolean comparePassword(String password, String hashedPassword, String username) {
        String hash = hashedPassword;
        String[] line = hash.split("\\$");
        return line.length == 4 && isEqual(hash, computeHash(password, line[2], username));
    }


    public int getSaltLength() {
        return 16;
    }

}
