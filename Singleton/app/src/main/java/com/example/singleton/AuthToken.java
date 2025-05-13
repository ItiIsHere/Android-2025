package com.example.singleton;

import java.util.Date;

public class AuthToken {

    String id;
    Date expiration;

    public AuthToken(String id, Date expiration) {
        this.id = id;
        this.expiration = expiration;
    }

    public Boolean isExpired() {
        Date exp = usuario.authToken.expiration;
        Date now = new Date();
        long diff = exp.getTime() - now.getTime();
        return diff > 0;
    }
}
