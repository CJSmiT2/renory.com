/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.interfaces;

import com.renory.model.entity.amvrules.AmvPermissions;

/**
 *
 * @author smit
 */
public interface AmvRulesDao {
    
    void write(AmvPermissions rules);
    
    AmvPermissions getByAmvId(int amvId);
    
    void update(AmvPermissions rules);
    
    void delete(AmvPermissions rules);
    
    public void clearDb();
    
}
