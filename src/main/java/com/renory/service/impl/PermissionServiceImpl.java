/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service.impl;

import com.renory.service.AmvService;
import com.renory.service.PermissionService;
import com.renory.service.UserService;

/**
 *
 * @author smit
 */
public class PermissionServiceImpl implements PermissionService{

    @Override
    public boolean userHaveAccessForEdit(int userId, int amvId, UserService userService, AmvService amvService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
