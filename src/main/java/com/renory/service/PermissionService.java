/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.secure.user.UserSecure;

/**
 *
 * @author smit
 */
public interface PermissionService {
    
    public boolean userHaveAccessForManagementAmv(UserSecure userSecure, int amvId, AmvService amvService);
}
