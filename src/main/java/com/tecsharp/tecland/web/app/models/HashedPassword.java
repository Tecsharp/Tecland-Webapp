package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

public class HashedPassword implements Serializable{

    private static final long serialVersionUID = -9079052877384512776L;
	private final String hash;
    private final String salt;

    public HashedPassword(String hash, String salt) {
        this.hash = hash;
        this.salt = salt;

    }

    public HashedPassword(String hash) {
        this(hash, null);
    }

    public String getHash() {
        return hash;
    }

    public String getSalt() {
        return salt;
    }
}
