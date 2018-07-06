/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.user;

import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class RUser {
    
    private int id;
    private String alias;
    private String about;
    private ArrayList<Integer> ignoredUsers = new ArrayList();
    
}
