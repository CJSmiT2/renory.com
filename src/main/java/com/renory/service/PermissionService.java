/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

/**
 *
 * @author smit
 */
public interface PermissionService {
    
    boolean userHaveAccessForEdit(int userId, int amvId, UserService userService, AmvService amvService);
}
