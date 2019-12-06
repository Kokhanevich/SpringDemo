package com.example.demo.payload.request;

import javax.validation.constraints.NotNull;

public class LoginRequest {


    @NotNull
    private String login;


    @NotNull
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
