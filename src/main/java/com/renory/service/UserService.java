/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.model.entity.user.RUser;

/**
 *
 * @author smit
 */
public interface UserService {
    
    RUser getUser(String login);
    
    void createUser(String login);
    
    boolean isUserExist(int id);
}
