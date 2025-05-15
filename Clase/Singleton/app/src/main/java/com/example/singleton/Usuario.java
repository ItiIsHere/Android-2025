package com.example.singleton;

import androidx.annotation.Nullable;

public class Usuario {

    private String id;
    private String name;
    private String email;
    AuthToken authToken;

    public Usuario(String id, String name, String email, AuthToken authToken) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.authToken = authToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthToken(@Nullable AuthToken newToken){

        this.authToken = newToken;

    }

    public Boolean isExpired(){



    }

}
