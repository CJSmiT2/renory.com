/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.main;

import java.util.ArrayList;
import com.renory.secure.user.UserSecure;

/**
 *
 * @author smit
 */
class UsersWorker {
    
    UserSecure getBySession(String sessionId, ArrayList<UserSecure> users) {
        for (UserSecure user:users){
            try{
                if (user.getSessionId().equals(sessionId)) {
                    return user;
                }
            }catch (NullPointerException ex){
            }
        }
        
        UserSecure user = new UserSecure();
        user.setIsGuest();
        return user;
    }

    UserSecure getUserByLogin(String login, ArrayList<UserSecure> users) {
        for (UserSecure user:users){
            if (user.getLogin().equalsIgnoreCase(login)) {
                return user;
            }
        }
        
        throw new RuntimeException("User by login not found! login: " + login);
    }

    boolean theUserIsset(String login, ArrayList<UserSecure> users) {
        for (UserSecure user:users){
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

}
