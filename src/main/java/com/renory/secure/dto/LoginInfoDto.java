/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.dto;

/**
 *
 * @author smit
 */
public class LoginInfoDto {
    private String login;
    private String password;

    public LoginInfoDto() {
    }

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

    public boolean isEmpty() {
        return login==null & password==null;
    }

    @Override
    public String toString() {
        return "LoginInfoDto{" + "login=" + login + ", password=" + password + '}';
    }
    
    
}
