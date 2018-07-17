/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.dao.dto;

import java.sql.Timestamp;

/**
 *
 * @author smit
 */
public class UserDaoDto {
    private int id;
    private String login;
    private String nickName;
    private String password;
    private String sessionId;
    private String type;
    private String status;
    private String email;
    private Timestamp timeOfRegistration;
    private Timestamp timeOfLastLogin;
    private String lastIpsLogined;
    private String groups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getTimeOfRegistration() {
        return timeOfRegistration;
    }

    public void setTimeOfRegistration(Timestamp timeOfRegistration) {
        this.timeOfRegistration = timeOfRegistration;
    }

    public Timestamp getTimeOfLastLogin() {
        return timeOfLastLogin;
    }

    public void setTimeOfLastLogin(Timestamp timeOfLastLogin) {
        this.timeOfLastLogin = timeOfLastLogin;
    }

    public String getLastIpsLogined() {
        return lastIpsLogined;
    }

    public void setLastIpsLogined(String lastIpsLogined) {
        this.lastIpsLogined = lastIpsLogined;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "UserDaoDto{" + "id=" + id + ", login=" + login + ", nickName=" + nickName + ", password=" + password + ", sessionId=" + sessionId + ", type=" + type + ", status=" + status + ", email=" + email + ", timeOfRegistration=" + timeOfRegistration + ", timeOfLastLogin=" + timeOfLastLogin + ", lastIpsLogined=" + lastIpsLogined + ", groups=" + groups + '}';
    }
    
    

    


    
    
}
