/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service.impl;

import com.renory.secure.user.UserSecure;
import com.renory.service.AmvService;
import com.renory.service.PermissionService;

/**
 *
 * @author smit
 */
public class PermissionServiceImpl implements PermissionService{

    @Override
    public boolean userHaveAccessForManagementAmv(UserSecure userSecure, int amvId, AmvService amvService) {
        if (userSecure.issetInGroup("manager")){
            return true;
        }
        
        if (amvService.userCanManageAmv(userSecure.getId(), amvId)){
            return true;
        }
        
        return false;
    }


    
}
