package com.renory.secure.dao.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author smit
 */
public class SqlSettings {
    public String login;
    public String password;
    public String host;
    public String base;
    public int port;

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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
    
    public void initForTest(){
        login = "root"; 
        password = "cjsmit"; 
        host = "127.0.0.1"; 
        base = "cms_develop_test"; 
        port = 3306;
    }

    @Override
    public String toString() {
        return "SqlSettings{" + "login=" + login + ", password=" + password + ", host=" + host + ", base=" + base + ", port=" + port + '}';
    }
    
    
}
