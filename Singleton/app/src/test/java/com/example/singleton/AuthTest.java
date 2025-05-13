package com.example.singleton;

import android.hardware.usb.UsbInterface;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

public class AuthTest{

    static  Usuario create(){

        Random random = new Random();
        String id = String.valueOf(random.nextLong());
        String id2 = String.valueOf(random.nextLong());
        Date exp = new Date();
        return new

    }

    @Test
    public void testUser(){


        AuthToken token = new AuthToken(id2, exp);
        Usuario usuario = new Usuario(id, "Mario", "cc@gmail.co", token);

        Assert.assertEquals(usuario.getName(), "Mario");
        Assert.assertEquals(usuario.getEmail(), "cc@gmail.co");
        Assert.assertNotNull(usuario.authToken);

    }

    @Test
    public void testTokenExpired() {

        Usuario usuario = AuthTest.create();
        Assert.assertFalse(Authenticator.getInstance().isLogged(usuario));

    }

    @Test
    public void testTokenNotExpired() {

    }

    @Test
    public void testTokenSuccess() {

    }

    @Test
    public void testUserIsLogged() {

        Usuario usuario = AuthTest.create();
        String id2 = String.valueOf(new Random().nextLong());


    }

    @Test
    public void testUserIsNotLogged() {

    }

}
