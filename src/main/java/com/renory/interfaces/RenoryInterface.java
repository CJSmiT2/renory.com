/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.interfaces;

import com.renory.entity.base.Amv;

/**
 *
 * @author smit
 */
public interface RenoryInterface {
    
    Amv get(String alias);
    
    int createSt1(int userId, String title, String body);
    
    boolean createSt2(int userId, int amvId, String fds);
    
    
    
    
}
