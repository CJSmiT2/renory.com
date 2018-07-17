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
public class CheckUserUniqeData {

    private final ArrayList<UserSecure> users;
    
    public CheckUserUniqeData(ArrayList<UserSecure> users) {
        this.users = users;
    }

    boolean theLoginUniqe(String login) {
        for (UserSecure user:users){
            if (user.getLogin().equalsIgnoreCase(login)) return false;
        }
        return true;
    }

    boolean theNickNameUniqe(String nickName) {
        for (UserSecure user:users){
            if (user.getNickName().equalsIgnoreCase(nickName)) return false;
        }
        return true;
    }

    boolean theEmailUniqe(String email) {
        for (UserSecure user:users){
            if (user.getEmail().equalsIgnoreCase(email)) return false;
        }
        return true;
    }
    
}
