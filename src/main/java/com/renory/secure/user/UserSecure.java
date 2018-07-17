/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author smit
 */
public class UserSecure {
    private int id;
    private String login;
    private String nickName;
    private String password;
    private String sessionId;
    private UserType type;
    private UserStatus status;
    private String email;
    private long timeOfRegistration;
    private long timeOfLastLogin;
    
    private ArrayList<String> lastIpsLogined = new ArrayList();
    private ArrayList<String> groups = new ArrayList();
    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    public boolean isGuest(){
        return type==UserType.GUEST;
    }
    
    public boolean isMember(){
        return type==UserType.MEMBER;
    }
    
    public boolean isModerator(){
        return type==UserType.MODERATOR;
    }
    
    public boolean isRoot(){
        return type==UserType.ROOT;
    }
    
    public boolean isAdmin(){
        return type==UserType.ADMIN;
    }
    
    public boolean isManager(){
        return type==UserType.MANAGER;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserStatus getStatus() {
        return status;
    }
    
    
    
    public boolean isOkStatus(){
        return status == UserStatus.OK;
    }
    
    public boolean isBannedStatus(){
        return status == UserStatus.BANNED;
    }
    
    public void setIsOkStatus() {
        status = UserStatus.OK;
    }
    
    public void setIsBannedStatus() {
        status = UserStatus.BANNED;
    }
    
    

    public void setIsMember() {
        type = UserType.MEMBER;
    }
    
    public void setIsGuest() {
        type = UserType.GUEST;
    }
    
    public void setIsRoot() {
        type = UserType.ROOT;
    }
    
    public void setIsAdmin() {
        type = UserType.ADMIN;
    }

    public void setIsManager() {
        type = UserType.MANAGER;
    }
    
    public void setIsModerator() {
        type = UserType.MANAGER;
    }
    
    public void setType(UserType type){
        this.type = type;
    }
    
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public UserType getType() {
        return type;
    }

    public long getTimeOfRegistration() {
        return timeOfRegistration;
    }

    public void setTimeOfRegistration(long timeOfRegistration) {
        this.timeOfRegistration = timeOfRegistration;
    }

    public long getTimeOfLastLogin() {
        return timeOfLastLogin;
    }

    public void setTimeOfLastLogin(long timeOfLastLogin) {
        this.timeOfLastLogin = timeOfLastLogin;
    }

    public void setRandomSession() {
        this.sessionId = String.valueOf(new Random().nextInt());
    }

    public ArrayList<String> getLastIpsLogined() {
        return lastIpsLogined;
    }

    public void setLastIpsLogined(ArrayList<String> lastIpsLogined) {
        this.lastIpsLogined = lastIpsLogined;
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }
    
    public boolean issetInGroup(String groupName){
        for (String group:groups){
            if (group.equalsIgnoreCase(groupName)){
                return true;
            }
        }
        return false;
    }
    
    public void addInGroup(String groupName) {
        this.groups.add(groupName);
    }

    public void removeGroup(String groupName) {
        Iterator<String> i = groups.iterator();
        while (i.hasNext()) {
           String s = i.next();
           if (s.equalsIgnoreCase(groupName)){
               i.remove();
           }
        }
    }

    @Override
    public String toString() {
        return "UserAuth{" + "id=" + id + ", login=" + login + ", nickName=" + nickName + ", password=" + password + ", sessionId=" + sessionId + ", type=" + type + ", status=" + status + ", email=" + email + ", timeOfRegistration=" + timeOfRegistration + ", timeOfLastLogin=" + timeOfLastLogin + ", lastIpsLogined=" + lastIpsLogined + ", groups=" + groups + '}';
    }

    


    
}
