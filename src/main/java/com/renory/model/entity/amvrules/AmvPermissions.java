/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amvrules;

/**
 *
 * @author smit
 */
public class AmvPermissions {
    private int amvId;
    private RulesByUser permissions = new RulesByUser();

    public int getAmvId() {
        return amvId;
    }

    public void setAmvId(int amvId) {
        this.amvId = amvId;
    }

    public RulesByUser getPermissions() {
        return permissions;
    }

    public void setPermissions(RulesByUser permissions) {
        this.permissions = permissions;
    }
    
    
    
}
