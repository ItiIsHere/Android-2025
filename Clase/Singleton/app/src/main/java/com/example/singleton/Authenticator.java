package com.example.singleton;

import java.util.Date;
import java.util.Random;

public class Authenticator {

    private static Authenticator instance = null;
    private Authenticator(){


    }

    public static  Authenticator getInstance(){

        if (instance == null){
            instance = new Authenticator();
        }
        return instance;
    }

    public boolean isLogged(Usuario usuario){

        return !usuario.authToken.isExpired();

    }

    public void logIn (Usuario usuario){

        String id = String.valueOf(new Random().nextLong());
        Date expiration = new Date(System.currentTimeMillis() + 1000000000);
        usuario.setAuthToken(new AuthToken(id, expiration));
        return usuario;

    }

    public  void logOut(Usuario usuario){
        usuario.setAuthToken(null);

    }

}
