/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.model.entity.renoryuser.RUser;

/**
 *
 * @author smit
 */
public interface AuthorsService {
    
    RUser getAuthor(String login);
    
    void createAuthor(String login);
    
    boolean isAuthorExist(int id);
}
